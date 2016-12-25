CS-542 Design Patterns
Fall 2016
PROJECT 4 README FILE

Due Date: noon on Tuesday, Nov 23, 2016.
Grace Period Used This Project:  N/A
Grace Period Remaining:  N/A
Author: 
        Prashant Kadam
e-mail:
      	pkadam1@binghamton.edu


PURPOSE:

[
  "wc" command with Visitor, Prototype, and Observer
]

PERCENT COMPLETE:

[
  100%
]

PARTS THAT ARE NOT COMPLETE:

[
   N/A
]

BUGS:

[
  N/A
]

FILES and Packages:

[

Kadam_Prashant_assign4
   ---wordCount
     ----- README.txt
     ----- build.xml
     ----- src
        -----wordCount
     	   ----------driver
	        	   ----------Driver
	       ----------util
	       			---------Logger
	       			----------FileProcessor 
	       			----------WordCountStats
           ----------dsForStrings
	              ----------BinarySearchTree
	              ----------Node	              
           ----------visitors
	              ----------PopulateVisitor
	              ----------WordCountVisitor
	              ----------updateVisitor
	              ----------VisitorI
	              ----------CloneAndObserverVisitor
	              ----------WordCountVisitor

]

SAMPLE OUTPUT:
[

Number of words: 10123
Number of Distinct words: 3152
Number of characters: 43474

]

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile build.xml clean

## To compile: 
ant -buildfile build.xml all

## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
## We will use this to run your code
ant -buildfile build.xml run -Darg0=<inputfilename> -Darg1=<outputfilename> -Darg2=<NoOfIteration> 

## To run by specifying args in build.xml (just for debugging, not for submission)
ant -buildfile build.xml run

## To create tarball for submission
ant -buildfile build.xml tarzip


##To UNTAR :

tar -xvf Kadam_Prashant_assign4.tar.gz

Pattern Used:
[
Visitor , Observer , Prototype
]

Data Structure:

[
    Binary Search Tree
    Complexity => insert - O(log n)
    Complexity => search (average case) - O(log n)
    I have chosen binary search tree as a data struture because It will be faster insertion. worst case complexity of BST is O(n) but in a big file chances of ocuuring worst case are rare.
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

[
few java tutorials about BST and and recursively cloning BSTs from tutorialPoints.com

]

ACKNOWLEDGEMENT:

[
 N/A
]