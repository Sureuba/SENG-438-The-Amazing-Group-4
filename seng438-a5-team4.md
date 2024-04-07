**SENG 438- Software Testing, Reliability, and Quality**

**Lab. Report \#5 – Software Reliability Assessment**

| Group \#:       |   |
|-----------------|---|
| Student Names:  |   |
|                 |   |
|                 |   |
|                 |   |

# Introduction

# 

# Assessment Using Reliability Growth Testing 

# Assessment Using Reliability Demonstration Chart 
</br>

**Half MTTF min**
</br>
<img width="664" alt="Screenshot 2024-04-06 at 10 44 14 PM" src="https://github.com/Sureuba/SENG-438-The-Amazing-Group-4/assets/113148202/b15b5edf-8b58-42d4-a644-1c0659d387c8">
</br>
From this chart, it can be seen that when MTTF min is halved, the data points go into the rejection (red portion) part of the system



</br>
</br>

**MTTF min**
</br>
<img width="665" alt="Screenshot 2024-04-06 at 10 43 40 PM" src="https://github.com/Sureuba/SENG-438-The-Amazing-Group-4/assets/113148202/321fe67b-7540-4bec-a7a0-f493cb7c6bdf">
</br>
From this chart, it can be seen that at MTTF min, the data points are in the the continue (yellow portion) part of the system

</br>
</br>

**Double MTTF min**
</br>
<img width="657" alt="Screenshot 2024-04-06 at 10 44 47 PM" src="https://github.com/Sureuba/SENG-438-The-Amazing-Group-4/assets/113148202/81aafacf-a8df-40ae-a51b-12690b4b2bde">
</br>
From this chart, it can be seen that when MTTF min is doubled, the data points go into the accept (green portion) part of the system

</br>
</br>

The mean time to Failure (MTTF) min was found through trial and error. We first started by adjusting the data to ensure that the graph axes were correct and then adjusted the data itself for calculating MTTF until we found an ideal value. We derived the MTTF min value which was 0.33 by finding the the point near the acceptance (green portion) threshhold of the graph  (this can be seen above in the MMTF min graph above as well). This is due to the fact that MTTF min represents the point at which the system under test becomes acceptable. With normalized failure data represented by the ratio of failure time to MTTF, we crafted graphical representations showcasing Twice MTTFmin and Half MTTFmin. By altering the threshold for the maximum acceptable number of failures, we crafted and illustrated these graphs accordingly. Through consistent trial and error with the RDC chart, we were able to find the MTTF min.

</br>
</br>

**Advantages vs. Disadvantages of RDC**

The main problem with the RDC.xls file was the issue of where and how to use the failure data form the DAT files, thus learning it and how to use it was a huge disadvantage. Another factor is that there are limiting factors and limited information that affects the reliability, such as environmental conditions, usage patterns or variations in manufacturing processes.
The advantages were the visualizations of the data in the RDC charts, the rejected, continued and accepted regions make it easier to understand if data is actually reliable. Overall it is easier to make decisions using RDC related to code and its reliability.

# 

# Comparison of Results

# Discussion on Similarity and Differences of the Two Techniques

# How the team work/effort was divided and managed

# 

# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
