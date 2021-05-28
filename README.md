# Documentation Backend 

## Available Endpoints

* GET http://localhost:8090/users
  returns json array of all users
  *- provide JWT token*

* GET http://localhost:8090/users/{id}
  return json object of single users 
  *- provide JWT token*

* PUT http://localhost:8090/users/{id}
  replaces user with new user details
  *- provide JWT token*
  
* DELETE http://localhost:8090/users/{id}
  deletes user
  *- provide JWT token*

### Gebruiker aanmaken
Praat via Postman met de volgende link: `http://localhost:8080/api/auth/signup` en geef de volgende JSON in de body mee:
#### Gebruiker met userrol aanmaken
```json
{
    "username": "user",
    "email" : "user@user.com",
    "password" : "123456",
    "role": ["user"]
}
```
#### Gebruiker met adminrol aanmaken
```json
{
    "username": "admin",
    "email" : "admin@admin.com",
    "password" : "123456",
    "role": ["admin"]
}
```
Praat via Postman met de volgende link: `http://localhost:8080/api/auth/signin` en geef de volgende JSON in de body mee:
#### Inloggen user
```json
{
    "username":"user",
    "password":"123456"
}
```
#### Resultaat
De backend-server communiceert het volgende (soortgelijks) terug:
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
#### Reeds aangemaakte admin-account - direct te gebruiken
```json
{
    "username":"admin",
    "password":"admin123456"
}
```
