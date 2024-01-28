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

[5 How the pair testing was managed and team work/effort was divided](#How-the-pair-testing-was-managed-and-team-workeffort-was-divided)

[6 Difficulties encountered, challenges overcome, and lessons learned](#Difficulties-encountered-challenges-overcome-and-lessons-learned)

[7 Comments/feedback on the lab and lab document itself](#Commentsfeedback-on-the-lab-and-lab-document-itself)

# Introduction

An introduction of your lab work, and what you knew about exploratory and manual
functional testing before this lab

# High-level description of the exploratory testing plan

The aim of exploratory testing is to create "realistic" scenarios that cases the software to succeed or fail it's operation. Since this is an ATM machine, we will simulate a typical user interaction with the ATM machine.

The main scenario consists of **Withdraw, Deposit, Transfer, and Balance Inquiry**. We will test the four functions with the two different cards provided.

For every action, we will also try to cancel the transaction whenever we make a selection and test if the system responds accordingly. Some additional exploratory testing also includes trying to enter the incorrect card number or PIN to see the response. For example:

Scenario 1: User uses **Card 1** to **Withdraw** from **Checking**.<br>
Scenario 2: User uses **Card 1** to **Withdraw** from **Saving**.<br>
etc...

This testing method should be comprehensive enough and will reach most functions for the ATM machine. The ATM machine has sufficient cash in the cash dispenser so that it should allow users to complete all types of transactions. Since in the real world, it is very rare that an ATM machine does not have enough cash for a withdraw operation. 

# Comparison of exploratory and manual functional testing

In this lab, we found that both Exploratroy testing and Manual Fucntional testing are effective mehotds for finding bugs in our application. Expoloratory testing is a method in which developers are creating tests as they are expoloring the application. The developer/tester is the one in control for making the tests. However, in manual functional testing, the tests are created in advance, and the script is control rather than the tester. Both testing strategies serve different puproses. Manual functional testing is about controlling tests emphaazing prediction and deceison making, while exploratory testing is about improving test design emphaziing adaptability and learning. 

During this lab, we completed exploraroty testing before manual functional testing so we found that a lot of the defects found in the manual phase were already detected in the exploratory phase. When we were completing exploratory tests, we were creating tests as we were going. The more we got familiar with the application, the more test cases we were able to produce. Our explorararoty tests had a big emphasis on the diffferent functionalites of the ATM (such as deposit, withdrawl, transfer), where we did rigorous testing on each functioanlity by constantly modfiying values in attempt to catch errors. However, when we completed the manual functional testing, we noticed that the pre written tests were much more structured. There was a big emphasis on the flow of the application. For example, there was lots of tests conducted just for pressing the cancel key. For every transaction, the cancel button was tested at least 2 times. So it was a lot more thorough in testing the flow/behaviour of the application. 

There was several defects we found in the lab report which were discovered in both exploraroty and manual functional testing. Here are a few:

1. System does not perform legitamate withdrawl properly
2. System does not perform legitamte deposit properly
3. System does not show proper message in reciept during a transfer


Through this lab, our group has found that both exploratory and manual function testing are effective methods to finding defects in an application, and using both stategies simultaneously would help find the maximum number of defects. 

# Notes and discussion of the peer reviews of defect reports

The group was divided up into 2 teams. Team 1 consists of Uruba Alam and Naina Gupta, team 2 consists of Ding Kai Wu and Chuhang Qi.

Both teams had similar results from exploratory testing and scripted testing. This is because the SUT is a relatively simple system. All the main functions and different selection branches can be tested for bugs easily. Team 1 reported less bugs than team 2. This is because their report has a different format than team 2's. For example team 2 used 2 different bug reports for *incorrect amount withdrawn from saving* and *incorrect amount withdrawn from checking*, while team 1 reported this as one issue. Team 2's report also provided more details than team 1's. However, there are some small details that team 2 missed. For example, the incorrect spelling of *Wood you like to do another transaction?* rather than *Would you like to do another transaction?*

Overall, the 2 pairs approach allowed us to double check other's work and fill in details that one pair might have missed during their testing phase. Combining the defect reports together allowed us to generate a more complete report.

# How the pair testing was managed and team work/effort was divided 

In order to tackle pair programming, our group decided we would have both pairs test the same program seperately in order to find the maximum amount of defects. Within the pair testing, one member was responsible for running the simulation and finding the bugs on their laptop by executing different tests (exploaratory and manual), while the other member was repsosible for recording these issues on Jira. This method was both effiecent and productive for our group. While doing exploraroty tests, our group's strategy was to test each and every functionality and try different values in order to find all possible defects. 

# Difficulties encountered, challenges overcome, and lessons learned

The main difficulty as it comes to testing is to understand how the SUT is supposed to work. Even though this is a small system it still took us some time to figure out all the different operations we can perform. Some operations did not return the expected results and we had to figure out if it is an indented interaction or a bug. Another challenge is the use of a bug tracking software. We are unfamiliar with any issue tracking system so we chose Atlassian Jira. How to setup the project and report a bug also took some getting used to. We learned that a proper testing procedure and bug tracking software is crucial to a successful software development cycle. Without them a bug can be missed or reported multiple times, and sit on a backlog of problems that might not get fixed for a long time.

# Comments/feedback on the lab and lab document itself

This lab was a great way to learn about testing. It allowed us to learn how to use Jira which we now know is a very effective tool for bug tracking. The knowledge gained from this lab is valuable and is something we will cary forward in our careers as software developers. Testing is a skill and a big aspect of being a software engineer, and by learning about exploratory, manual functional, and regression testing; methods commonly used in the industry, we can effectlively test our own application we make in the future. Pair programming was also a new skill we learned in this lab, and found that it's a very effective and productive way to test code. All in all, we enjoyed this lab and have learned new skills from it that will help us in the future as software engineers. 
