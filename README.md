# ColossalCave

<p align="center"><img src="https://github.com/wholder/ColossalCave/blob/master/images/ColossalCave%20Screenshot.png"></p>

ColossalCave is my rewrite of a Unix C version of the classic text adventure game by Jerry D. Pohl that was based on a BDS C version by Jay R. Jaegar that was, itself, based on the expanded FORTRAN version by Don Woods that was derived from the original FORTRAN code by Willie Crowther.  For more details on the history of this program, see ["David Kinder's guide to Adventure downloads at the Interactive Fiction Archive"](http://rickadams.org/adventure/e_downloads.html)

The purpose of my rewrite was to make the code more accessible for adaptation and study to those who are more familiar with Java than with FORTRAN as well as to restructure the code in a way that, hopefully, makes it easier to follow the logic of how it works.  Where the original code used lots of old school FORTRAN tricks to compact the code and data in order to fit in the limited RAM of early computer systems, I have chosen to unpack many of these array-based structures into an annotated Map class that consolidates much of the information into an array of Room objects.  In addition, I've added comments in places where the code prints responses to various actions to help you follow how this logic works.

**Caveat**: I tried to be as careful as possible while converting the code from C to Java, but it's easily possible that I may have broken something as part of my rewrite, so please don't rely on my code as a gospel when it comes to how Don Woods' version of Colossal Cave is expected to operate.  If you notice some odd behavior, please file an "Issue" in this GitHub archive and I'll try to check into it when I have a chance.

### Requirements
Java 8 JDK, or later must be installed in order to compile the code.  There is also a [**Runnable JAR file**](https://github.com/wholder/ColossalCave/tree/master/out/artifacts/ColossalCave_jar) included in the checked in code that you can download.   On a Mac, just double click the `ColossalCave.jar` file and it should start.  You should also be able to run the JAR file on Windows or Linux systems, but you'll need to have a Java 8 JRE, or later installed and follow the appropriate process for each needed to run an executable JAR file.

Wayne
