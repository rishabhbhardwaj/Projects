File_Name='data\F';
files='';
filef='';
for i=1:27,
    Img_struc=[];
    Img_fringe=[];
    files='D:\matlab_test\fusion_profinal(27)\save\';
    filef='D:\matlab_test\fusion_profinal(27)\save\';
    files=strcat(files,sprintf('%03d%c',i,'s'));
    filef=strcat(filef,sprintf('%03d%c',i,'f'));
    for j=26:40,
        NFile_Name=strcat(File_Name,sprintf('%03d%s',i,'\test1\'));
        N_File_Name=strcat(NFile_Name,sprintf('000%d.tif',j));
        I=imread(N_File_Name);
        Image=I;
        Image=Img_procc(Image);
        [Ig_vec y]=c_vector(Image);
        Ig_vec=[Ig_vec(1,:) Ig_vec(2,:)];
        Img_struc=[Img_struc Ig_vec'];
        Image=I;
        Image=imread(N_File_Name);      
        Image=imresize(Image,[32 32]);
        Image=im2bw(Image,0.5);
        Ig=fringe1(Image);
        Ig=imagefromvec(Ig);
        Ifringe=Ig;
        Img_fringe=[Img_fringe  Ifringe'];
        
    end
    i1=Img_struc';
    i2=Img_fringe';
   % i1
    %csvwrite(files,'i1'); 
    %csvwrite(filef,'i2');
    save(files,'i1');
    save(filef,'i2');
end

