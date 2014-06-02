dropwizard-template
==================
[![Build Status](https://travis-ci.org/eSailors/dropwizard-template.g8.svg?branch=master)](https://travis-ci.org/eSailors/dropwizard-template.g8)

A [giter8][g8] template for java gradle dropwizard applications.

Includes

* findbugs
* cobertura
* checkstyle
* integration-test source set
* acceptance-test source set with cucumber
* fatJar support

##Usage
Install [giter8][g8], then:

    g8 esailors/dropwizard-template


cd into your new project dir

    chmod +x gradlew
    ./gradlew build
    java -jar build/libs/your-project-version-farJar.jar db migrate example.yml
    (there seems to be some bug, so you need to run it twice until the db changes are applied!?)

##Gradle Options
###Dropwizard App

Build and start application:   
	./gradlew run
    
###BDD with cucumber
Add features and sources to src/acceptance-test/...
Then run

    ./gradle acceptanceTest

A dummy test is already there.
###Integration tests
Add junit tests to src/integration-test/java
Then run

    ./gradlew build -PuseIntegrationTest=true

###Cobertura
    ./gradlew build -PuseCodeCoverage=true
###FindBugs
    ./gradlew build -PuseFindbugs=true
###FatJar
    ./gradlew fatJar

You can also combine these switches.

[g8]: http://github.com/n8han/giter8#readme
