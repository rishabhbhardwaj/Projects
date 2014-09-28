function [Class] = FindClassKNNfringe(test2vec)
[a b]=getvecKNNfringe();
d=knn(test2vec,a,b,4);
Class=d;
end