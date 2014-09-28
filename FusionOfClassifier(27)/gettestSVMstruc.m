function [X] = gettestSVMstruc()
File_Name='data\F';
Img_vec=[];
for i=1:27, %for folder name
    for j=26:40, %for image name
        NFile_Name=strcat(File_Name,sprintf('%03d%s',i,'\test1\'));
        N_File_Name=strcat(NFile_Name,sprintf('000%d.tif',j));
        Image=imread(N_File_Name);
        Image=imread(N_File_Name);
        Image=Img_procc(Image);
        [Ig_vec y]=c_vector(Image);
        Ig_vec=[Ig_vec(1,:) Ig_vec(2,:)];
        %size(Ig_vec)
        Img_vec=[Img_vec  Ig_vec'];
    end
end
X=Img_vec';
disp('getest done');
size(X)

end

