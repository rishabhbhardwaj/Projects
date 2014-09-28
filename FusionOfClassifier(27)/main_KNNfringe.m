[a b]=getvecKNNfringe();
disp('getvec done');
c=gettestKNNfringe();
disp('gettest done');
d=knn(c,a,b,4);
disp('knn done');
confumat=zeros(27,27);
k=1;
for i=1:27,
    for j=1:15,
        ind=d(k);
        confumat(ind,i)=confumat(ind,i)+1;
        k=k+1;
    end
end
csvwrite('confusion_matrix-KNNfringe',confumat);
accu=trace(confumat)/sum(confumat(:))*100