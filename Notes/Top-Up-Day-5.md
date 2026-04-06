
#  Hashing

**Hashing:**
It is a fundamental technique in data structures used to store and retrieve data with an average time complexity of **O(1)**.
In a hash table, an index is computed using a key, and the element corresponding to that key is stored at that index. This process is known as **hashing**.
Let `k` be a key and `h(x)` be a hash function.
Then, `h(k)` gives the index where the element associated with `k` will be stored.

---

## Components of Hashing

There are three main components of hashing:

* **Key:**
  A key can be a string or integer that is used as input to the hash function. It determines the location for storing an item.

* **Hash Function:**
  A function that takes a key as input and returns an index (called the **hash index**) in the hash table.

* **Hash Table:**
  A data structure that maps keys to values using a hash function. It stores data in an associative manner using an array.

---

## Hash Functions

There are various hash functions that work with numeric or alphanumeric keys:

---

#### 1. Division Method

**Concept:**

<img width="530" height="260" alt="image" src="https://github.com/user-attachments/assets/57bf9d14-bd95-4cc0-b16a-cef3de540345" />

Uses modulo operation:

```
h(k) = k % m
```
Where:
* `k` = key
* `m` = size of hash table
---

#### 2. Mid-Square Method

**Concept:**
Square the key and extract the middle digits.

**Example:**
```
k = 50
k² = 2500
Middle digits → 50

h(k) = 50
```
---

#### 3. Folding Method

**Concept:**
The folding method involves dividing the key into equal parts, summing the parts and then taking the modulo with respect to m.

**Steps:**

1. Divide the key into parts
2. Add the parts
3. Take modulo with table size `m`

**Example:**

```
Key = 123456789

Divide into parts: 123, 456, 789
Sum = 123 + 456 + 789 = 1368

h(k) = 1368 % 10 = 8
```

The key `123456789` is stored at index **8**.

---

#### 4. Multiplication Method

**Formula:**

```
h(k) = floor( m * (k * A % 1) )
```

Where:

* `k` = key
* `m` = size of hash table
* `A` = constant (0 < A < 1)

**Concept:**

The hash function used for multiplication method is: h(k) = floor ( n (K A % 1) ). Here, k is the key and A can be any constant value between 0 and 1. Both K and A are multiplied and their fractional part is seperated. This is then multiplied with n to get the hash value.

1. Multiply key `k` with constant `A`
2. Extract the fractional part
3. Multiply by `m`
4. Take the floor value

---
