function [ Class ] = FindClassSVMfringe(Ifringe,NumClass)
TestSet=Ifringe;
result = zeros(length(TestSet(:,1)),1);
load('svmfringemodel');
for j=1:size(TestSet,1)
    for k=1:NumClass
        if(svmclassify(models(k),TestSet(j,:))) 
            break;
        end
    end
    result(j) = k;
end
clear 'svmfringemodel'
Class=result(1);
end

