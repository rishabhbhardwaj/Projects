function [ Class ] = FindClassSVMstruc(Istruc,NumClass)
TestSet=Istruc;
result = zeros(length(TestSet(:,1)),1);
load('svmstrucmodel');
for j=1:size(TestSet,1)
    for k=1:NumClass
        if(svmclassify(models(k),TestSet(j,:))) 
            break;
        end
    end
    result(j) = k;
end
clear 'svmstrucmodel'
Class=result(1);
end

