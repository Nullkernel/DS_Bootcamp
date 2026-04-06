# Hashing

**Hashing:** It is a fundamental technique in data structures used to store and retrieve data with an average time 
complexity of O(1). In a hash table, a new index is processed using the keys and the element corresponding to 
that key is stored in the index.This process is known as hashing.
Let k be a key and h(x) be a hash function.
here, h(k) will give us a new index to store the element linked with k.

### **Componenets of Hashing:** 
There are majorly three components of hashing:
- **key:** A key can a string or integer which is fed as input in the hash function the technique that determines 
an index or location for storage of an item in a data structure.
- **Hash Function:** The hash function recieves the input key and returns the index of an element in an array called 
a hash table. The index is known as hash index.
- **Hash Table:** It is a data structure that maps keys tp values using a special function called a hash function. 
Hash stores the data in an associative manner in an array where each data value has its own unique function.

### **Hash functions:** 
There are many hash functions that use numeric or alphanumeric keys. Different hash functions are:
- **Division method:**

  
    <img width="530" height="244" alt="image" src="https://github.com/user-attachments/assets/57bf9d14-bd95-4cc0-b16a-cef3de540345" />

- **Mid square method:**
    Example:\n
    K = 50\n
    k*8 k = 2500\n
    h(k) = 50\n
    The hash value obtained is 50
- Folding method
- Multiplication method
