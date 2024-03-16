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

***Analysis of 10 mutants produced by pitest for Range.java class:***

 
**1. Negated conditional → KILLED (Line 90, Mutant 2)**

For the Range constructor this means the condition: if (lower > upper) condition was negated into if (lower <= upper). The test case for checking the upper and lower values when a new object is constructed is testCtorValues() where it uses 50 for the lower value and 4 for the upper value. This test will not call the IllegalArgumentException class since the condition is negated and thus the change in the behaviour of the class will be detected and the mutant is killed.  


 </br>


**2. Negated conditional → SURVIVED (Line 157, Mutant 2)**

This is another negation condition mutation for the intersects method. The test cases failed to recognize the mutant because of the if condition failing and then going into the else statement which then returns true. We can see this in the intersectsBiggerTestRangesOverlaps() test case where the return statement in the else branch:  

return (b0 < this.upper && b1 >= b0); 

will return true, so the mutant, which will cause the if condition on line 157 to be false thus going into the else statement will still be true. We need to fix this by adding more branches aside the if and else that is already there and catch more instances of intersection instead of a certain 1 test.  


 </br>


**3. Less than to greater or equal → KILLED (Line 161, Mutant 33)**

This mutant changes the condition in line 161 in the intersects method: 

 return (b0 < this.upper && b1 >= b0); 

The less than (<) operator is changed into a greater than or equal (>=) to operator. This mutation was detected by the the intersectHalfOverlap() and intersectWithinRange() test cases since they both go into line 161. Changing the less than sign would mean that the else statement (line 161) is automatically false due to the logical AND operator and thus will return false when the return value should be true, thus the assertTrue() method catches the mutation and kills the mutation.  

</br>

 

**4. removed conditional - replaced equality check with true → SURVIVED (Line 189, Mutant 4)**

This mutation changes the constrain function, specifically the If condition on line 189:  

if (!contains(value))  

The condition is replaced with a constant true value and therefore should be caught. The test cases that shouldn’t work are: constrainShouldBePositiveValue(), constrainShouldBeNegativeValue() and constrainShouldBeZero(). However since the condition is true, the code goes through the first If statement and then skips over the inner if and else if statements (since they are false) and returns the result value which would have been the same return value with or without thus the mutant ends up surviving since none of the test cases will fail due to the structure of the code.  


 </br>


**5. Negated double field upper → KILLED  (Line 191, Mutant 1)**

This mutant changes the constrains function line 191:	 

result = this.upper; 

By negating the this.upper into -this.upper. The mutant was caught by the constrainShouldBeUpperBoundaryValue() test case which takes in a value of a 100 and goes into the first if branch and then the second if branch. Since the mutation negates the result, it catches the error with the assertEquals() method since the expected result was 10 and the mutated result is -10.  

 </br>



**6. Negated double field lower → SURVIVED (Line 194, Mutant 1)**

This mutant changes the constrains function line 194:	 

result = this.lower; 

By negating the this.lower into -this.lower. The mutant is not caught by the constrainShouldBeLowerBoundaryValue() test case which takes in a value of a -50 and goes into the first if branch and then the nested else if branch. In the constrainShouldBeLowerBoundaryValue() method, we used exRange2 which is a test range we created from 0 to 10. Since the mutation negates the result = this.lower line, it does not catch the error because the lower boundary in exRange2 is 0 and negating 0, still results in 0. Therefore, the assertEquals() method does not catch the error, and the test passes, even though it should not. To fix this issue, we created another test case where the range’s lower boundary is not 0. 

</br>



**7. Incremented (++a) double local variable number 3 → KILLED (Line 197, Mutant 6)**

This mutant changes the constrains function line 197:	 

return result; 

By incrementing the result variable into ++result. The mutant pre-increments the result variable. This means that in the constrain function of the Range class, the result variable is incremented before it gets returned. This causes the test cases for constrain in RangeTest.java to fail because the assertEquals() function catches the error and is able to see that the value has been changed. For that reason, the failure is detected, and the mutant is killed.  

 
</br>

 
**8. Incremented (a++) double local variable number 3 → SURVIVED (Line 197, Mutant 4)**

This mutant changes the constrains function line 197:	 

return result; 

By incrementing the result variable into result++. The mutant post-increments the result variable. This means that in the constrain function of the Range class, the result variable is incremented after it gets returned. This allows the test cases for constrain in RangeTest.java to pass because the increment happens after the return, so the tests are not able to catch that the return value has been altered. The assertEquals() function does not catch the error and is not able to see that the value has been changed. For that reason, the test passes, and the mutant survives.  

 </br>

 

**9. negated conditional → KILLED (Line 217, Mutant 1)**

This mutant changes the combine function on line 217: 

if (range1 == null) { 

By negating the if condition to if (range1 != null). The mutant negates the if statement. This means that in the combine function of the Range class, if range1 is actually null, it will not go into the first if  statement after the mutation and that would cause the function to return the wrong range. The combinecombineIgnoringNaNFirstNullTest() test ensures this test fails because it ensures that if the first range (range1) is null, the second range (range2) should be retuned. The assertEquals() catches the failure. Thus, the mutant gets killed. 

 
</br>


**10. equal to less or equal → SURVIVED(Line 281, Mutant 7)**

This mutant changes the static max function on line 281: 

if (Double.isNaN(d1)) { 

By making the if condition to if (Double.isNaN(d1) <= 0.0). The mutant changes the if statement. Instead of checking if d1 is a NaN value, it now checks whether the result of ‘Double.isNaN(d1)’ is less than or equal to 0. This does not make sense because ‘Double.isNaN(d1)’ always retuns a boolean value so comparing it to 0.0 does not make sense. However, this test is able to survive because our Range.java file does not have any test cases for the max function. Thus, the mutant survives. 

  

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
