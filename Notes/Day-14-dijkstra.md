# Single-Source Shortest Path (Dijkstra's Algorithm)
This section covers **Dijkstra's algorithm**, which is used to find the shortest path distance from one source vertex to all other vertices in a weighted graph.
- Works for graphs with **non-negative edge weights**.
- Commonly implemented with a **min-priority queue (min-heap)** for efficiency.

## Problem Statement
Given a weighted graph and a source vertex `src`, find the shortest path distances from `src` to every other vertex.

## Precondition: Non-Negative Edge Weights
Dijkstra's algorithm requires that every edge weight is `>= 0`.

Why this matters:
- The algorithm repeatedly picks the currently smallest tentative distance from the min-heap.
- Once a node is finalized (popped with the smallest distance), Dijkstra assumes that distance can never be improved later.
- With a negative edge, a future path could reduce a distance that was already finalized, breaking this assumption and leading to incorrect results.

So if your graph has negative weights, use **Bellman-Ford** (or another algorithm that supports them) instead.

## Text Algorithm (Adjacency List + Min-Heap)
1. **Initialize distances**:
   - Set `dist[v] = inf` for every vertex `v`.
   - Set `dist[src] = 0`.
   - Create a min-heap and push `(0, src)`.

2. **Process nodes in min-distance order**:
   - While the heap is not empty, pop `(d, u)` with the smallest `d`.
   - If `d > dist[u]`, skip it (it is a stale heap entry).

3. **Relax all outgoing edges**:
   - For each edge `u -> v` with weight `w`:
     - If `dist[u] + w < dist[v]`, update `dist[v] = dist[u] + w`.
     - Push `(dist[v], v)` into the min-heap.

4. **Finish**:
   - After the heap is exhausted, `dist[]` contains shortest distances from `src` to every reachable vertex.

## Time Complexity (Adjacency List + Binary Heap)
- **Time:** `O((V + E) log V)` (often written as `O(E log V)` for connected sparse graphs).
- **Space:** `O(V + E)` for the graph plus `O(V)` for distances (heap size can grow with relaxations).

## Visual Walkthrough (Supplemental)
Use these images as a visual aid after understanding the text algorithm above:
- ![file.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251113160159617213/file.webp)
- ![file.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251113160159416648/file.webp)
- ![file.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251113160159169679/file.webp)
- ![file.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251113160158768858/file.webp)
- ![file.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251113160158367359/file.webp)
- ![file.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251113160158205471/file.webp)
- ![file.webp](https://media.geeksforgeeks.org/wp-content/uploads/20251113160157897539/file.webp)
