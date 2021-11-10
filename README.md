# Commsult Project Test
## API Spec
## Authentication

All API must use this authentication

Request :
- Header :
    - X-Api-Key : "secret api key"

## Create Stock

Request :
- Method : POST
- Endpoint : `/api/stocks`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :
```json
{
    "id" : "bigint, unique, auto increment",
    "name" : "varchar(100)",
    "quantity" : "bigint, not null",
    "price" : "double, not null",
    "description" : "string"
}
```

Response :

```json 
{
    "code" : "number",
    "data" : {
         "id" : "bigint, unique",
         "name" : "string",
         "price" : "double",
         "quantity" : "bigint",
         "description" : "string",
         "createdAt" : "date",
         "updatedAt" : "date"
     }
}
```

## Get Stock

Request :
- Method : GET
- Endpoint : `/api/stocks/{id_stock}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
    "data" : {
         "id" : "bigint, unique",
         "name" : "string",
         "price" : "double",
         "quantity" : "bigint",
         "description" : "string",
         "createdAt" : "date",
         "updatedAt" : "date"
     }
}
```

## Update Stock

Request :
- Method : PUT
- Endpoint : `/api/stocks/{id_stock}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
     "name" : "string",
     "price" : "double",
     "quantity" : "bigint",
     "description" : "string",
}
```

Response :

```json 
{
    "code" : "number",
    "data" : {
         "id" : "bigint, unique",
         "name" : "string",
         "price" : "double",
         "quantity" : "bigint",
         "description" : "string",
         "createdAt" : "date",
         "updatedAt" : "date"
     }
}
```

## List Stock

Request :
- Method : GET
- Endpoint : `/api/stocks`
- Header :
    - Accept: application/json
- Query Param :
    - size : number,
    - page : number

Response :

```json 
{
    "code" : "number",
    "data" : [
        {
             "id" : "bigint, unique",
             "name" : "string",
             "price" : "double",
             "quantity" : "bigint",
             "description" : "string",
             "createdAt" : "date",
             "updatedAt" : "date"
        },
        {
             "id" : "bigint, unique",
             "name" : "string",
             "price" : "double",
             "quantity" : "bigint",
             "description" : "string",
             "createdAt" : "date",
             "updatedAt" : "date"
         }
    ]
}
```

## Delete Stock

Request :
- Method : DELETE
- Endpoint : `/api/stocks/{id_stock}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
}
```
