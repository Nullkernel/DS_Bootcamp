# Data:
**It refers to raw data, facts, values or figures.**

## Data Type:
It defines the kind of data a variable can hold and the operations that  can be performed on it.

- They are categorized into two types:
	1. **Built-In data types:**
		These are primitive data types that are directly supported by the programming language. Ex: `int` - Integer value, `char` - Single characters, `float` - Decimal value, `bool` - Boolean values, `String` - Sequence of characters. 
	2. **Derived data types:**
		These are the data type that are constructed using one or more built-in types and operators. They are typically used to model more complex data structures and are often language independent in concept. Ex: Arrays, List, Stack, Queue, Trees, etc. These structures are fundamentals for organizing and manipulating collections.
## Data Structures:
It is is a way to organize, store and manage data, so that it can be used efficiently in a computer program.
It defines:
- How data can be stored in memory.
- How you can access and manipulate it.

**Basic operations that we can use to perform operations on data structures:**
- **Traversal**: Accessing each element of the data structure.
- **Searching**: Finding a specific element.
- **Insertion**: Adding a new element.
- **Deletion**: Removing an existing element.
- **Sorting**: Arranging elements in particular order.
- **Merging**: Combining two or more data structures.

**Types of data structures:**
There are 2 major types of data structures, they are:
- **Linear data structure:**
	- Here, elements are arranged sequentially or linearly, where each element is connected to its previous and next elements. These structures are simple to implement and are often used when data needs to be processed in order.
	- Ex:
		- **Arrays:** Fixed size collection of similar data types.
		- **Linked List:** A series of nodes where each node contains data and a pointer to the next node.
		- **Stack:** Follows Last-In-First-Out (L.I.F.O) principle.
		- **Queue:** Follows First-In-First-Out (F.I.F.O) principle.
- **Non - Linear data structure:**
	- Here, elements are not arranged in a sequential manner. Instead they follow a hierarchical or interconnected structure, allowing for more complex relationships between data elements.
	- Ex:
		- **Tree**: A hierarchical structure consisting of nodes, with a single node and sub-nodes (children).
		- **Graph**: A set of nodes connected by edges, used to represent networks.

```
					Data Structures:
							||
		 ------------------------------------------
		||                                        ||
	    \/                                        \/
	   Linear                                  Non-Linear
	   ||_____________________                    ||
	   ||      ||      ||     ||                  ||----------------
	   \/      \/      \/     \/                  ||        ||     ||
	   Arrays  Linked  Stack  Queue               \/        \/     \/
	           List                              Graph     Trees  Tries
```

### Static and Dynamic Data Structures:
Data structures can be categorized based on how memory is allocated and managed during program execution. The two types are:

- **Static Data Structure:**
	- Here, memory is allocated at compile time and remains fixed throughout the program's lifecycle. This means the size of the data structure must be known in advance.
	- **Ex**: Arrays.
- **Dynamic Data Structure:**
	- It allows memory allocation to occur at runtime. They can grow or shrink in size needed, making them more flexible and space efficient.
	- **Key Characteristics:**
		- Memory is allocated as needed during execution.
		- Supports flexible insertion and allocation.
		- Minimizes memory waste for unpredictable data sizes.
		- **Ex**: Linked List, Stack and Queue.
