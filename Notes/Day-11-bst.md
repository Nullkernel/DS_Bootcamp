# Binary Search Tree:

## What it is:
- A Binary Search Tree (BST) is a binary tree data structure that stores elements (keys) in a sorted hierarchical form so that for every node:
    - All keys in the left subtree are strictly less than the node's key.
    - All keys in the right subtree are strictly greater than the node's key.
- This invariant lets each comparison discard about half of the remaining tree on average, making searches, insertions, and deletions faster than linear scans for well-balanced trees.

## Example (visual):

```
            11
           /   \
         2      29
        /  \   /   \
       1   7  15   40
                   /
                 35
```

- In-order traversal of this tree produces a sorted sequence: `1, 2, 7, 11, 15, 29, 35, 40`.

## Properties & notes:
- Keys are usually unique. If duplicates are allowed, pick a consistent policy (e.g., store duplicate counts in the node, or always insert equal keys to the left or right).
- Structure shape matters: a balanced BST has height `O(log n)`, while a degenerate (chain-like) BST has height `O(n)`.
- Many practical variants (AVL, Red-Black, B-trees) maintain balance to guarantee good worst-case time bounds.

## Operations:
### Search:
- Description: Find whether a key exists (and optionally return the node or its parent).
- Steps (iterative):
    - Start at the root.
    - While `node != NULL`:
        - If `key == node.key`, return node (found).
        - If `key < node.key`, move to `node.left`.
        - Else move to `node.right`.
    - If you reach `NULL`, the key is not present.
- Notes: Simple, single-pass down the tree.

### Insertion:
- Description: Insert a new key while preserving the BST invariant. New nodes are inserted as leaves.
- Steps (iterative):
    - If root is `NULL`, create root node with key.
    - Else, start at root and keep a `parent` pointer:
        - If `key < node.key`, go left; if left is `NULL`, attach new node as `parent.left`.
        - If `key > node.key`, go right; if right is `NULL`, attach new node as `parent.right`.
        - If duplicates disallowed and `key == node.key`, handle according to chosen policy (ignore, count, or place consistently).
- Notes: No rotations/rehangs unless using a self-balancing BST variant.

### Deletion:
- Description: Remove a node while preserving the BST invariant. There are three main cases.
- Case 1 - Node is a leaf (no children):
    - Simply remove it (set the appropriate child pointer of its parent to `NULL`).
- Case 2 - Node has one child:
    - Replace the node with its single child (connect parent of node to the child).
- Case 3 - Node has two children:
    - Replace the node's key with either its in-order successor (the smallest key in the right subtree) or its in-order predecessor (the largest key in the left subtree).
    - Then delete that successor/predecessor node (which will be a simpler case: it has at most one child).
    - Using the in-order successor:
        - `succ = min(node.right)` (go to `node.right` then follow `.left` until `NULL`).
        - `node.key = succ.key`
        - Delete `succ` from the right subtree (recursive or iterative).
- Notes: Choose successor or predecessor consistently; both are correct.

## Traversals & common utilities:
- In-order: Left - Root - Right - yields sorted keys.
- Pre-order: Root - Left - Right - useful for copying the tree or prefix expressions.
- Post-order: Left - Right - Root - useful for deleting/freeing nodes.
- Height/Depth: height = longest path from node to leaf; useful for complexity analysis.

## Time & space complexity:
- For a BST with `n` nodes and height `h`:
    - Search: average `O(h)`.
    - Insertion: average `O(h)`.
    - Deletion: average `O(h)`.
- When tree is balanced (height `h = O(log n)`):
    - Average / typical-case: `O(log n)` for search/insert/delete.
- Worst-case (completely unbalanced, like a linked list):
    - `O(n)` for search/insert/delete.
- Space:
    - Storage for nodes: `O(n)` (each node stores key + pointers).
    - Auxiliary recursion stack: `O(h)` for recursive operations (iterative versions use `O(1)` extra).

## Quick implementation notes:
- Iterative insertion/search is straightforward and avoids recursion stack overhead.
- Deletion is the trickiest operation; draw small trees and practice the three cases to be confident.
