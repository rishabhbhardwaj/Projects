function [dis] = distCent_struc(Istruc,c)
%Calculates distance of feat vec from centroid of class c 
load('centroid-struc','centroid_s');
cent=zeros(1,20);
for i=1:20,
    cent(i)=centroid_s(c,i);
end
d=0;
for i=1:20,
    d=d+(cent(i)-Istruc(i))^2;
end
d=sqrt(d);
dis=d;
end

