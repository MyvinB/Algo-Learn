Internal Working of 

loadFactor 0.75
capacity = size * loadfactor

HashMap -> 16 buckets 
index = hashcode & (length-1)

Why logic ?
Using a bitwise AND operator is similar to doing bit masking wherein only the lower bits of the hash integer are considered which in turn provides a very efficient method of calculating the modulus based on the length of the hashmap.

static final int TREEIFY_THRESHOLD = 8;
https://medium.com/javarevisited/internal-working-of-hashmap-in-java-97aeac3c7beb

HashSet -> Uses hasmap internaly and a final static present variable as its object

ArraysList size is 10 
