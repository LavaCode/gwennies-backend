# Documentation Backend 

## Available Endpoints

* GET http://localhost:8090/users
  returns json array of all users
  *- provide JWT token*

* GET http://localhost:8090/users/{username}
  return json object of single users 
  *- provide JWT token*

* PUT http://localhost:8090/users/{id}
  replaces user with new user details
  *- provide JWT token*
  
* DELETE http://localhost:8090/users/{id}
  deletes user
  *- provide JWT token*

* POST http://localhost:8090/add/
  add product
  *- provide JWT token*

* PUT http://localhost:8090/change/{id}
  update product by id
  *- provide JWT token*

* GET http://localhost:8090/products/
  get products
  *- provide JWT token*

* GET http://localhost:8090/products/{id}
  get products by id
  *- provide JWT token*

* DELETE http://localhost:8090/delete/{id}
  delete products by id
  *- provide JWT token*

* POST http://localhost:8090/upload
  upload file
  *- provide JWT token*

* GET http://localhost:8090/files
  get all files
  *- provide JWT token*

* GET http://localhost:8090/files/{unique-id}
  download file
  *- provide JWT token*

### Create user
use postman with this endpoint: `http://localhost:8080/api/auth/signup`
Enter the following credentials in 'Body' as RAW JSON 
#### Create user:
```json
{
    "username": "user",
    "email" : "user@user.com",
    "password" : "123456",
    "role": ["user"]
}
```
#### Create admin:
```json
{
    "username": "admin",
    "email" : "admin@admin.com",
    "password" : "123456",
    "role": ["admin"]
}
```
### Login user
use postman with this endpoint: `http://localhost:8080/api/auth/signin` 
Enter the following credentials in 'Body' as RAW JSON 
#### Login user:
```json
{
    "username":"user",
    "password":"123456"
}
```
#### Result:
```json
{
    "id": 6,
    "username": "user",
    "email": "user@user.com",
    "roles": [
        "ROLE_USER"
    ],
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtb2QzIiwiaWF0IjoxNTk1NTg4MDk0LCJleHAiOjE1OTU2NzQ0OTR9.AgP4vCsgw5TMj_ePbPzMJXWWBNfFphJBHzAvTFyW9fzZ6UL-JO42pRq9puXAOlGh4hTijspAQAS-J8doHqADTA",
    "tokenType": "Bearer"
}
```
#### Predefined admin credentials:
```json
{
    "username":"admin",
    "password":"admin123456"
}
```
### Add a product:
```json
{
    "longDescription": "This is a long description",
    "name": "Mombag 01",
    "price": 29.99,
    "quantity": 2,
    "shortDescription": "This is a short description"
}
```