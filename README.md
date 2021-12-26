# 
Readme: godelMasteryTask-spring-rest
An example of a RESTful WebServer developed using Spring & SpringBoot.

This simple server acts a Location-Service - it will return items and orders.

Requirements
The fully fledged server uses the following:

Spring Framework
SpringBoot

Dependencies
There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of libraries and versions used.

Building the project
You will need:

Java JDK 12 or higher
Maven 4.0.0 or higher
Git

About the Service
The service is just a simple item shop REST service. It uses an in-memory database (H2) to store the data. If your database connection properties work, you can call some REST endpoints defined in by.test.godelMasteryTask.controllers.ItemController & *.BasketController & *.OrderController on port 8181. (see below)

More interestingly, you can start calling some of the operational endpoints (see full list below) like /item and /basket (these are available on port 8181)

You can use this sample service to understand the conventions and configurations that allow you to create a DB-backed RESTful service. Once you understand and get comfortable with the sample app you can add your own services following the same patterns as the sample service.

Here is what this little application demonstrates:

Here are some endpoints you can call:

Get information about items, orders, etc.
http://localhost:8181/items
http://localhost:8181/basket
http://localhost:8181/orders

Additional info in swagger.yaml file 

To view your H2 in-memory datbase
The 'test' profile runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8181/h2. Default username is 'sa' with a blank password. Make sure you disable this in your production profiles. For more, see https://goo.gl/U8m62X



