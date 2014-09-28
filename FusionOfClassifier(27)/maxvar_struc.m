function [ max_variance ] = maxvar_struc(Istruc,c)
%Calculates maximum of variance of each dimensions when Istruc is included
%in class c
files='D:\matlab_test\fusion_profinal(27)\save\';
files=strcat(files,sprintf('%03d%c',c,'s'));
load(files,'i1');
p=i1;
p=p';
p=[p Istruc'];
p=p';
mx=0;
[x,y]=size(p);
for i=1:20,
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

