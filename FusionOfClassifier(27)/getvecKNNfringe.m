function [X L] = getvecKNNfringe()
File_Name='data\F';
Img_vec=[];
label=[];
var=0;
for i=1:27, %for folder name
    for j=1:50, %for image name
        NFile_Name=strcat(File_Name,sprintf('%03d%s',i,'\train\'));
        N_File_Name=strcat(NFile_Name,sprintf('000%d.tif',j));
        Image=imread(N_File_Name);      
        Image=imresize(Image,[32 32]);
        Image=im2bw(Image,0.5);
        Ig=fringe1(Image);
        Ig=imagefromvec(Ig);
        Img_vec=[Img_vec Ig'];
        label=[label i];        
    end
end
X=Img_vec;
L=label;