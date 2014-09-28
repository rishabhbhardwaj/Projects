%%Calculate Centroid for each class and store it in a vector in a file
%%name centroid.mat
n1=20;
n2=1024;
c_s_vec=[];
c_f_vec=[];
for i=1:27,
    c_s=zeros(1,n1);
    c_f=zeros(1,n2);
    files='D:\matlab_test\fusion_profinal(27)\save\';
    filef='D:\matlab_test\fusion_profinal(27)\save\';
    files=strcat(files,sprintf('%03d%c',i,'s'));
    filef=strcat(filef,sprintf('%03d%c',i,'f'));
    load(files,'i1');
    load(filef,'i2');
    [x,y]=size(i1);
    for j=1:y,
        s=0;
        for k=1:x,
            s=s+i1(k,j);
        end
        c_s(j)=s/x;
    end
    [x,y]=size(i2);
    for j=1:y,
        s=0;
        for k=1:x,
            s=s+i2(k,j);
        end
        c_f(j)=s/x;
    end
    c_s_vec=[c_s_vec c_s'];
    c_f_vec=[c_f_vec c_f'];
    clear i1;
    clear i2;
end
centroid_s=c_s_vec';
centroid_f=c_f_vec';
save('centroid-struc','centroid_s');
save('centroid-fringe','centroid_f');
            
