CS-542 Design Patterns
Fall 2016
PROJECT 5 README FILE

Due Date: noon on Thursday, Dec 15, 2016.
Grace Period Used This Project:  N/A
Grace Period Remaining:  N/A
Author: 
        Prashant Kadam
e-mail:
      	pkadam1@binghamton.edu


PURPOSE:

[
  Comparing Objects in Java.
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

Kadam_Prashant_assign5
   ---genericDeser
     ----- README.txt
     ----- build.xml
     ----- input.txt 
     ----- src
       ---genericDeser
     	   ----------driver
	        	   ----------Driver.java
           ----------util
	              ----------First.java
	              ----------Second.java
	              ----------PopulateObjects.java
	              ----------Statistics.java
           ----------fileOperations
	              ----------FileProcessor.java
]

SAMPLE OUTPUT:
[
		Number of unique First objects: 359994
		Total Number of First objects: 498623
		Number of unique Second objects: 100643
		Total Number of Second objects: 501377
]

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile build.xml clean

## To compile: 
ant -buildfile build.xml all

## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
## We will use this to run your code
ant -buildfile build.xml run -Darg0=<inputfilename> -Darg1=<Debug Level> 

## To run by specifying args in build.xml (just for debugging, not for submission)
ant -buildfile build.xml run

## To create tarball for submission
ant -buildfile build.xml tarzip


##To UNTAR :

tar -xvf Kadam_Prashant_assign5.tar.gz

Pattern Used:
[
None
]

Data Structure:

[
    Using ArrayList<Object> to Store all First and Second object.
    Complexity O(n). But we have to scan through all objects so useful.
    Also using set<First>  and Set<Second> to find unique First/ Second Object
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

[
few java tutorials Java reflection from tutorialPoints.com
]

ACKNOWLEDGEMENT:

[
 N/A
]