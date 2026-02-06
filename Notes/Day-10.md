# Trees:
**A Tree is a non linear hierarchical data structure that consists of nodes connected by edges. It is used to represent hierarchical relationships between elements, such as organized structures, file systems, or expression parsing.**


							  _____
							 |  A  |  (Root)                    (Level 0)
							  -/---\
						   	  /     \
						  ___/       \ __
						 | B |       | C |                      (Level 1)
						  -/\-        -/-\
					   ___/  \___    _/_  \___
		(Parent Node) | D |  | E |  | F | | G |                 (Level 2)
					   /-|    ---|   --\- -|--
				   ___/  |___   _|_   ^ \__|---> (Siblings)
	(Child Node)  | H |  | I | | J |  |                         (Level 3)
				   ---   ---    ---   |
                       ^              (Leaf Node)
					   |
					(Sub-Tree)

---
1. **Basic Terminology:**
	1. **Path:**
		It refers to the sequence of nodes along the edges of a tree.
	2. **Root:**
		 The node at the top of the tree is called the root. There is only one root per tree and form path from the root node to any node.
	3. **Parent:**
		 Any node except the root node has one edge upward to a node is called the parent,
	4. **Child:**
		The node below a given node connected by its edge downward is called its child node.
	5. **Leaf:**
		The node which doesn't have any child node is called as leaf node.
	6. **Subtree:**
		Subtree represents the descendants of the node.
	7. **Visiting:**
		It refers to checking the values of a node when control is on the node.
	8. **Traversing:**
		It means passing through nodes in a specific order.
	9. **Levels:**
		It represents the generation of a node if the root is at level 0, then its next child node is at level 1. It's to be carried out for a node.
	10. **Keys:**
		It represents a value of a node based on which a search operation is to be carried out for a node.

2. **Types of Trees:**
	These are three main types of trees:
	1. **General Trees:**
		They are unordered tree data structures where the root node has minimum 0 or maximum n subtrees. The general trees have no constraint placed on their 				hierarchy. The root node thus acts like the superset of all the other subtrees.
	2. **Binary Trees:**
		They are general trees in which the root node can hold up to a maximum of 2 subtrees. Left subtree and right subtree. Based on the number of children, 				binary trees are divided into three types:
		1. **Full Binary Tree:**
				A full binary tree is a binary tree where every node has either 0 or 2 child nodes.
		2. **Complete Binary Tree:**
				It is a binary tree where all the leaf nodes must be on the same level. However, root and internal nodes in a complete binary tree can have 0, 						1 or 2 child nodes.
		3. **Perfect Binary Tree:**
				It is a binary tree where all the leaf node are on the same level and every node except leaf node has 2 children.

1. **In-order Traversal**: l, R, r
2. **Pre-order Traversal**: R, l, r
3. **Post-order Traversal**: l, r, R
```
R -> Root
l -> Left
r -> Right
```
