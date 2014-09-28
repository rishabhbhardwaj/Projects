function [Class] = FindClassKNNstruc(test2vec)
[a b]=getvecKNNstruc();
d=knn(test2vec,a,b,4);
Class=d;
end