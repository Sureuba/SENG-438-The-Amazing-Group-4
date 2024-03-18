**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:   |  4 |
| -------------- | --- |
| Student Names: | Uruba Alam |
|                | Naina Gupta |
|                | Ding Kai Wu |
|                | Chuhang Qi |

# 1. Introduction
In this lab, we explored mutation testing on two classes: Range.java and DataUtilities.java. We used the PIT testing tool to see the mutation coverage on eclipse. Through the PIT test results provided, we designed new test cases to increase mutation coverage. In the second part of this lab, we explored GUI test automation, record and replay with the Selenium IDE extension for web interface testing. 

# 2. Analysis of 10 Mutants of the Range class 

***Analysis of 10 mutants produced by pitest for Range.java class:***
 </br>
 
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

## Range Mutation Score Results (Original)
<img width="953" alt="RangeOriginal" src="https://github.com/Sureuba/SENG-438-The-Amazing-Group-4/assets/113148202/9d884058-aaa4-404c-a5bb-5437d3cfea42">

## PIT Test Mutation Coverage for Range (Updated)
 <img width="872" alt="Screenshot 2024-03-16 at 11 41 42 PM" src="https://github.com/Sureuba/SENG-438-The-Amazing-Group-4/assets/113148202/7ba80278-7ca3-4c23-a082-e2957e5b02c0">
 
## PIT Test Mutation Coverage for DataUtilities (Original)

![alt text](image-1.png)

## PIT Test Mutation Coverage for DataUtilities (Updated)

![alt text](image-2.png)

# 4. Analysis drawn on the effectiveness of each of the test classes

**Below are the new test cases which were added to RangeTest.java the test suite in order to kill surviving mutants:**
</br>

**TESTs**: testErrorMsg()  
</br>**KILLED**: Mutant 3, 4, 5, 8 and 9 on Line 91
        Mutant 4, 5, 6, 7, 10 and 11 on Line 92

 </br>
 
**TESTs**: intersectsFromLowerBoundary() 
       intersectsAtUpperBoundary()        
</br>**KILLED**:   
       Mutants 25 and 12 on Line 158
       Mutants 3, 32 and 34 on line 161
       
 </br>
 
**TESTs**:decimalPositiveIntersection()
       decimalNotIntersected()        
</br>**KILLED**:  
       Mutants 18 on Line 157
       Mutants 47 and 50 on line 161
       
</br>

**TESTs**: doesNotIntersectBelowLB() 
       doesNotIntersectAboveUB()  
</br>**KILLED**:  
       Mutants 2, 3, 4, 5, 7, 8, 10, and 11 on Line 157
       Mutants 2, 5, 8, 10, 13, 16, 19 and 21 Line 158
       Mutants 2, 6, 11, 14, 15, 19, 22, 25, and 27 on Line 161

</br>

**TESTs**: constrainShouldBeLowerBoundaryValue()   
</br>**KILLED**: </br>Mutant 1 on line 194

 </br>
 
**TESTs**: combineTwoDifferentRanges() 
</br>**KILLED**: </br>Mutant 3 on line 220

</br>

**TESTs**: scaleTestLessThanZeroFactor()
       scaleTestZeroFactor()
       scaleTestWithPosFractionScale()
       scaleTestWithPositiveScale() 
</br>**KILLED**: Mutant 1, 2, 7, 9, 13 and 15 on Line 410

 </br>
 

# 5. A discussion on the effect of equivalent mutants on mutation score accuracy
Some equivalent mutants were the Incremented and Decremented mutants (post and pre) where a lot of the surviving code was because we didn't test the values after they returned a value. These equivalent mutants can be fixed using decimal values or using the class fields after they have been used once. 

Another type of equivalent mutants is the negated conditional mutations where the condition statement (for an if, while or for loop) is negated and therefore the mutants that survived after the negation are easy to fix, since all we had to do was make tests for testing those specific conditions as well as testing the false input values and compare it with the right values. 

