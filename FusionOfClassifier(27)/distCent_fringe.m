function [dis] = distCent_fringe(Ifringe,c)
%Calculates distance of feat vec from centroid of class c 
load('centroid-fringe','centroid_f');
cent=zeros(1,1024);
for i=1:1024,
    cent(i)=centroid_f(c,i);
end
d=0;
for i=1:1024,
    d=d+(cent(i)-Ifringe(i))^2;
end
d=sqrt(d);
dis=d;
end

