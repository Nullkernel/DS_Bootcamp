# Graphs:

## What is a graph?
***A **graph** is an abstract data type (ADT) that models a set of objects and the relationships (links) between them.***
- The objects are called **vertices** (or nodes).
- The links between vertices are called **edges**.  
    Formally, a graph is a pair **G=(V,E)**, where **V** is a set of vertices and **E** is a set of edges (each edge connects a pair of vertices).
## Key terms:
- **Adjacency:** Two vertices are _adjacent_ if there is an edge directly connecting them.
- **Path:** A _path_ is a sequence of vertices connected by edges; it represents a route from one vertex to another.
- **Degree:** The degree of a vertex is the number of edges incident on it (for directed graphs there are indegree and outdegree).
## Common ways to represent graphs:
- **Adjacency matrix**:
    - A **V×V** matrix (where **V** is number of vertices).
    - Entry `[i][j]` is `1` (or `true`) if there is an edge from vertex `i` to `j`; otherwise `0` (or `false`).
    - Pros: O(1) edge-existence checks. Cons: O(V^2) memory - expensive for sparse graphs.
- **Adjacency list**:
    - For each vertex, store a list of its adjacent vertices.
    - Pros: **O(V+E)** memory and efficient to iterate neighbors - good for sparse graphs.
    - Cons: Checking existence of a specific edge may be slower than with a matrix.
## Breadth-First Search (BFS):
BFS traverses a graph level by level (breadth-first). It explores all vertices at distance kkk from the start before vertices at distance **k+1**. BFS uses a **queue** to manage the frontier of vertices to visit.
### When to use BFS:
- Find the shortest path (fewest edges) in an unweighted graph.
- Test connectivity (reachability) from a source.
- Compute levels (distance in edges) from the source.
- Check bipartiteness, build a level graph for flow algorithms, etc.
### BFS algorithm (high-level steps):
1. Create an empty queue and a `visited` set/array.
2. Enqueue the starting vertex `S` and mark `S` as visited (and optionally record level/distance = 0).
3. While the queue is not empty:
    1. Dequeue a vertex `u` and process it (e.g., print or record `u`).
    2. For each neighbor `v` of `u`:
        - If `v` is not visited, mark `v` visited, enqueue `v`, and (optionally) record `v`'s parent or level.
4. Repeat step 3 until the queue becomes empty.
5. When the queue is empty, all vertices reachable from `S` have been visited.
### Step-by-step traversal on the example graph:
```
		 S
	   / | \
	  A  B  C
	   \ | /
	     D
```
**Edges**: (S,A), (S,B), (S,C), (A,D), (B,D), (C,D).
Start at `S`:
- Visit `S` - enqueue its neighbors in some order (A, B, C) and mark them visited.
- Dequeue `A` - visit A; enqueue its unvisited neighbor `D` (mark `D` visited).
- Dequeue `B` - visit B; its neighbor `D` is already visited so skip.
- Dequeue `C` - visit C; `D` already visited so skip.
- Dequeue `D` - visit D; no new neighbors.  
    Final BFS order (one possible order): **S, A, B, C, D**  
    (Levels: `S` at level 0; `A,B,C` at level 1; `D` at level 2.)
### Complexity:
- **Time:** `O(V+E)` - each vertex and edge is processed a constant number of times.
- **Space:** **`O(V)`** for the queue and visited tracking (plus adjacency structure memory).
