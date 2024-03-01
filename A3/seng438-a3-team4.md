**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:      |     |
| -------------- | --- |
| Student Names: | Uruba Alam |
|                | Naina Gupta |
|                | Ding Kai Wu |
|                | Chuhang Qi |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

Text…

# 2 Manual data-flow coverage calculations for X and Y methods

## DataUtilities.calculateColumnTotal

**Data Flow Graph**

![alt text](DFG.png)

**Def-Use Sets**

| calculateColumnTotal |
| --- |
| def(1) = {data, column, total} <br> use(1) = {data} |
| def(2) = {total, rowCount} <br> use(2) = {data} |
| def(3) = {r} <br> use(3) = {r, rowCount} |
| def(4) = {n} <br> use(4) = {data, n} |
| def(5) = {} <br> use(5) = {total, n} |
| def(6) = {r2} <br> use(6) = {r2, rowCount} |
| def(7) = {n} <br> use(7) = {data, n} |
| def(8) = {} <br> use(8) = {total, n} |
| def(9) = {} <br> use(9) = {total} |

**DU-Pairs**

| calculateColumnTotal |
| --- |
| du(1, 1, data) = {1} |
| du(1, 2, data) = {1, 2} |
| du(1, 4, data) = {1, 2, 3, 4} |
| du(1, 7, data) = {1, 2, 3, 6, 7} |
| du(3, 3, r) = {3} |
| du(2, 3, rowCount) = {2, 3} |
| du(2, 6, rowCount) = {2, 3, 6} |
| du(4, 4, n) = {4} |
| du(4, 5, n) = {4, 5} |
| du(7, 7, n) = {7} |
| du(7, 8, n) = {7, 8} |
| du(1, 5, total) = {1, 2, 3, 4, 5} |
| du(1, 8, total) = {1, 2, 3, 4, 5, 6, 7, 8} |
| du(1, 9, total) = {1, 2, 3, 6, 9}, {1, 9} |

**Parts Covered**

| Test Case | Parts Covered |
| --- | --- |
| calculateColumnTotalTest | du(1, 1, data), du(1, 2, data), du(1, 4, data), du(3, 3, r), du(2, 3, rowCount), du(2, 6, rowCount), du(4, 4, n), du(4, 5, n), du(2, 5, total), du(1, 9, total) |
| calculateColumnTotalNegativeTest | du(1, 1, data), du(1, 2, data), du(1, 4, data), du(3, 3, r), du(2, 3, rowCount), du(2, 6, rowCount), du(4, 4, n), du(4, 5, n), du(2, 5, total), du(1, 9, total) |
| calculateColumnTotalZeroTest | du(1, 1, data), du(1, 2, data), du(1, 4, data), du(3, 3, r), du(2, 3, rowCount), du(2, 6, rowCount), du(4, 4, n), du(4, 5, n), du(2, 5, total), du(1, 9, total) |
| calculateColumnTotalNullTest | du(1, 9, total) |
| calculateColumnTotalExceptionTest | du(1, 9, total) |
| calculateColumnTotalMinMaxTest | du(1, 1, data), du(1, 2, data), du(1, 4, data), du(3, 3, r), du(2, 3, rowCount), du(2, 6, rowCount), du(4, 4, n), du(4, 5, n), du(2, 5, total), du(1, 9, total) |
| calculateColumnTotalColumnOneTest | du(1, 1, data), du(1, 2, data), du(1, 4, data), du(3, 3, r), du(2, 3, rowCount), du(2, 6, rowCount), du(4, 4, n), du(4, 5, n), du(2, 5, total), du(1, 9, total) |

**DU-Pair Coverage**

TR for data = 4 paths <br>
Test paths = 3 paths <br>
Coverage = 75%

TR for r = 1 path <br>
Test paths = 1 path <br>
Coverage = 100%

TR for rowCount = 2 paths <br>
Test paths = 2 paths <br>
Coverage = 100%

TR for n = 2 paths <br>
Test paths = 2 paths <br>
Coverage = 100%

TR for n = 2 paths <br>
Test paths = 0 paths <br>
Coverage = 0%

TR for total = 3 paths <br>
Test paths = 3 paths <br>
Coverage = 100%

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report (Naina and Uruba

Text…

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed (Naina and Uruba)

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
