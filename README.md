Tetris
======
About
-----
This application is an assignment for **Programming Technologies** and **Programming Environments** class at the [University of Debrecen, Faculty of Informatics](http://www.inf.unideb.hu/).

The application
---------------
A simple clone of the original **Tetris** game.

Expectations
------------
Structure:
* Testable business logic - **DONE**
* JavaFX user interface - **DONE**
* Database - **DONE**

Maven-specific:
* `pom.xml` must have a `description`, `developers`, `scm` and `licenses` tag - **DONE**
* Indicate source encoding - **DONE**
* `maven-enforcer-plugin` must check for *JDK 1.8* - **DONE**
* `maven-javadoc-plugin` - **DONE**
* `maven-surefire-report-plugin` - **DONE**
* `maven-jxr-plugin` - **DONE**
* `cobertura-maven-plugin` - **DONE**
* `maven-checkstyle-plugin` - **DONE**

Documentation:
* Checkstyle XML - **DONE**
* ApiDoc (excluding GUI and JUnit tests) - **DONE**
* Package informations (`package-info.java`) - **DONE**

Logging:
* Logging - **DONE**

Unit testing:
* JUnit tests - **DONE**

License:
* Adding license - **DONE**

Git-specific:
* `.gitignore` file - **DONE**
* Upload to *GitHub* - **DONE**
* `README.md` file - **DONE**

Usage
-----

First thing you must do, is adding `oracle7.jar` to your local repository. You only have to do this one time.
> $ mvn install:install-file -Dfile=lib/ojdbc7.jar -DgroupId=com.oracle.jdbc -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar

After that, you can either do two things:
* Build a standalone `.jar` application, and run it

> $ mvn clean package

> $ cd target

> $ java -jar tetris-1.0-jar-with-dependencies.jar

Or

* Run it directly

> $ mvn exec:java -Dexec.mainClass=hu.unideb.inf.prt.tetris.view.main.Main

Sources
-------
* [Wikipedia](https://en.wikipedia.org/wiki/Tetris) - information about the rules, colors, points

License
-------
**Apache License, Version 2.0.**