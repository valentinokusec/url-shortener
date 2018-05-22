Url Shortener
Instalacija
1. Skinuti jar file u zeljeni direktorij 
Pokretanje
1. Postaviti se nad direktorijem gdje se nalazi jar file 
2. Pokrenuti naredbu java -jar url-shortener.jar

Korištenje
Kreiranje Accounta 
POST - localhost:8080/account	
-body	
{	
"accountId" : "test"	
}	
-response	
{	
"success": true,	
"description": "Account created!",	
"password": "UfldMfBZ"	
}	
Registracija URL-a	
POST - localhost:8080/url	
-body	
{	
"url" : "http://www.stackoverflow.com",	
"type" : 302	
}	
-response	
{	
"url": "localhost:8080/url/shorturl/GJNXKZHvbF"	
}	
Pregled Statistike	
GET -	localhost:8080/url/statistic/test	
-response	
{	
"http://www.infobip.com": 1,	
"http://www.google.com": 2,	
"http://www.stackoverflow.com": 1	
}	
Swagger
1. Popis svih endpointova mozete naci na: http://localhost:8080/swagger-ui.html 
