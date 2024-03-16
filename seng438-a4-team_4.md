**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:   |  4 |
| -------------- | --- |
| Student Names: |  Uruba Alam   |
|                |   Naina Gupta  |
|                |   Ding Kai Wu   |
|                |    Chuhang Qi |

# 1. Introduction


# 2. Analysis of 10 Mutants of the Range class 

# 3. Report all the statistics and the mutation score for each test class

# 4. Analysis drawn on the effectiveness of each of the test classes

# 5. A discussion on the effect of equivalent mutants on mutation score accuracy
Some equivalent mutants were the Incremented and Decremented mutants (post and pre) where a lot of the surviving code was because we didn't test the values after they returned a value. These equivalent mutants can be fixed using decimal values or using the class fields after they have been used once. 

Another type of equivalent mutants is the negated conditional mutations where the condition statement (for an if, while or for loop) is negated and therefore the mutants that survived after the negation are easy to fix, since all we had to do was make tests for testing those specific conditions as well as testing the false input values and compare it with the right values. 

Another common mutant was one that replaced the conditional statements with constant true or false, this was an easy fix and decreased our mutation score accuracy due to there being a lack of variety in the test cases with different equivalence inputs. The constant true or false can be easily killed with assertTrue or assertFalse lines in the new test cases. 

# 6. A discussion of what could have been done to improve the mutation score of the test suites

# 7. Why do we need mutation testing? Advantages and disadvantages of mutation testing

# 8. Explain your SELENUIM test case design process

# 9. Explain the use of assertions and checkpoints

# 10. how did you test each functionaity with different test data

# 11. Discuss advantages and disadvantages of Selenium vs. Sikulix

# 12. How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
