Case Study:

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps. 
The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller. 
Your goal is to create a RESTful service that can retrieve product and price details by ID. The URL structure is up to you to define, but try to follow some sort of logical convention.
Build an application that performs the following actions: 
<br>•	Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. 
<br>•	Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793) 
<br>•	Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}
<br>•	Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from api.target.com, but let’s just pretend this is an internal resource hosted by myRetail)  o Example: https://api.target.com/products/v3/13860428?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz
<br>•	Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response.
<br>•	BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store.


<br>===========================================================
<br>            Solutions
<br>===========================================================
# myrepo
my repository

<br>===============================================================
<br>Steps to build the application and execute in LOCAL environment
<br>===============================================================

<br>====================
<br>Pre requisite
<br>====================
<br>1. Install Cassandra cluster in local machine
<br>2. execute cassandra.txt to create keyspace and table and insert few records

<br>======================================
<br>Steps to build:
<br>======================================

<br>1.go to https://github.com/safikur/myrepo
<br>2.clone the repository
<br>3. project name: myRetail
<br>4. refresh gradle
<br>5. build the jar myRetail.jar
<br>6. execute the myRetail.jar

<br>============================
<br>    Test the application
<br>============================
<br> Please use SOAPUI or any rest client to test the service
<br>Steps
<br> 1. Get product name and price. Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. example product ID: 15117729
<br> URL: http://localhost:8080/myretail/restws/api/products/15117729
<br> METHOD: GET
<br> 2. Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from api.target.com, but let’s just pretend this is an internal resource hosted by myRetail)  o Example: https://api.target.com/products/v3/13860428?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz
<br> URL: http://localhost:8080/myretail/restws/api/products/target/15117729
<br> METHOD: GET
<br> 3. Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store.
<br> URL: http://localhost:8080/myretail/restws/api/products/15117729
<br> METHOD: PUT
