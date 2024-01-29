
[SEN-20] incorrect account name transferring between checking and saving Created: 29/Jan/24  Updated: 29/Jan/24 
Status:	In Progress
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0, V1.1 

Fix versions:	None 

Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Unresolved 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Transfer from Checking to Savings account
•	The initial state of the system: 
o	System is on and user inserted card number 1 successfully
•	Detailed steps to reproduce the defect/bug: 
o	In the choose transaction type menu, select 3
o	In the account to transfer from menu, select 1
o	In the account to transfer to menu, select 2
o	Enter the amount as 20.00
•	The expected outcome: 
o	Receipt print out
TRANSFER FROM: SVGS TO: CHKG
•	The actual outcome: 
o	Receipt print out
TRANSFER FROM: CHKG TO: SVGS
Similar bug when transferring from checking to saving.
•	The expected outcome: 
o	Receipt print out
TRANSFER FROM: CHKG TO: SVGS
•	The actual outcome: 
o	Receipt print out
TRANSFER FROM: SVGS TO: CHKG

________________________________________

 
[SEN-19] typo when asking whether customer wants another transaction Created: 27/Jan/24  Updated: 29/Jan/24  Resolved: 29/Jan/24 
Status:	Done
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0 

Fix versions:	V1.1 


Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Done 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	The system is asking whether customer wants another transaction
•	The initial state of the system: 
o	The customer completed an transaction or pressed cancel during a transaction
•	Detailed steps to reproduce the defect/bug: 
o	In any of the sub-menu
o	Press CANCEL
o	OR after completing any transaction
•	The expected outcome: 
o	Screen displays “Would you like to do another transaction?”
•	The actual outcome: 
o	Displays “Wood you like to do another transaction?”
________________________________________

 
[SEN-15] MFT 40 - Invalid PIN Extension: Correct re-entry of PIN on the third try is accepted Created: 20/Jan/24  Updated: 21/Jan/24 

Status:	In Progress
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0, V1.1 

Fix versions:	None 

Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Unresolved 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Correct re-entry of PIN on the third try is accepted
•	The initial state of the system: 
o	Request to re-enter PIN is being displayed
•	Detailed steps to reproduce the defect/bug: 
o	Enter incorrect PIN the first time and second times, then correct PIN the third time
•	The expected outcome: 
o	Original transaction completes successfully
•	The actual outcome: 
o	Screen still displays Please enter your PIN
Then press ENTER

________________________________________

 
[SEN-14] MFT 39 - Invalid PIN Extension: Correct re-entry of PIN on the second try is accepted Created: 20/Jan/24  Updated: 21/Jan/24 

Status:	In Progress
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0, V1.1 

Fix versions:	None 

Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Unresolved 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Correct re-entry of PIN on the second try is accepted
•	The initial state of the system: 
o	Request to re-enter PIN is being displayed
•	Detailed steps to reproduce the defect/bug: 
o	Enter incorrect PIN the first time, then correct PIN the second time
•	The expected outcome: 
o	Original transaction completes successfully
•	The actual outcome: 
o	Screen still displays Please enter your PIN
Then press ENTER

________________________________________

 
[SEN-10] MFT 16 - withdrawal, system cannot verify the sufficient balance Created: 19/Jan/24  Updated: 27/Jan/24  Resolved: 21/Jan/24 
Status:	Done
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0 

Fix versions:	V1.1 


Type: 	Bug 	Priority: 	Medium 
Reporter: 	mike 
Assignee: 	Unassigned 
Resolution: 	Done 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested : 
o	System verifies that it has sufficient cash on hand to fulfill the request
•	The initial state of the system: 
o	System has been started up with less than the maximum withdrawal amount in cash on hand; System is requesting a withdrawal amount
•	Detailed steps to reproduce the defect/bug: 
o	Now System is requesting a withdrawal amount
o	select the withdrawal amount = 200
•	The expected outcome: 
o	System displays an appropriate message and asks customer to choose a different amount
•	The actual outcome: 
o	System withdraws 20$ from the checking account
________________________________________

 
[SEN-9] incorrect amount transferred from savings to checking Created: 17/Jan/24  Updated: 29/Jan/24  Resolved: 29/Jan/24 
Status:	Done
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0 

