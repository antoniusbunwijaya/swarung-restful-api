# API SPEC
- package entity --> representasi tabel database
- model(classnya) dari service(interface)
- repository --> untuk akses ke database update,delete
- controller --> bikin api
- config --> bikin secret key
- auth --> untuk bikin interseptor misal salah key akan direject


## Authentication
All API must use this authentication 

Request: 
- Header :
  - X-Api-Key : "Your Secret api key"
## Create Product 


Request : 
- Method : POST  
- Endpoint : `/api/products`
- Header : 
    - Content-Type : application/json
    - Accept:application/json
- Body :
```json 
{
    "id" : "string,unique",
    "name" : "string",
    "price" : "long",
    "quantity" : "integer"
}
```

Response : 
```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
          "id" : "string,unique",
          "name" : "string",
          "price" : "long",
          "quantity" : "integer",
          "createdAt" : "date",
          "updatedAt" : "date"
    }
}
```

## Get Product 
Request :
- Method : GET
- Endpoint : `/api/products{id_products}`
- Header :
    - Content-Type : application/json
    


Response :
```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
          "id" : "string,unique",
          "name" : "string",
          "price" : "long",
          "quantity" : "integer",
          "createdAt" : "date",
          "updatedAt" : "date"
    }
}
```
## Update Product 

Request :
- Method : PUT
- Endpoint : `/api/products/{id_product}`
- Header :
  - Content-Type : application/json
  - Accept:application/json
- Body :
```json 
{
      "name" : "string",
      "price" : "long",
      "quantity" : "integer"  
}
```

Response :
```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
          "id" : "string,unique",
          "name" : "string",
          "price" : "long",
          "quantity" : "integer",
          "createdAt" : "date",
          "updatedAt" : "date"
    }
}
```
## List Product
Request :
- Method : GET
- Endpoint : `/api/products`
- Header :

  - Accept:application/json
- Query Param : 
  - size : number,
  - page : number 

Response :
```json 
{
    "code" : "number",
    "status" : "srting",
    "data" : [
        {
              "id" : "string,unique",
              "name" : "string",
              "price" : "long",
              "quantity" : "integer",
              "createdAt" : "date",
              "updatedAt" : "date"
        },
        {
              "id" : "string,unique",
              "name" : "string",
              "price" : "long",
              "quantity" : "integer",
              "createdAt" : "date",
              "updatedAt" : "date"
        }
    ]
}
```

## Delete Product 
Request :
- Method : DELETE
- Endpoint : `/api/products/{id_product}`
- Header :
  
  - Accept:application/json


Response :
```json 
{
    "code" : "number",
    "status" : "string",
    
}
```
