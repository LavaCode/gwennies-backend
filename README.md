# Documentation Backend 
# --NOTE: current readme needs to be updated. All endpoints do NOT work at the moment. 

## Avaiable Endpoints

* GET http://localhost:8080/customers
  returns json array of customers

* GET http://localhost:8080/customers?customer_number={nr}
  returns json array of customers with optional search on customer number {nr}

* GET http://localhost:8080/customers/{id}
  return json object of single customer

* POST http://localhost:8080/customers
  creates cust

* PUT http://localhost:8080/customers/{id}
  replaces customer with customer provided
  
* DELETE http://localhost:8080/customers/{id}
  deletes customer
  
## Installation

1. Load project in IntelliJ. 
   Maven will start synchronizing dependencies
   
2. Run the project. 
   If all is well de endpoints will be available
   
## Comments

1.  Java version 15
    openjdk-15.jdk
    
2.  Database H2
    This is an in-memory database. No installation required.
    
3.  Cross-Origin is enabled for all endpoints and all origins.

4.  No authorization required.