Fix versions:	V1.1 


Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Done 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Transfer from Savings to Checking account
•	The initial state of the system: 
o	System is on and user inserted card number 1 successfully
•	Detailed steps to reproduce the defect/bug: 
o	In the choose transaction type menu, select 3
o	In the account to transfer from menu, select 2
o	In the account to transfer to menu, select 1
o	Enter the amount as 20.00
•	The expected outcome: 
o	Receipt print out
AMOUNT: $20.00
TOTAL BAL: $120.00
AVAILABLE: $120.00
•	The actual outcome: 
o	Receipt print out
AMOUNT: $19.50
TOTAL BAL: $100.00
AVAILABLE: $100.00
Also found in MFT 29 - Transfer: System cannot implements a legitimate transfer correctly

________________________________________

 
[SEN-8] incorrect amount transferred from checking to savings Created: 17/Jan/24  Updated: 29/Jan/24  Resolved: 29/Jan/24 
Status:	Done
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0 

Fix versions:	V1.1 


Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Done 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Transfer from Checking to Savings account
•	The initial state of the system: 
o	System is on and user inserted card number 1 successfully
•	Detailed steps to reproduce the defect/bug: 
o	In the choose transaction type menu, select 3
o	In the account to transfer from menu, select 1
o	In the account to transfer to menu, select 2
o	Enter the amount as 20.00
•	The expected outcome: 
o	Receipt print out
AMOUNT: $20.00
TOTAL BAL: $1020.00
AVAILABLE: $1020.00
•	The actual outcome: 
o	Receipt print out
AMOUNT: $19.50
TOTAL BAL: $1019.50
AVAILABLE: $1019.50
Also found in MFT 29 - Transfer: System cannot implements a legitimate transfer correctly

________________________________________

 
[SEN-7] incorrect amount deposited to savings Created: 17/Jan/24  Updated: 27/Jan/24 

Status:	In Progress
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0, V1.1 

Fix versions:	None 

Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Unresolved 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Deposit to Savings account
•	The initial state of the system: 
o	System is on and user inserted card number 1 successfully
•	Detailed steps to reproduce the defect/bug: 
o	In the choose transaction type menu, select 2
o	In the account to deposit menu, select 2
o	Enter the amount as 20.00
o	Insert the envelop
•	The expected outcome: 
o	Receipt print out DEPOSIT TO: SVGS
AMOUNT: $20.00
TOTAL BAL: $1020.00
AVAILABLE: $1000.00
•	The actual outcome: 
o	Receipt print out DEPOSIT TO: SVGS
AMOUNT: $20.00
TOTAL BAL: $1010.00
AVAILABLE: $1000.00
V1.1 - 
•	The actual outcome: 
o	Receipt print out DEPOSIT TO: CHKG
AMOUNT: $20.00
TOTAL BAL: $1019.90
AVAILABLE: $1000.00

________________________________________

 
[SEN-6] incorrect amount deposited to checking Created: 17/Jan/24  Updated: 28/Jan/24 

Status:	In Progress
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0, V1.1 

Fix versions:	None 

Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Unresolved 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Deposit to Checking account
•	The initial state of the system: 
o	System is on and user inserted card number 1 successfully
•	Detailed steps to reproduce the defect/bug: 
o	In the choose transaction type menu, select 2
o	In the account to deposit menu, select 1
o	Enter the amount as 20.00
o	Insert the envelop
•	The expected outcome: 
o	Receipt print out DEPOSIT TO: CHKG
AMOUNT: $20.00
TOTAL BAL: $120.00
AVAILABLE: $100.00
•	The actual outcome: 
o	Receipt print out DEPOSIT TO: CHKG
AMOUNT: $20.00
TOTAL BAL: $110.00
AVAILABLE: $100.00
V1.1 - 
•	The actual outcome: 
o	Receipt print out DEPOSIT TO: CHKG
AMOUNT: $20.00
TOTAL BAL: $119.90
AVAILABLE: $100.00
Also found in MFT 22 - Deposit: System performs a legitimate deposit transaction properly

________________________________________

 
[SEN-5] incorrect amount withdrawn from saving Created: 17/Jan/24  Updated: 27/Jan/24  Resolved: 21/Jan/24 
Status:	Done
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0 

