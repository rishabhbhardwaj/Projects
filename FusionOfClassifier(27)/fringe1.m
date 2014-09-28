function [out]=fringe1(I)
k2=0;
m=1;
a=double(I);
[l1 l2]=size(I);
l=l1;
f=0;
dx=[1 1 0 -1 -1 0 1 -1];
dy=[1 0 1 -1 0 -1 -1 1];
for i=1:l,
    for j=1:l,
        if a(i,j)==1
            a(i,j)=-1;
        end
    end
end
while k2<=l
    f=0;
    for i=1:l,
        for j=1:l,
            if a(i,j)==k2
                f=1;
                for k=1:8,
                    if i+dx(k)>=1 & i+dx(k)<=l & j+dy(k)>=1 & j+dy(k)<=l & a(i+dx(k),j+dy(k))==-1
                        a(i+dx(k),j+dy(k))=m;
                    end
                end
            end
        end
    end
    if f==0
        break;
    end
    k2=k2+1;
    m=m+1;
    %disp('abc');
    %disp(k2);
end
out=a;
end

    