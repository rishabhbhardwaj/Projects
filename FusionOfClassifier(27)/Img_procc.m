function [img]=Img_procc(Image)
Image=imresize(Image,[32 32]);
%% Convert to grayscale image
Igray = Image;%rgb2gray(Image);
%%imshow(Igray)

%% Convert to binary image
Ibw = im2bw(Igray,graythresh(Igray));
%%imshow(Ibw)

%%Aplly median filter for removing noise.
Ibw=medfilt2(Ibw,[2 2]);
%%imshow(Ibw);

%Take negative of Image for applying the component connevtivity function.
Iedge =imcomplement(Ibw);
%%imshow(Iedge)

%Image Dilation
se = strel('square',2);% function for creating structuring element.
Iedge2 = imdilate(Iedge, se); 
%imshow(Iedge2); 
img=Iedge2;
end