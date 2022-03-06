Contains important intuitions to commonly asked problems in interview.

DP
---
numberOfArithmeticSlices->LC413
here you understand that if
q) a b c d  
a b c is one slice and b c d is another slice then a b c d is also counted as a slice
hence we can use dp[i] = dp [i-1] +1 when a slice is found
this can be further optimised by using a single variable instead of an arry
we can also solve this with a formula
when we see a slice it follows sum of n number ie 
1 2 3 4 5 6  -> 4+3+2+1 hence we can get the count and find sum of n number that is n(n+1)/2 
    1 2 3 4 
---
