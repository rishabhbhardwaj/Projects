function [ max_variance ] = maxvar_fringe(Ifringe,c)
%Calculates maximum of variance of each dimensions when Istruc is included
%in class c
filef='D:\matlab_test\fusion_profinal(27)\save\';
filef=strcat(filef,sprintf('%03d%c',c,'f'));
load(filef,'i2');
p=i2;
p=p';
p=[p Ifringe'];
p=p';
mx=0;
[x,y]=size(p);
for i=1:1024,
    %calc variance in dimension i
    mean=0;
    for j=1:x,
        mean=mean+p(j,i);
    end
    mean=mean/x;
    s=0;
    for j=1:x,
        s=s+((p(j,i)-mean)^2);
    end
    s=sqrt(s);
    s=s/x;
    if s>mx
        mx=s;
    end
end
max_variance=mx;
end

