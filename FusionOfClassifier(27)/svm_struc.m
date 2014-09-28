[X C]=getvecSVMstruc();
T=gettestSVMstruc();
res=multisvm_struc(X,C,T);
confumat=zeros(27,27);
b=res;
k=1;
for i=1:27,
    for j=1:15,
        ind=b(k);
        confumat(ind,i)=confumat(ind,i)+1;
        k=k+1;
    end
end
csvwrite('confusion_matrix-SVMstruc',confumat);
disp('accuracy')
accu=trace(confumat)/sum(confumat(:))*100
