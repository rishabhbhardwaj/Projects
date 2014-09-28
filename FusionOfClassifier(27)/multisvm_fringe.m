function [result] = multisvm_fringe(TrainingSet,GroupTrain,TestSet)
u=unique(GroupTrain);
numClasses=length(u);
result = zeros(length(TestSet(:,1)),1);
size(result)
%build models
options = optimset('maxiter',10000000);
for k=1:numClasses
    %Vectorized statement that binarizes Group
    %where 1 is the current class and 0 is all other classes
    G1vAll=(GroupTrain==u(k));
    models(k) = svmtrain(TrainingSet,G1vAll,'Kernel_Function','linear','options',options);
        disp('class ');
        disp(k);
end
%save('svm_models-fringe.mat','models');
%csvwrite('svm_models-struc',models);
%classify test cases
for j=1:size(TestSet,1)
    for k=1:numClasses
        if(svmclassify(models(k),TestSet(j,:))) 
            break;
        end
    end
    result(j) = k;
end
save('svmfringemodel');
end