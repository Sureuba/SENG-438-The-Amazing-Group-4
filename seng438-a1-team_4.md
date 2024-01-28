>   **SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#1 – Introduction to Testing and Defect Tracking**

| Group: 4      |
|-----------------|
| Student 1 Uruba Alam                |   
| Student 2 Naina Gupta              |   
| Student 3 Ding Kai Wu               |   
| Student 4 Chuhang Qi                |   


**Table of Contents**

[1 Introduction](#Introduction)

[2 High-level description of the exploratory testing plan](#High-level-description-of-the-exploratory-testing-plan)

[3 Comparison of exploratory and manual functional testing](#Comparison-of-exploratory-and-manual-functional-testing)

[4 Notes and discussion of the peer reviews of defect reports](#Notes-and-discussion-of-the-peer-reviews-of-defect-reports)

[5 How the pair testing was managed and team work/effort was divided](#How-the-pair-testing-was-managed-&-team-workeffort-was-divided)

[6 Difficulties encountered, challenges overcome, and lessons learned](#Difficulties-encountered-challenges-overcome-and-lessons-learned)

[7 Comments/feedback on the lab and lab document itself](#Commentsfeedback-on-the-lab-and-lab-document-itself)

# Introduction

In this lab, we tested an Automated Machine Teller (ATM) application. We were given 2 versions of the application. Version 1.0 was the initial release version, and it may or may not have bugs. To verify its functionality, we conducted two types of tests: exploratory testing and Manual Functional testing. Version 1.1 was the corrected version where some issues were resolved from version 1.0 but not all, in this we used the method of regression testing to retest the system after it had been modified. Before starting this lab, we had assumed exploratory testing was exploring new methods of testing on the application, and manual functional testing was going through the functional requirements of the application and heavily testing the functionalities. We were also not sure about the exact differences between the two methods, or how each testing method was going to be executed. We had a very vague understanding of exploratory and manual tests. We did not know how in-depth these tests actually were and how effective they could be. Having now completed this lab, we have a completely different understanding of exploratory and manual functional testing, and now know the unique advantages that come with each testing methodology. 

# High-level description of the exploratory testing plan

The aim of exploratory testing is to create "realistic" scenarios that cause the software to succeed or fail its operation. Since this is an ATM machine, we will simulate a typical user interaction with the ATM machine.

The main scenario consists of **Withdraw, Deposit, Transfer, and Balance Inquiry**. We will test the four functions with the two different cards provided.

For every action, we will also try to cancel the transaction whenever we make a selection and test if the system responds accordingly. Some additional exploratory testing also includes trying to enter the incorrect card number or PIN to see the response. For example:

Scenario 1: User uses **Card 1** to **Withdraw** from **Checking**.<br>
Scenario 2: User uses **Card 1** to **Withdraw** from **Saving**.<br>
etc...

This testing method should be comprehensive enough and will reach most functions for the ATM machine. The ATM machine has sufficient cash in the cash dispenser so it should allow users to complete all types of transactions. In the real world, it is very rare that an ATM machine does not have enough cash for a withdrawal operation. 

# Comparison of exploratory and manual functional testing

In this lab, we found that both exploratory testing and Manual functional testing are effective methods for finding bugs in our application. Exploratory testing is a method in which developers create tests as they are exploring the application. The developer/tester is the one in control for making the tests. However, in manual functional testing, the tests are created in advance, and the script is controlled rather than the tester. Both testing strategies serve different purposes. Manual functional testing is about controlling tests emphasizing prediction and decision-making, while exploratory testing is about improving test design emphasizing adaptability and learning. 

During this lab, we completed exploratory testing before manual functional testing so we found that a lot of the defects found in the manual phase were already detected in the exploratory phase. When we were completing exploratory tests, we were creating tests as we were going. The more we got familiar with the application, the more test cases we were able to produce. Our exploratory tests had a big emphasis on the different functionalities of the ATM (such as deposit, withdraw, and transfer), where we did rigorous testing on each functionality by constantly modifying values in an attempt to catch errors. However, when we completed the manual functional testing, we noticed that the pre-written tests were much more structured. There was a big emphasis on the flow of the application. For example, there were several tests conducted just for pressing the cancel key. For every transaction, the cancel button was tested at least 2 times. So it was a lot more thorough in testing the flow/behavior of the application. 

There were several defects we found in the lab report which were discovered in both exploratory and manual functional testing. They are also included in the defect report:

1. The system does not perform legitimate withdrawals properly
2. The system does not perform legitimate deposits properly
3. The system does not show a proper message in the receipt during a transfer
4. The system does not reject an unreadable card
5. The system does not display the correct account information when checking for balance

Through this lab, our group has found that both exploratory and manual function testing are effective methods for finding defects in an application, and using both strategies simultaneously would help find the maximum number of defects. 

# Notes and discussion of the peer reviews of defect reports

The group was divided up into 2 teams. Team 1 consists of Uruba Alam and Naina Gupta, and Team 2 consists of Ding Kai Wu and Chuhang Qi.

Both teams had similar results from exploratory testing and scripted testing. This is because the SUT is a relatively simple system. All the main functions and different selection branches can be tested for bugs easily. Team 1 reported fewer bugs than Team 2. This is because their report has a different format than Team 2's. For example, team 2 used 2 different bug reports for *incorrect amount withdrawn from saving* and *incorrect amount withdrawn from checking*, while team 1 reported this as one issue. Team 2's report also provided more details than Team 1's. However, there are some small details that Team 2 missed. For example, the incorrect spelling of *Wood you like to do another transaction?* rather than *Would you like to do another transaction?*

Overall, the 2 pairs approach allowed us to double-check other's work and fill in details that one pair might have missed during their testing phase. Combining the defect reports together allowed us to generate a more complete report.

# How the pair testing was managed & lessons learned from teamwork

In order to tackle pair programming, our group decided we would have both pairs test the same program separately in order to find the maximum amount of defects. Within the pair testing, one member was responsible for running the simulation and finding the bugs on their laptop by executing different tests (exploratory and manual), while the other member was responsible for recording these issues on Jira. This method was both efficient and productive for our group. While doing exploratory tests, our group's strategy was to test each and every functionality and try different values in order to find all possible defects. Through utilizing the strategy of pair programming, we learned that it is an efficient way of testing, and allows each team member to learn from one another. Having two pairs of programmers testing the same application also ensured that bugs were less likely to be missed. We have learned that teamwork and collaboration are important parts of software testing and it ensure that maximum productivity is achieved.  

# Difficulties encountered, challenges overcome, and lessons learned

The main difficulty as it comes to testing is to understand how the SUT is supposed to work. Even though this is a small system it still took us some time to figure out all the different operations we can perform. Some operations did not return the expected results and we had to figure out if it was an indented interaction or a bug. Another challenge is the use of a bug tracking software. We are unfamiliar with any issue tracking system so we chose Atlassian Jira. How to set up the project and report a bug also took some getting used to. We learned that a proper testing procedure and bug-tracking software are crucial to a successful software development cycle. Without them, a bug can be missed or reported multiple times, and sit on a backlog of problems that might not get fixed for a long time.

# Comments/feedback on the lab and lab document itself

This lab was a great way to learn about testing. It allowed us to learn how to use Jira which we now know is a very effective tool for bug tracking. The knowledge gained from this lab is valuable and is something we will carry forward in our careers as software developers. Testing is a skill and a big aspect of being a software engineer, and by learning about exploratory, manual functional, and regression testing; methods commonly used in the industry, we can effectively test our own applications we make in the future. Pair programming was also a new skill we learned in this lab, and found that it's a very effective and productive way to test code. All in all, we enjoyed this lab and have learned new skills from it that will help us in the future as software engineers. 
