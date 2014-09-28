File_Name='data\F';
tot=0; %Total Files
c=0; %Correctly Classified

%loading confusion matrix
ANNstrucCM=load('confusion_matrix-ANNstruc');
KNNstrucCM=load('confusion_matrix-KNNstruc');
SVMstrucCM=load('confusion_matrix-SVMstruc');
SVMfringeCM=load('confusion_matrix-SVMfringe');
KNNfringeCM=load('confusion_matrix-KNNfringe');
cm=zeros(27,27);
for i=1:27,
    disp('Class');
    disp(i);
    for j=41:50,
        
        NFile_Name=strcat(File_Name,sprintf('%03d%s',i,'\test2\'));
        N_File_Name=strcat(NFile_Name,sprintf('000%d.tif',j));
        I=imread(N_File_Name);
        Image=I;
        Image=Img_procc(Image);
        [Ig_vec y]=c_vector(Image);
        Ig_vec=[Ig_vec(1,:) Ig_vec(2,:)];
        Istruc=Ig_vec';
        Image=I;
        Image=imread(N_File_Name);      
        Image=imresize(Image,[32 32]);
        Image=im2bw(Image,0.5);
        Ig=fringe1(Image);
        Ig=imagefromvec(Ig);
        Ifringe=Ig';
        k=predictClass(Istruc,Ifringe,27,ANNstrucCM,KNNstrucCM,SVMstrucCM,SVMfringeCM,KNNfringeCM);
        if k==i
            c=c+1;
        end
        cm(k,i)=cm(k,i)+1;
        tot=tot+1;
        disp(j);
        
    end
    disp((c/tot)*100);
end
csvwrite('confusion_matrix-MAIN',cm);
disp('Accuracy');
accuracy=(c/tot)*100;
disp(accuracy);

