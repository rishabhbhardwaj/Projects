%% file naming and taking input
File_Name='data\F';
I_U=20;
H_U=10;
O_U=27;
Img_vec=[];
Img_vec=zeros(I_U,0);
T=zeros(27,0);
idseq=eye(27);
for i=1:27,
   % Error_sq=0;
    for j=1:50,
        NFile_Name=strcat(File_Name,sprintf('%03d%s',i,'\train\'));
        N_File_Name=strcat(NFile_Name,sprintf('000%d.tif',j));
        Image=imread(N_File_Name);
        Image=Img_procc(Image);
        [Ig_vec y]=c_vector(Image);
        Ig_vec=[Ig_vec(1,:) Ig_vec(2,:)];
        Img_vec=[Img_vec Ig_vec'];
        T=[T idseq(:,i)];
        %end
        %Img_vec
    end
  %HO_WM
end
%size(Img_vec)
ann_tools(Img_vec,T);
