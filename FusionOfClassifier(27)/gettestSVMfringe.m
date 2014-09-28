function [X] = gettestSVMfringe()
File_Name='data\F';
Img_vec=[];
for i=1:27, %for folder name
    for j=26:40, %for image name
        NFile_Name=strcat(File_Name,sprintf('%03d%s',i,'\test1\'));
        N_File_Name=strcat(NFile_Name,sprintf('000%d.tif',j));
        Image=imread(N_File_Name);
        Image=imread(N_File_Name);
        Image=imresize(Image,[32 32]);
        Image=im2bw(Image,0.5);
        Ig=fringe1(Image);
        Ig=imagefromvec(Ig);
        Img_vec=[Img_vec Ig'];
    end
end
X=Img_vec';
disp('getest done');
size(X)

end

