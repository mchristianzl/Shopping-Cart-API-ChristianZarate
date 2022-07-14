# Shopping-Cart-API-ChristianZarate

# Shopping Cart Exam

To run this project, you must execute with mvn using the command
```
 mvn spring-boot:run
```

This Project was tested in 

```
openjdk 18.0.1.1 2022-04-22
OpenJDK Runtime Environment (build 18.0.1.1+2-6)
OpenJDK 64-Bit Server VM (build 18.0.1.1+2-6, mixed mode, sharing)

```

### listing products in the shopping cart
```
[GET] http://localhost:8080/cart/get
```
The output
```
{
	"code": 1,
	"message": "Product listing",
	"data": [{
		"id": 456,
		"title": "Apple Watch S7 40mm",
		"price": 499.0,
		"quantity": 2,
		"taxes": 8.75,
		"type": "GNRL"
		}, ...
	]
}
```

### add product in the shopping cart

if you add a product that is in the cart, just increase the quantity
```
[POST] http://localhost:8080/cart/add
```
Input payload
```
{
	"id": 456,
	"title": "Apple Watch S7 40mm",
	"quantity": 2,
	"type": "GNRL",
	"price": 499
}
```

output 
```
{
	"code": 1,
	"message": "Product added",
	"data": [{
		"id": 456,
		"title": "Apple Watch S7 40mm",
		"price": 499.0,
		"quantity": 4,
		"taxes": 8.75,
		"type": "GNRL"
		}, ...
	]
}
```

### edit product in the shopping cart

The quantity is edited, but if you try to edit a product that is not in the cart, you will get an exception
```
[POST] http://localhost:8080/cart/edit
```
Input payload
```
{
	"id": 456,
	"quantity": 2
}
```

output 
```
{
	"code": 1,
	"message": "Product added",
	"data": [{
		"id": 456,
		"title": "Apple Watch S7 40mm",
		"price": 499.0,
		"quantity": 4,
		"taxes": 8.75,
		"type": "GNRL"
		}, ...
	]
}
```

### remove product in the shopping cart

Removes the product from the shopping cart, but if you try to remove a product that is not in the cart, you will get an exception
```
[DELETE] http://localhost:8080/cart/remove
```
Input payload
```
{
	"id": 456
}
```

output 
```
{
	"code": 1,
	"message": "Product removed"
}
```

