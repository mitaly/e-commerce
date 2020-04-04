# e-commerce

Added the Collection of APIs in "e-commerce.postman_collection.json".

APIs:
1. Create User:

POST localhost:8081/users

BODY:

	{
		"emailId":"senmitaly",
		"name":"Mitaly Sen",
		"password": "password"
	}
		
2. Create Item:

POST localhost:8081/items

BODY:

	{
		"itemName":"cardboard",
		"price":"20",
		"quantity": "212"
	}
		
3. Get all items:

GET localhost:8081/items/
	 
4. Get item by ID:

GET localhost:8081/items/1
	 
5. Update item:

PUT localhost:8081/items/4

BODY:
 	{
		"itemId":4,
		"itemName":"Book",
		"price":"20",
		"quantity": "40"
	}
		
6. Delete item By ID:
DELETE localhost:8081/items/1
	 
7. Order Item:
POST localhost:8081/orders?emailId=senmitaly
BODY:

	[
		{
			"itemId":2,
			"quantity":90909
		}
	]

8. Get all orders:

GET localhost:8081/orders?emailId=senmitaly
