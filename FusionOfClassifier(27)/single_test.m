function [ Class ] = single_test(fileName )
%Image I is i/p and Class is o/p Class of our classifier

I=imread(fileName);
Image=I;
Image=Img_procc(Image);
[Ig_vec y]=c_vector(Image);
Ig_vec=[Ig_vec(1,:) Ig_vec(2,:)];
Istruc=Ig_vec';
Image=I;
Image=imresize(Image,[32 32]);
Image=im2bw(Image,0.5);
Ig=fringe1(Image);
Ig=imagefromvec(Ig);
Ifringe=Ig';

%loading confusion matrix
ANNstrucCM=load('confusion_matrix-ANNstruc');
KNNstrucCM=load('confusion_matrix-KNNstruc');
SVMstrucCM=load('confusion_matrix-SVMstruc');
SVMfringeCM=load('confusion_matrix-SVMfringe');
KNNfringeCM=load('confusion_matrix-KNNfringe');

k=predictClass(Istruc,Ifringe,50,ANNstrucCM,KNNstrucCM,SVMstrucCM,SVMfringeCM,KNNfringeCM);
Class=k;
end