Fix versions:	V1.1 


Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Done 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Withdraw from Savings account
•	The initial state of the system: 
o	System is on and user inserted card number 1 successfully
•	Detailed steps to reproduce the defect/bug: 
o	In the choose transaction type menu, select 1
o	In the account to withdraw menu, select 2
o	In the amount of cash to withdraw menu, select 1
•	The expected outcome: 
o	Receipt print out WITHDRAWAL FROM: SVGS
AMOUNT: $20.00
o	Dispensed: $20.00
•	The actual outcome: 
o	Receipt print out WITHDRAWAL FROM: SVGS
AMOUNT: $40.00
o	Dispensed: $40.00
________________________________________

 
[SEN-4] incorrect amount withdrawn from checking Created: 16/Jan/24  Updated: 28/Jan/24  Resolved: 21/Jan/24 
Status:	Done
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0 

Fix versions:	V1.1 


Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Done 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Withdraw from Checking account
•	The initial state of the system: 
o	System is on and user inserted card number 1 successfully
•	Detailed steps to reproduce the defect/bug: 
o	In the choose transaction type menu, select 1
o	In the account to withdraw menu, select 1
o	In the amount of cash to withdraw menu, select 1
•	The expected outcome: 
o	Receipt print out WITHDRAWAL FROM: CHKG
AMOUNT: $20.00
o	Dispensed: $20.00
•	The actual outcome: 
o	Receipt print out WITHDRAWAL FROM: CHKG
AMOUNT: $40.00
o	Dispensed: $40.00
Also found in MFT 14 - Withdrawal: System performs a legitimate withdrawal transaction properly

________________________________________

 
[SEN-3] incorrect operations when checking for Money Market balance Created: 16/Jan/24  Updated: 27/Jan/24 
Status:	In Progress
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0, V1.1 

Fix versions:	None 

Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Unresolved 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Checking Money Market balance
•	The initial state of the system: 
o	System is on and user inserted card number 1 successfully
•	Detailed steps to reproduce the defect/bug: 
o	In the choose transaction type menu, select 4
o	In the account inquire menu, select 2
•	The expected outcome: 
o	Receipt print out $0, as card #1 does not have a Money Market account.
•	The actual outcome: 
o	System displays unknown error
o	System dispenses $500
o	Receipt print out TOTAL BAL: $1000.00 AVAILABLE: $1000.00
________________________________________

 
[SEN-2] account inquire form displaying incorrect information Created: 16/Jan/24  Updated: 28/Jan/24  Resolved: 21/Jan/24 
Status:	Done
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0 

Fix versions:	V1.1 


Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Done 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested: 
o	Check balance inquiry
•	The initial state of the system: 
o	The system is on and the user has inserted card #1 correctly
•	Detailed steps to reproduce the defect/bug: 
o	In the choose transaction type menu, select 4
•	The expected outcome: 
o	The inquire form displays Checking and Savings account
•	The actual outcome: 
o	The inquire form displays Checking and Money Market
Also found in MFT 33 - Inquiry: System asks customer to choose an account to inquire about

________________________________________

 
[SEN-1] program froze when entering invalid card # and PIN Created: 16/Jan/24  Updated: 28/Jan/24  Resolved: 21/Jan/24 
Status:	Done
Project:	SENG438A1

Components:	None 
Affects versions:	V1.0 

Fix versions:	V1.1 


Type: 	Bug 	Priority: 	Medium 
Reporter: 	Dingkai Wu 
Assignee: 	Unassigned 
Resolution: 	Done 	Votes: 	0 
Labels: 	None 
Remaining Estimate:	Not Specified 
Time Spent:	Not Specified 
Original estimate:	Not Specified 



 Description  	 
•	The function being tested : 
o	Insert a valid card number and pin
•	The initial state of the system: 
o	The system is on and idle
•	Detailed steps to reproduce the defect/bug: 
o	Click to insert card
o	Enter 3 as the card number
o	Enter 1 as the card pin
•	The expected outcome: 
o	The system should reject the card
•	The actual outcome: 
o	Entire ATM Simulation interface froze. Unable to perform any more inputs.
Also found in MFT 6 - Session: System rejects an unreadable card

________________________________________

 

Generated at Mon Jan 29 22:37:21 UTC 2024 by Dingkai Wu using Jira 1001.0.0-SNAPSHOT#100245-sha1:0a0346cca788bee9718ac77369076ecad301bec3. 
