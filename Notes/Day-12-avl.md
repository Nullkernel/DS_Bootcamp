# AVL Tree Data Structure:
An AVL tree defined as a self-balancing Binary Search Tree (BST), where the difference between heights of left and right subtrees for any node cannot be more than one.

Balance Factor = left subtree height - right subtree height  
For a Balanced Tree(for every node): -1 ≤ Balance Factor ≤ 1
## Example of an AVL Tree:
The balance factors for different nodes are: 12 : +1, 8 : +1, 18 : +1, 5 : +1, 11 : 0, 17 : 0 and 4 : 0. Since all differences are lies between -1 to +1, so the tree is an AVL tree.

![Example-of-an-AVL-Tree-11](https://media.geeksforgeeks.org/wp-content/uploads/20250703161306662411/Example-of-an-AVL-Tree-11.webp "Click to enlarge")
### Example of a BST which is not an AVL Tree:
The Below Tree is **not** an AVL Tree as the balance factor for nodes **8** and **12** is more than ***1***.

![Example-of-an-AVL-Tree-22](https://media.geeksforgeeks.org/wp-content/uploads/20250703161407500927/Example-of-an-AVL-Tree-22.webp "Click to enlarge")
### Important Points about AVL Tree:
- ***Rotations***: rotations are designed to restore balance in ***O(1)*** time while ensuring the overall time complexity remains ***O(log n)***. AVL Trees use ***four cases*** to rebalance themselves after insertions and deletions: Left-Left (LL), Right-Right (RR), Left-Right (LR) and Right-Left (RL).

- ***Insertion and Deletion***: While insertion is followed by upward traversals to check balance and apply rotations, deletion can be more complex due to multiple rotations possibly being required. AVL Trees may require multiple rebalancing steps during deletion, unlike Red-Black Trees which limit this better.
### Rotating the subtrees (Used in Insertion and Deletion):
An AVL tree may rotate in one of the following four ways to keep itself balanced while making sure that the BST properties are maintained.
#### 1. ***Left-Left Case:***
- Occurs when a node is inserted into the left subtree of the left child, causing the balance factor to become ***more than +1***.
- ***Fix:*** Perform a single ***right*** rotation.
- **Example:**
	- ![Right-Rotation-1.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703184251571200/Right-Rotation-1.webp "Click to enlarge")
	- ![Right-Rotation-2.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703184251352710/Right-Rotation-2.webp "Click to enlarge")
	- ![Right-Rotation-3.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703184251101372/Right-Rotation-3.webp "Click to enlarge")
### ***2***. ***Right-Right Case:***
- Occurs when a node is inserted into the right subtree of the right child, making the balance factor ***less than -1***.
- ***Fix:*** Perform a single ***left*** rotation.
- **Example:**
	- ![Left-Rotation-1.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703161622198503/Left-Rotation-1.webp "Click to enlarge")
	- ![Left-Rotation-2.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703161633244282/Left-Rotation-2.webp "Click to enlarge")
	- ![Left-Rotation-3.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703161632819474/Left-Rotation-3.webp "Click to enlarge")
### 3. ***Left-Right Case:***
- ***Occurs when*** a node is inserted into the right subtree of the left child, which disturbs the balance factor of an ancestor node, making it ***left-heavy***.
- ***Fix:*** Perform a left rotation on the left child, followed by a right rotation on the node.
- **Example:**
	- ![Left-Right-Rotation-1.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162021694784/Left-Right-Rotation-1.webp "Click to enlarge")
	- ![Left-Right-Rotation-2.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162021349283/Left-Right-Rotation-2.webp "Click to enlarge")
	- ![Left-Right-Rotation-3.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162021126024/Left-Right-Rotation-3.webp "Click to enlarge")
	- ![Left-Right-Rotation-4.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162020895696/Left-Right-Rotation-4.webp "Click to enlarge")
	- ![Left-Right-Rotation-5.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162020592915/Left-Right-Rotation-5.webp "Click to enlarge")
### ***4***. ***Right-Left Case:***
- Occurs when a node is inserted into the left subtree of the right child, which disturbs the balance factor of an ancestor node, making it ***right-heavy***.
- ***Fix:*** Perform a right rotation on the right child, followed by a left rotation on the node.
- **Example:**
	- ![Right-Left-Rotation-1.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162208119967/Right-Left-Rotation-1.webp "Click to enlarge")
	- ![Right-Left-Rotation-2.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162207628962/Right-Left-Rotation-2.webp "Click to enlarge")
	- ![Right-Left-Rotation-3.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162207268338/Right-Left-Rotation-3.webp "Click to enlarge")
	- ![Right-Left-Rotation-4.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162207051865/Right-Left-Rotation-4.webp "Click to enlarge")
	- ![Right-Left-Rotation-5.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250703162206654926/Right-Left-Rotation-5.webp "Click to enlarge")
## Insertion in an AVL Tree:
AVL tree is a self-balancing Binary Search Tree (***BST***) where the difference between heights of left and right subtrees cannot be more than ***one*** for all nodes.

**Insertion in an AVL Tree follows the same basic rules as in a Binary Search Tree (BST):**
- A new key is placed in its correct position based on BST rules (left < node < right).
- After the insertion, the ***balance factor*** of each node is checked during the path back up to the root. If any node becomes ***unbalanced*** (i.e., its balance factor becomes less than -1 or greater than +1), a ***rotation*** is required to restore the AVL property.
- ![right_left_rotation_127.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251209164929467359/right_left_rotation_127.webp)
- ![right_left_rotation_128.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251209164929734110/right_left_rotation_128.webp)
- ![right_left_rotation_129.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251209164930014564/right_left_rotation_129.webp)
- ![right_left_rotation_130.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251209164930323197/right_left_rotation_130.webp)
# Deletion in an AVL Tree:
***Steps to follow for deletion***.   
To make sure that the given tree remains AVL after every deletion, we must augment the standard BST delete operation to perform some re-balancing. Following are two basic operations that can be performed to re-balance a BST without violating the BST property (keys(left) < key(root) < keys(right)). 
1. Left Rotation.
2. Right Rotation.
3. ![Deletion-in-an-AVL-Tree_](https://media.geeksforgeeks.org/wp-content/uploads/20250618171252397002/Deletion-in-an-AVL-Tree_.webp "Click to enlarge")
- ***Example:***
	- ![AVL-Tree-1.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250619175617748006/AVL-Tree-1.webp)
	- ![AVL-Tree-2.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250619175617954518/AVL-Tree-2.webp)
	- ![AVL-Tree-3.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250619175618109177/AVL-Tree-3.webp)
	- ![AVL-Tree-4.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250619175618247698/AVL-Tree-4.webp)
	- ![AVL-Tree-5.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250619175618381482/AVL-Tree-5.webp)
	- ![AVL-Tree-6.webp](https://media.geeksforgeeks.org/wp-content/uploads/20250619175618519288/AVL-Tree-6.webp)
