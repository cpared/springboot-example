# Documentation

## Products

`GET` /api/v1/articles

200 OK -> Returns a response

`Response`

```json
    [
  {
    "id": 6,
    "name": "Camiseta",
    "category": "Deportes",
    "brand": "Topper",
    "price": 2300,
    "quantity": 2,
    "isFreeShipping": false,
    "points": 3
  },
  {
    "id": 10,
    "name": "Chomba",
    "category": "Indumentaria",
    "brand": "Taverniti",
    "price": 2400,
    "quantity": 6,
    "isFreeShipping": false,
    "points": 3
  }
]
```

You can add the following filters

`Optiona values:`
1. category
2. brand
3. isFreeShipping
4. points

In case you want to order the response data, you can add: `Order`

| paramOrder   |      Description      |
|----------|:-------------:|
| 1 |  Alphabetic asc | 
| 2 |    Alphabetic desc  | 
| 3 | Price asc | 
| 4 | Price desc |


`POST` /api/v1/purchase-request

200 OK -> Returns a response\
404 Not Found -> When at least one of the products is not in the database\
500 Internal Server Error -> When malformed request body.

This method sends a product list and get the purchase whit the list you have sent, and the total price.

`Request Body`

```json
{
    "articles": [
        {
            "productId":7,
            "name": "Desmalezadora",
            "brand": "Makita",
            "quantity": 1
        },{
            "productId":5,
            "name": "Zapatillas Deportivas",
            "brand": "Nike",
            "quantity": 2
        }
    ]
}
```


```Response```

```json
{
    "id": 49,
    "articles": [
        {
            "productId": 7,
            "name": "Desmalezadora",
            "brand": "Makita",
            "quantity": 1
        },
        {
            "productId": 5,
            "name": "Zapatillas Deportivas",
            "brand": "Nike",
            "quantity": 2
        }
    ],
    "total": 67300,
    "statusResponse": {
        "code": "OK",
        "message": "La solicitud de compra se completó con éxito"
    }
}
```


`POST` /api/v1/shopping-cart

200 OK -> Doesn't return anything\
404 Not Found -> When the product is not in the database

`Request Body`

```json
{
    "productId": 27,
    "name": "Desmalezadora",
    "brand": "Makita",
    "quantity": 1
}
```

`GET` /api/v1/get-cart

200 OK -> Returns an empty list if you don't add a product.

`response`

```json
[
    {
        "id": 7,
        "name": "Redmi Note 9",
        "category": "Celulares",
        "brand": "Xiaomi",
        "price": 40000,
        "quantity": 1,
        "isFreeShipping": true,
        "points": 4
    }
]
```


`POST` /api/v1/purchase-shopping-cart

200 OK -> Returns a response.\
404 Nof Found -> If your shopping cart is empty.

`response`

```json
{
    "id": 136,
    "articles": [
        {
            "productId": 7,
            "name": "Redmi Note 9",
            "brand": "Xiaomi",
            "quantity": 1
        }
    ],
    "total": 40000,
    "statusResponse": {
        "code": "OK",
        "message": "La solicitud de compra se completó con éxito"
    }
}
```


## Clients

`POST` /api/v1/add-client

201 Created -> When the client is created\
400 Bad Request -> When invalid provincia or the client already exist\
500 Internal Server Error -> When malformed request json

`Request Body`

```json
{
    "firstName": "Loki",
    "lastName": "Gato",
    "dni": 213135,
    "direction": "Juana Manso",
    "provincia": "Buenos Aires"
}
```

```GET``` /api/v1/clients

You can add filter by provincia

200 OK -> Get a response list with all the clients in the database.\
400 Bad Request -> When you try to filter with an invalid provincia

`Response`

```json
[
    {
        "firstName": "Loki",
        "lastName": "Gato",
        "dni": 3213543,
        "direction": "Juana Manso",
        "provincia": "cordoba"
    },
    {
        "firstName": "Rata",
        "lastName": "Gato",
        "dni": 213135,
        "direction": "Juana Manso",
        "provincia": "Buenos Aires"
    }
]
```

