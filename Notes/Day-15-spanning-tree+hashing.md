# What is a Spanning Tree?
- **A spanning tree is a subset of a graph `G`, which has all the vertices covered with minimum possible number of edges.**
- **Example:**
```
		A         A          A         A
	   / \  =>   / \  (or)  /    (or)   \
	  C---B     C   B      C---B     C---B
```
### Applications of Spanning Tree:
- Civil Network Planning.
- Computer Network Routing Protocol.
- Cluster Analysis.
# Hash Table:
- ![Introduction-to-Hashing](https://media.geeksforgeeks.org/wp-content/uploads/20240807120551/Introduction-to-Hashing.webp "Click to enlarge")
- Hash table is a data structure which stores data in an associative manner.
- In a hash table, data is stored in an array format, where each data value has its own unique index value.
- Access of data becomes very fast if we know the index of the desired data.
- Thus, it becomes a data structure in which insertion and search operations are very fast irrespective of the size of data.
- Hash Table uses an array as a storage medium and uses hashing techniques to generate an index, where an technique is used to generate an index, where an element is to be inserted or to be located from.
- ![Components-of-Hashing](https://media.geeksforgeeks.org/wp-content/uploads/20240508162701/Components-of-Hashing.webp "Click to enlarge")
# Hashing:
- **Hashing is a technique to convert a range of key values into a range of indexes of an array.**
- We're going to use modulo operator to get a range of key values.
- Consider an example of hash table of size 20, and the following items are to be stored.
- Item are in the (key, value) format.
## Types of Hash functions:
There are mainly hash functions that use numeric or alphanumeric keys.
**The different types of hashing functions are:**
1. Division Method.
2. Multiplication Method.
3. Mid-Square Method.
4. Folding Method.
5. Cryptographic Hash Functions.
6. Universal Hashing.
7. Perfect Hashing.
## Collision Resolution Techniques:
There are mainly two methods to handle collision:
1. Separate Chaining
2. Open Addressing
![Collision-Resolution-Techniques](https://media.geeksforgeeks.org/wp-content/uploads/20240514124402/Collision-Resolution-Techniques.webp "Click to enlarge")
### 1) Separate Chaining:
- The idea behind Separate Chaining is to make each cell of the hash table point to a linked list of records that have the same hash function value. Chaining is simple but requires additional memory outside the table.
- ***Example***: We have given a hash function and we have to insert some elements in the hash table using a separate chaining method for collision resolution technique.

> Hash function = key % 5,  
> Elements = 12, 15, 22, 25 and 37.

**Let's see step by step approach to how to solve the above problem:**
- ![Separate-Chaining-1.webp](https://media.geeksforgeeks.org/wp-content/uploads/20241220122112343763/Separate-Chaining-1.webp "Click to enlarge")
- ![Separate-Chaining-2.webp](https://media.geeksforgeeks.org/wp-content/uploads/20241220122112514567/Separate-Chaining-2.webp "Click to enlarge")
- ![Separate-Chaining-3.webp](https://media.geeksforgeeks.org/wp-content/uploads/20241220122112638135/Separate-Chaining-3.webp "Click to enlarge")
- ![Separate-Chaining-4.webp](https://media.geeksforgeeks.org/wp-content/uploads/20241220122112766037/Separate-Chaining-4.webp "Click to enlarge")
- ![Separate-Chaining-5.webp](https://media.geeksforgeeks.org/wp-content/uploads/20241220122112889463/Separate-Chaining-5.webp "Click to enlarge")
