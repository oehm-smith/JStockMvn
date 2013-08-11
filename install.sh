#!/bin/sh

# Install the third party libraries into local repository
mvn install:install-file -Dfile=lib/ta-lib-0.4.0.jar -DgroupId=ta-lib -DartifactId=ta-lib -Dversion=0.4.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/nachocalendar-0.23.jar -DgroupId=nachocalendar -DartifactId=nachocalendar -Dversion=0.23 -Dpackaging=jar
mvn install:install-file -Dfile=lib/l2fprod-common-all.jar -DgroupId=l2fprod-common-all -DartifactId=l2fprod-common-all -Dversion=0.unknown.1 -Dpackaging=jar
mvn install:install-file -Dfile=lib/blobsallad.jar -DgroupId=blobsallad -DartifactId=blobsallad -Dversion=0.unknown.1 -Dpackaging=jar
mvn install:install-file -Dfile=lib/JHotDraw7.jar -DgroupId=JHotDraw7 -DartifactId=JHotDraw7 -Dversion=0.unknown.1 -Dpackaging=jar
