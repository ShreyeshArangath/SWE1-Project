# Project Links 
Github: https://github.com/ShreyeshArangath/SWE1-Project

# SWE1-Project
We used NetBeans to run and compile the project. However, you can run the project by directly running and building the jar. 
Java Platform: JDK 17

To run the program use the following command: 
```
java -jar "<path-to-jar>"
```
Example: 
```
java -jar "/Users/shreyesh/NetBeansProjects/SWE1-Project/dist/SWE1-Project.jar"
```
The JAR file is included as part of the submission. 
Please head over to `SWE1-Project/dist/SWE1-Project.jar` to access the JAR file and run the code. 


Otherwise, download netbeans and import the project.

## Assumptions
* Assumption for Scale: The barcode scanner is within the scale. 
*Assumption: Small scale grocery store with data that can be held within memory. Periodically will write to the DB
* Assumptions made for the PaymentMethod class: 
    * Added Bank class, has several cards and info stored.
    *	Credit card numbers cannot be randomly generated because they need to be verified by the bank
    *	Changed cardnumber from a uuid to a long
    *	Assumption: The customer pays over or the exact amount of their order total. Never less.
*  Assumptions made for Inventory class:
    *	Assumption: The inventory for each item is 20. Threshold is 5, anything below creates the message.
    *	Below threshold message needs to be stored in the system (stored in a file).
    *	Assume once payment goes through, setInventoryOrder will be called to send order to inventory order.
    *	SubItemsOrdered must be called before updating inventory


## Test data 
* Scan Button generates random item that will be presented in the Shopping Cart
* (Regular) Items 100-102 were tested/can be tested
* (Bulk) Items 200-202 were tested/can be tested
* Loyal Customer Information: 999999999, 1000

# Git Basics (TEAM)

## Basic flow to push your changes to Remote (Github)
```
git add .
git commit -m "<message>"
git push origin <branch_name>
```

Create pull request once you're happy with the changes. 

## How to update your local copy with the changes made on main? 
Note: Do this often (once in a couple of days)
```
git pull origin main
```
If prompted with a weird screen with text, try pressing esc and type `:wq`
