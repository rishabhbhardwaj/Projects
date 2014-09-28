function [ClassIndex]=predictClass(Istruc,Ifringe,NumClass,ANNstrucCM,KNNstrucCM,SVMstrucCM,SVMfringeCM,KNNfringeCM)
%Istruc is a structural feat vec,Ifri is fringe feat vec

%finding class index predicted by each classifier
%which sim(ANNstrucNet)
load 'annstrucmodel'
[a1,b1]=max(sim(net,Istruc));
ANNstrucInd=b1(1);
clear 'annstrucmodel'
KNNstrucInd=FindClassKNNstruc(Istruc);
SVMstrucInd=FindClassSVMstruc(Istruc,NumClass);
SVMfringeInd=FindClassSVMfringe(Ifringe,NumClass);
KNNfringeInd=FindClassKNNfringe(Ifringe);

%claculating confidences of each classifier for the predicted class
confScoreStruc=zeros(1,NumClass);
confScoreFringe=zeros(1,NumClass);
confScore=zeros(1,NumClass);
%ANN struct
confANNstruc=ANNstrucCM(ANNstrucInd,ANNstrucInd);
[m,n]=size(ANNstrucCM);
s=0;
for i=1:m,
    s=s+ANNstrucCM(i,ANNstrucInd);
end
confANNstruc=confANNstruc/s;
confScoreStruc(ANNstrucInd)=confScoreStruc(ANNstrucInd)+confANNstruc;
%KNN struct
confKNNstruc=KNNstrucCM(KNNstrucInd,KNNstrucInd);
[m,n]=size(KNNstrucCM);
s=0;
for i=1:m,
    s=s+KNNstrucCM(i,KNNstrucInd);
end
confKNNstruc=confKNNstruc/s;
confScoreStruc(KNNstrucInd)=confScoreStruc(KNNstrucInd)+confKNNstruc;
%SVM struct
confSVMstruc=SVMstrucCM(SVMstrucInd,SVMstrucInd);
[m,n]=size(SVMstrucCM);
s=0;
for i=1:m,
    s=s+SVMstrucCM(i,SVMstrucInd);
end
confSVMstruc=confSVMstruc/s;
confScoreStruc(SVMstrucInd)=confScoreStruc(SVMstrucInd)+confSVMstruc;
%SVM fringe
confSVMfringe=SVMfringeCM(SVMfringeInd,SVMfringeInd);
[m,n]=size(SVMfringeCM);
s=0;
for i=1:m,
    s=s+SVMfringeCM(i,SVMfringeInd);
end
confSVMfringe=confSVMfringe/s;
confScoreFringe(SVMfringeInd)=confScoreFringe(SVMfringeInd)+confSVMfringe;
%KNN fringe
confKNNfringe=KNNfringeCM(KNNfringeInd,KNNfringeInd);
[m,n]=size(KNNfringeCM);
s=0;
for i=1:m,
    s=s+KNNfringeCM(i,KNNfringeInd);
end
confSVMfringe=confSVMfringe/s;
confScoreFringe(KNNfringeInd)=confScoreFringe(KNNfringeInd)+confKNNfringe;

%Find Class (index) with max score
index=0;
maxScore=0;
for i=1:NumClass,
    if confScoreStruc(i)~=0
        confScoreStruc(i)=confScoreStruc(i)*((distCent_struc(Istruc',i))/maxvar_struc(Istruc',i));
    end
end
for i=1:NumClass,
    if confScoreFringe(i)~=0
        confScoreFringe(i)=confScoreFringe(i)*((distCent_fringe(Ifringe',i))/maxvar_fringe(Ifringe',i));
    end
end
for i=1:NumClass,
    confScore(i)=confScoreStruc(i)+confScoreFringe(i);
end
for i=1:NumClass,     
    if confScore(i) > maxScore
        maxScore=confScore(i);
        index=i;
    end
end
%confScore
ClassIndex=index;
end

