# SECK

Search Engine Construction Kit

version 0.0.3 RC

## Directory Organization

### seck-lib

Library routines that are shared by both the backend applications and the web application

### seck-app

Suite of backend applications that are responsible for crawling and indexing/archiving (cataloging) data 

### seck-web

Servlet-based web application providing users with a browser interface access to the search engine data

## GITHUB Guide

### Pull request from PCWeRK to your account

1. Go to your Github Pull Requests Page, https://github.com/$account/seck/pulls
2. Click "Pull Request" button
3. Choose the base repository value to be from YOUR account [left-side]: $account/seck
4. Choose YOUR branch account [left-side]: master (or development if you've created one)
5. Choose the head repository value to be from PCWERK account [right-side]:  pcwerk/seck
6. Choose PCWERK head branch [right-side]: development
7. In "New Pull Request" text editor, write down the subject, and body, then click "Send pull request"
8. Go to your Pull Requests Page again
9. Choose "OPEN" tab, then click "Merge pull request" button

## Eclipse Guide

To develop the project in eclipse (this is assuming that you've correctly pulled or forked the project from the development branch):

1. Using maven to setup your eclipse settings in your top level directory:

         cd /path/to/seck/
         mvn install
         mvn eclipse:eclipse

2. Importing modules (projects) into eclipse.  Make sure that you do not check copy project into workspace as this will cause problems for synchronizing with GIT.

         File > Import > General > Existing Projects into Workspace > [select path to sec-lib] 

3. Repeat step #2 for sec-app and sec-web -- note that you ONLY need to import into eclipse and that you only need to run 'mvn eclipse:eclipse' (step #1) once at the top level directory.

NOTE: the above steps are required for each new version introduced.  Under the hood, _mvn install_ puts your libraries into the M2 repo; however, eclipse at runtime will reference your latest development.

## Sample App

To compile/package the sample command line search program:

    cd /path/to/seck
    mvn package

To run

    cd /path/to/seck/seck-app/target/
    java -jar seck-app-0.0.2.jar /search/path "keyword"

## Tomcat

Tomcat is configured to run in place within the top level directory, to use it:

    cd /path/to/seck
    mvn tomcat:run

Point your web browser to http://localhost:8080/seck-web/hello

If you want to use tomcat 6 (or 7):

    mvn tomcat6:run

You will notice that we now have a different port for tomcat 6 (and 7) and the top level directory is no longer seck-web

    http://localhost:9090/

## CONTACT

For more information on the seck project: johnjtran@acm.org

