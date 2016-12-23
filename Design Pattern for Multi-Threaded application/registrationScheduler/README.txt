
CS-542 Design Patterns
Fall 2016
PROJECT 3 README FILE

Due Date: 11.59 PM EST on Friday, Oct 28, 2016.
Submission Date: Friday, Oct 28, 2016.
Grace Period Used This Project:  N/A
Grace Period Remaining:  N/A
Author: 
        Rishi Malani
        Prashant Kadam
e-mail:
        rmalani1@binghamton.edu
        pkadam1@binghamton.edu


PURPOSE:

[
  Apply the design principles and patterns we have learned so far to develop and test code for the given problem.
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

FILES:

[
  Included with this project are 5 files:

  -----------------------------------------------
  Package Name                     file Name
  -----------------------------------------------
  Driver                            
                                    Driver.java

  registration                      
                                    Allocator.java
                                    Course.java
                                    Student.java

  store                             
                                  FileDisplayInterface.java
                                  Results.java
                                  StdoutDisplayInterface.java
  threadMgmt
                                  CreateWorkers.java
                                  WorkerThread.java
  util                      
                                  FileProcessor.java
                                  Logger.java
                                  ObjectPool.java

  build.xml

  README.txt - ReadMe file

  -----------------------------------------------
]

SAMPLE OUTPUT:
[

]

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

## To compile: 
ant -buildfile src/build.xml all

## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=firstarg 

## To run by specifying args in build.xml (just for debugging, not for submission)
ant -buildfile src/build.xml run

## To create tarball for submission
ant -buildfile src/build.xml tarzip

## if using sh script use 
./run.sh driver <input.txt> <output.txt> <No of threads> <debug level>


##To UNTAR :

tar -xvf Malani_Rishi_Kadam_Prashant.tar.gz


Data Structure:

[

]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

[

]

ACKNOWLEDGEMENT:

[
 N/A

]