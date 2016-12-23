
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

FILES and Packages:

[
  Included with this project are 5 files:

studentOrientation

./studentOrientation:
build.xml
README.txt
src

./studentOrientation/src:
studentOrientation

./studentOrientation/src/studentOrientation:
driver
library

./studentOrientation/src/studentOrientation/driver:
Driver.java

./studentOrientation/src/studentOrientation/library:
enums
measurement
tasks
utils

./studentOrientation/src/studentOrientation/library/enums:
BookBuyEnum.java
CampusTourEnum.java
CourseRegistrationEnum.java
DormSelectionEnum.java
Units.java

./studentOrientation/src/studentOrientation/library/measurement:
CarbonFootprint.java
Cost.java
Duration.java
Effort.java
interfaces

./studentOrientation/src/studentOrientation/library/measurement/interfaces:
CarbonFootprintI.java
CostI.java
DurationI.java
EffortI.java

./studentOrientation/src/studentOrientation/library/tasks:
BookBuyMondo.java
BookBuyUniversity.java
CampusTourBusRide.java
CampusTourOnFoot.java
CourseRegistrationComputer.java
CourseRegistrationOffice.java
DormSelectionGaming.java
DormSelectionOffice.java
interfaces

./studentOrientation/src/studentOrientation/library/tasks/interfaces:
BookBuyI.java
CampusTourI.java
CourseRegistrationI.java
DormSelectionI.java

./studentOrientation/src/studentOrientation/library/utils:
BaseMeasurements.java
Logger.java
StudentOrientation.java
StudentSchedule.java
taskfactory
workshop

./studentOrientation/src/studentOrientation/library/utils/taskfactory:
interfaces
TaskFactory.java

./studentOrientation/src/studentOrientation/library/utils/taskfactory/interfaces:
TaskFactoryI.java

./studentOrientation/src/studentOrientation/library/utils/workshop:
interfaces
StudentOrientationWorkshop.java

./studentOrientation/src/studentOrientation/library/utils/workshop/interfaces:
StudentOrientationWorkshopI.java


  build.xml

  README.txt - ReadMe file

  -----------------------------------------------
]

SAMPLE OUTPUT:
[

Complete Schedule for Student
     [java] Activity BookBuy- UniverstiyStore:
     [java] Cost: 105.0 Duration: 26.0  CarbonFootPrint: 32.0   Effort: 23.0
     [java] Activity CampusTour- BusRide:
     [java] Cost: 2.0   Duration: 30.0  CarbonFootPrint: 190.0  Effort: 5.0
     [java] Activity DormSelection- OnlineGaming:
     [java] Cost: 102.0 Duration: 20.0  CarbonFootPrint: 45.0   Effort: 10.0
     [java] Activity CourseRegistration- ComputerSystem:
     [java] Cost: 970.0 Duration: 17.0  CarbonFootPrint: 50.0   Effort: 12.0
     [java] Total Cost: 1179.0 DOLLARS
     [java] Total Duration: 93.0 MINUTES
     [java] Total Carbon Foot Print: 317.0 TONNESOFCO2
     [java] Total Effort: 50.0 CALORIES


]

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile build.xml clean

## To compile: 
ant -buildfile build.xml all

## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
## We will use this to run your code
ant -buildfile build.xml run -Darg0=firstarg 

## To run by specifying args in build.xml (just for debugging, not for submission)
ant -buildfile build.xml run

## To create tarball for submission
ant -buildfile build.xml tarzip


##To UNTAR :

tar -xvf Malani_Rishi_Kadam_Prashant.tar.gz

Pattern Used:
[

  Main Pattern - Builder Pattern

  also used abstract Factory for creation of concrete Objects for all four activities
]

Data Structure:

[
    We have used Composition for storing all correspomding measurements for activities
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