Another common mutant was one that replaced the conditional statements with constant true or false, this was an easy fix and decreased our mutation score accuracy due to there being a lack of variety in the test cases with different equivalence inputs. The constant true or false can be easily killed with assertTrue or assertFalse lines in the new test cases. 

The mutations with the message "replaced boolean return with true" means that we had no false tests for that method when we were testing. When testing this was an easy equivalent mutant to fix since it just meant we had to test for the false of the condition that did not kill a constant true or false mutant. 

For post increment or decrement mutants we found that using the method and then checking the values of the class fields to see if they are the same would kill the mutants. 

# 6. A discussion of what could have been done to improve the mutation score of the test suites

We will use DataUtilitiesTest for example. It is extremely difficult to increase the test score by 10%, as our original code already have a coverage of 89%. We managed to get the coverage to 93% after adding some new test cases. A lot of new test cases involves the testing on a null object, which was not covered by previous black-box testing and white-box testing. The generated report helped us a lot by telling us what mutation was killed and what survived. We then targeted all the survived mutations and try to kill them. However, not all mutations are easily targetable and some mutations generated by the report is too ambiguous to understand what it means.

# 7. Why do we need mutation testing? Advantages and disadvantages of mutation testing

In white-box testing we focused on test coverage. This ensured the degree to which the source code of a program is exercised. But it does not guarantee the program is bug free. For example, `ParamChecks.nullNotPermitted(data, "data");` is checked every time we pass any object to the method. The coverage test will tell us this has been checked, but we forgot to pass a null object to this statement to check if an exception has been thrown. <br>
One advantage of mutation testing is that it allows us to catch missed testing cases like the example above. It manually injects bugs into the system and our test cases are supposed to catch the mutations. Both RangeTest and DataUtilitiesTest already have 100% coverage on all the reachable codes, but mutation tests still pointed out many missing test cases. <br>
Mutation testing also have some disadvantages. One disadvantage is the "waste" of resources. During our mutation testing the operation that takes up most of the time is running the test itself. It takes anywhere from 3 and half minutes to 11 minutes to run a single mutation test, based on how fast the CPU is. Mutation testing is too resource intensive and could lead to a lot of time wasted. Another disadvantage is the report generated by Selenium is very hard to understand or impossible to kill for some mutation test cases. For example, for the line `return (b == null);` we have the mutation `Substituted 1 with -1 → SURVIVED`. We have no idea that the operand means and cannot find a suitable test case to cover this issue. 

# 8. Explain your SELENUIM test case design process

# 9. Explain the use of assertions and checkpoints

# 10. how did you test each functionality with different test data

# 11. Discuss advantages and disadvantages of Selenium vs. Sikulix

Selenium and SikuliX are both automation tools, but they target different applications:

Selenium excels in automating web applications. It interacts with web elements like buttons, text fields, and menus by identifying them using HTML attributes such as ID, name, and XPath.

SikuliX, on the other hand, uses image recognition to automate anything on the screen, including desktop applications and even web elements. You provide an image of the element you want to interact with, and SikuliX finds it and performs actions like clicks or typing.

Here are advantages and disadvantages of each IDE:

 **Selenium**
 
Advantages:

*Widely used: Large community and extensive documentation available.
</br>
*Cross-browser compatibility: Works with various web browsers.
</br>
*Language support: Supports multiple programming languages.



</br>

Disadvantages:

*Limited to web: Can't automate desktop applications.
</br>
*Locator maintenance: Relies on HTML structure, which can change, requiring script updates.
</br>
*Learning curve: Understanding HTML and web development concepts can be helpful.

</br>
</br>

 **SikuliX**

Advantages:

*Visually intuitive: Easy to identify elements using images.
</br>
*Desktop and web: Automates both web applications and desktop software.
</br>
*Fast prototyping: Quick for creating basic automation scripts.

</br>

Disadvantages:

*Image dependency: Relies on image files, which can break if visuals change.
</br>
*Less precise: Image recognition might not always be accurate, leading to errors.
</br>
*Limited functionality: Lacks advanced features for complex web automation.

# 12. How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
