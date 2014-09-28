function [Class] = knn(X,P,label,K)
distFunc=@cveucliddist;
[D,N]=size(X);
%euclid square dist
d=distFunc(X,P); %N*P
[sorted, IndexP] = sort(d'); %P*N
% K closest
IndexP=IndexP(1:K,:);
%disp('IndexProto');
%disp(IndexProto);
KnnClass=label(IndexP); %class of IndexProto from labels
%disp(KnnClass);
% Find all class labels
ClassLabel=unique(label);
nClass=length(ClassLabel);
for i=1:nClass
    %disp('a');
ClassCounter(i,:) = sum(KnnClass == ClassLabel(i)); %Number of Images having label =classlabel
end
[maxi, winnerLabelIndex] = max(ClassCounter, [], 1);
Class = ClassLabel(winnerLabelIndex);

