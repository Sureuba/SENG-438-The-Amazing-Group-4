**SENG 438- Software Testing, Reliability, and Quality**

**Lab. Report \#5 – Software Reliability Assessment**

| Group \#:       | 4  |
|-----------------|---|
| Student Names:  |  Uruba Alam |
|                 |  Naina Gupta |
|                 |  Bill |
|                 |  Chuhang |

# Introduction
In this lab, we evaluated the reliability and usage of a system utilizing tools such as C-SFRAT and the Reliability Demonstration Chart (RDC-11) on Excel. We used two techniques to assess the failure data, including Reliability Growth Testing (RGT) and Reliability Demonstration Chart (RDC).
# 

# Assessment Using Reliability Growth Testing 

# Assessment Using Reliability Demonstration Chart 
</br>

**Half MTTF min**
</br>
<img width="664" alt="Screenshot 2024-04-06 at 10 44 14 PM" src="https://github.com/Sureuba/SENG-438-The-Amazing-Group-4/assets/113148202/b15b5edf-8b58-42d4-a644-1c0659d387c8">
</br>
From this chart, it can be seen that when MTTF min is halved, the SUT is within the rejection (red portion) part of the system



</br>
</br>

**MTTF min**
</br>
<img width="665" alt="Screenshot 2024-04-06 at 10 43 40 PM" src="https://github.com/Sureuba/SENG-438-The-Amazing-Group-4/assets/113148202/321fe67b-7540-4bec-a7a0-f493cb7c6bdf">
</br>
From this chart, it can be seen that at MTTF min, the SUT is within the continue testing (yellow portion) part of the system

</br>
</br>

**Double MTTF min**
</br>
<img width="657" alt="Screenshot 2024-04-06 at 10 44 47 PM" src="https://github.com/Sureuba/SENG-438-The-Amazing-Group-4/assets/113148202/81aafacf-a8df-40ae-a51b-12690b4b2bde">
</br>
From this chart, it can be seen that when MTTF min is doubled, theSUT is within the accept (green portion) part of the system

</br>
</br>

The mean time to Failure (MTTF) min was found through trial and error. We first started by adjusting the data to ensure that the graph axes were correct and then adjusted the data itself for calculating MTTF until we found an ideal value. We derived the MTTF min value which was 0.33 by finding the the point near the acceptance (green portion) threshhold of the graph  (this can be seen above in the MMTF min graph above as well). This is due to the fact that MTTF min represents the point at which the system under test becomes acceptable. With normalized failure data represented by the ratio of failure time to MTTF, we crafted graphical representations showcasing Twice MTTFmin and Half MTTFmin. By altering the threshold for the maximum acceptable number of failures, we crafted and illustrated these graphs accordingly. Through consistent trial and error with the RDC chart, we were able to find the MTTF min.

</br>
</br>

**Advantages vs. Disadvantages of RDC**

Disadvantages:
* limiting factors and limited information that affects the reliability, such as environmental conditions, usage patterns or variations in manufacturing processes.
* Although the RDC displays the number of failures per unit time, it does not clearly indicate how or why the system failed, which is important when debugging the system.

Advantages:
* The visualizations of the data in the RDC charts, the rejected, continued and accepted regions make it easier to understand if data is actually reliable.
* Color coded
* Overall it is easier to make decisions using RDC related to code and its reliability.

# 

# Comparison of Results

# Discussion on Similarity and Differences of the Two Techniques

# How the team work/effort was divided and managed
Our whole group worked on the assignment together. Bill and Chuhang primarily worked on part 1 while Naina and Uruba primarily worked on part 2. This split was to increase our efficiency. After the completion of both parts, we peer reviewed and explained our approaches and results to one another in order to ensure everyone was on the same page and understood the assignment thoroughly. 

# 

# Difficulties encountered, challenges overcome, and lessons learned

The main problem we with the RDC.xls file was the issue of where and how to use the failure data form the DAT files, thus learning it and how to use it was a huge challenge. We encountered the issue of knowing the precise method and location for inputting failure data. It was just a hurdle to learn how to use a new software (espcially with unclear instructions) and getting to use to it's functionalities and features.

# Comments/feedback on the lab itself
The instructions were very inclear and vague, so we had to learn ourselves how to use the tools like RDC-11.
