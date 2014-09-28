function [vecf,y]=c_vector(subIm)
% Extraction of subImages
Iedge2=subIm;
    [Ilabel num] = bwlabel(Iedge2);%return the 8-connected components with num containing the number of components. 
%disp(Ilabel);
%imshow(Iedge2);
Iprops = regionprops(Ilabel,'BoundingBox');%it returns the properties of each components in Ilabel such as bounding area.
vecf=zeros(2,0);
vec=zeros(2,1);
sz=10;
y=100/sz;
ImageN = imcrop(Iedge2, Iprops(1).BoundingBox);
%%subplot(10,num./10,1), imshow(ImageN)
ImageN=imresize(ImageN,[100 100]);

for cnt=1:y
    %%subImage = imcrop(Iedge2, Iprops(1).BoundingBox);
    ii=sz;
    subImage=ImageN(1:50,1+(cnt-1)*ii:cnt*ii);
    %%subplot(10,10,cnt), imshow(subImage)
    %%resize image
    %subImage=imresize(subImage,[40 40]);
    %%retrive image features
    pixel=0;
    for j=1:50,
        for k=1:ii,
            if(subImage(j,k)==1),
            pixel=pixel+1;
            end
        end
    end
    %pixel
    %ct=feature_vec(subImage);
    %%cnt
    vec(1,1)=pixel;
   % code=eye(ii*100);
    %%v
    
    subImage=ImageN(51:100,1+(cnt-1)*ii:cnt*ii);
    %%subplot(10,10,cnt), imshow(subImage)
    %%resize image
    %subImage=imresize(subImage,[40 40]);
    %%retrive image features
    pixel=0;
    for j=1:50,
        for k=1:ii,
            if(subImage(j,k)==1),
            pixel=pixel+1;
            end
        end
    end
    vec(2,1)=pixel;
    vecf=[vecf vec];
end
vecf=vecf/500;
end