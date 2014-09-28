function [p]=vecfromimage(I)
[a b]=size(I);
out=zeros(1,a*b);
k=1;
for i=1:a,
    for j=1:b,
        out(k)=I(i,j);
        k=k+1;
    end
end
p=out;
        