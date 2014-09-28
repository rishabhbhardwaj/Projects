function d = cveucliddist(X,Y)
V=ones(size(X));
U=ones(size(Y));
d = abs(X'.^2*U - 2*X'*Y + V'*Y.^2); 
end

