# Task Proposals from Codebase Review

## 1) Typo fix task
**Task:** Correct the typo `Adjaceny Matrix` to `Adjacency Matrix` in the Graphs section of `README.md`.

**Why this matters:** It is a user-facing spelling mistake in the top-level project documentation and can make the repository look less polished.

**Acceptance criteria:**
- `README.md` uses the spelling `Adjacency Matrix`.
- No other accidental content changes are introduced.

## 2) Bug fix task
**Task:** Repair `Searching-algorithms/Fibonaccisearch.java` so it compiles and runs correctly.

**Observed issues:**
- Public class name/file mismatch: `DS_Fibonaccisearch` is declared inside `Fibonaccisearch.java`.
- Duplicate local variable declarations (`fnminus1` and `fnminus2`) inside `fibonaccisearch`.
- `fn` is used before initialization.

**Acceptance criteria:**
- The file compiles with `javac`.
- Fibonacci search returns correct indices for present keys and `-1` for absent keys on sorted arrays.

## 3) Comment/documentation discrepancy task
**Task:** Clarify graph-direction behavior documentation around `Data-Structures/Graphs/Dijkstra.java`.

**Observed discrepancy:**
- `addEdge(...)` currently adds both directions (undirected), but the inline comment says `remove this line for directed graph`.
- This comment describes a manual code edit instead of clear API behavior, which is easy to misinterpret.

**Acceptance criteria:**
- Replace the ambiguous inline note with clear behavior documentation (e.g., explicit `addUndirectedEdge` and optional `addDirectedEdge`, or a method-level Javadoc that states exact behavior).
- A reader can tell whether the example is directed or undirected without editing source lines.

## 4) Test improvement task
**Task:** Add a lightweight compile-smoke test that validates Java source integrity across the repo.

**Why this matters:**
- Current issues (like class/file naming mismatches and duplicate declarations) are detectable at compile time but currently slip through.

**Acceptance criteria:**
- Add a script or CI step that attempts to compile all `.java` files (or each folder target) and fails on compiler errors.
- Document how to run the test locally.
- Ensure at least one negative case from current failures is prevented in future PRs.
