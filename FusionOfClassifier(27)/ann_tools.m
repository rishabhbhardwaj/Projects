function [ret]=ann_tools(P,T)
%This is for testing
File_Name='data\F';
I_U=20;
Img_test_vec=zeros(I_U,0);
for i=1:27,
   
    for j=26:40,
        NFile_Name=strcat(File_Name,sprintf('%03d%s',i,'\test1\'));
        N_File_Name=strcat(NFile_Name,sprintf('000%d.tif',j));
        Image=imread(N_File_Name);
        Image=Img_procc(Image);
        [Ig_vec y]=c_vector(Image);
        Ig_vec=[Ig_vec(1,:) Ig_vec(2,:)];
        Img_test_vec=[Img_test_vec Ig_vec'];
        %end
        %Img_test_vec
    end
  %HO_WM
end
Ptest=Img_test_vec;
% Creating and training of the Neural Network
Ptr=P;
Ttr=T;
size(P)
size(T)
net = edu_createnn(Ptr,Ttr);
save('net-ann-struc','net');
% Testing the Neural Network
[a,b]=max(sim(net,Ptest));
%disp(a);
%disp(b);
%disp('size of b')
%size(b)
confumat=zeros(27,27);
k=1;
for i=1:27,
    for j=1:15,
        ind=b(k);
        confumat(ind,i)=confumat(ind,i)+1;
        k=k+1;
    end
end
save('annstrucmodel');
csvwrite('confusion_matrix-ANNstruc',confumat);
disp('accuracy')
accu=trace(confumat)/sum(confumat(:))*100
