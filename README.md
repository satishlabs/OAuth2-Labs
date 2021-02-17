# OAuth2-Labs
1. Authorization Code Grant Type :
Running Steps:
Step1: Send the Request to Authorizarion Server with the following URL to Get
the User’s Permission
A) Eendpoint - /oauth/authorize
B) Query Parameters
 - client_id,
 - redirect_uri,
 - response_type,
 - scope 

http://localhost:12345/oauth/authorize?client_id=satishapp&redirect_uri=http://localhost:5000/callback&response_type=code&scope=read_profile 

http://localhost:5000/callback?code=FpQMsh

Step 2: Send the POST Request to Authorizarion Server with the following to get an access token using the previously received Authorization Code
A) Eendpoint - /oauth/ token
B) Query Parameters
 - clientId,
 - clientSecrect
 - code received
 - redirect_uri,
 - grant_type,
 - scope 

curl -X POST http://localhost:12345/oauth/token --user satishapp:satish123 -H"content-type: application/x-www-form-urlencoded" -d"code=FpQMsh&grant_type=authorization_code&redirect_uri=http://localhost:5000/callback&scope=read_profile"
{
"access_token":"b22e00e7-61cf-46c9-8cdb-28279c68f437",
"token_type":"bearer",
"expires_in":43199,
"scope":"read_profile"
}

Step 3: Now access the BookPrice by providing the retrieved access You can now Invoke your Resources or REST API with the Access Token received above. 

curl -X GET http://localhost:12345/myapi/bookPrice/105 -H"authorization:Bearer 09092d12-033e-4be7-8466-ad20ff953fd7"

2. Implicit Type Server:
Running Steps:
Step1: Send the Request to Authorizarion Server with the following URL to Get the User’s Permission
A) Eendpoint - /oauth/authorize
B) Query Parameters
 - client_id,
 - redirect_uri,
 - response_type,
 - scope 

http://localhost:12345/oauth/authorize?client_id=satishapp&redirect_uri=http://localhost:5000/callback&response_type=token&scope=read_profile&state=hello 

Once the Approved by Resource Owner , you will be redirceted to redirect-uri given with Access token as follows. 

http://localhost:5000/callback#access_token=780b4a56-8498-4127-96b3-e8f24e0aaa08&token_type=bearer&state=hello&expires_in=119

Step 2: Now access the BookPrice by providing the retrieved access You can now Invoke your Resources or REST API with the Access Token received above. 

curl -X GET http://localhost:12345/myapi/bookPrice/105 -H "authorization:Bearer 470802cb-35ad-40e4-ac0e-760818f04e8d"


3. ResourceOnwer passsword type server:
Running Steps:
Step1: Send POST Request to Authorization Server to get the Access Token
A) Eendpoint - /oauth/token
B) Query Parameters
 - client_id,
 - Client Screct
 - grant_type=password
 - RO username
 - RO password
 - scope 

curl -X POST http://localhost:12345/oauth/token --user satishapp:satish123 -H"content-type: application/x-www-form-urlencoded" -d"grant_type=password&username=satish&password=satish&scope=read_profile" 

Above POST request will send the Access Token in the Response as follows
{
	"access_token":"9821aaf4-f6f6-4197-840b-155354c2ac67",
	"token_type":"bearer",
	"expires_in":299,
	"scope":"read_profile"
} 


{"access_token":"9821aaf4-f6f6-4197-840b-155354c2ac67","token_type":"bearer","expires_in":119,"scope":"read_profile"}

Step 2: Now access the BookPrice by providing the retrieved access You can now invoke your Resources or REST API with the Access Token received above.
curl -X GET http://localhost:12345/myapi/bookPrice/105 -H "authorization:Bearer 9821aaf4-f6f6-4197-840b-155354c2ac67" 


4. Client Credentials Grant Type:
Running Steps:
Step1: Send POST Request to Authorization Server to get the Access Token
A) Eendpoint - /oauth/token
B) Query Parameters
 - client_id,
 - Client Screct
 - grant_type=client_credentials
- scope 

curl -X POST "http://localhost:12345/oauth/token" --user satishapp:satish123 -d"grant_type=client_credentials&scope=read_profile" 

Above POST request will send the Access Token in the Response as follows
{
	"access_token":"126f398a-97da-423f-9464-68ab6f13cbfb",
	"token_type":"bearer",
	"expires_in":299,
	"scope":"read_profile"
} 

{"access_token":"c07c754a-6357-483d-a7e4-33e370821d35","token_type":"bearer","expires_in":119,"scope":"read_profile"}

Step 2: Now access the BookPrice by providing the retrieved accessYou can now invoke your Resources or REST API with the Access Token received above. 

curl http://localhost:12345/myapi/bookPrice/105 -H "Authorization: Bearer c07c754a-6357-483d-a7e4-33e370821d35"



5.Refresh Token Grant Type  : 

A)Using Refresh Token with Authorization Code
Running Steps:
Step1: Send the Request to Authorizarion Server with the following URL to Get the User’s Permission
A) Eendpoint - /oauth/authorize
B) Query Parameters
 - client_id,
 - redirect_uri,
 - response_type,
 - scope
http://localhost:12345/oauth/authorize?client_id=satishapp&redirect_uri=http://localhost:5000/callback&response_type=code&scope=read_profile

http://localhost:5000/callback?code=abM13B

Step 2: Send the POST Request to Authorizarion Server with the following to get an access token using the previously received Authorization Code
A) Eendpoint - /oauth/ token
B) Query Parameters
 - clientId,
 - clientSecrect
 - code received
 - redirect_uri,
 - grant_type,
 - scope
 
curl -X POST http://localhost:12345/oauth/token --user satishapp:satish123 -H"content-type:application/x-www-form-urlencoded" -d"code=abM13B&grant_type=authorization_code&redirect_uri=http://localhost:5000/callback&scope=read_profile"

The token endpoint will verify all the parameters in the request, ensuring the code hasn’t expired and that the client ID and secret match. If everything is ok, it will generate an access token and return it in the response!
{
	"access_token":"a4541852-44aa-41ea-81a9-e43279be9a54",
	"token_type":"bearer",
	"refresh_token":"ae3911b6-225e-42a1-bd80-f528d60319f5",
	"expires_in":179,
	"scope":"read_profile"
} 

Step 3: Now access the BookPrice by providing the retrieved access You can now Invoke your Resources or REST API with the Access Token received above.

curl -X GET http://localhost:12345/myapi/bookPrice/105 -H "authorization: Bearer a4541852-44aa-41ea-81a9-e43279be9a54"

Now you can get the Access Token again with Refresh Token when your Acces token expires.
Step A)
A) Eendpoint - /oauth/ token
B) Query Parameters
 - clientId,
 - clientSecrect
 - grant_type=refresh_token
 - refresh_token= -----  
 
curl -X POST http://localhost:12345/oauth/token --user satishapp:satish123 -H "content-type: application/x-www-form-urlencoded" -d "grant_type=refresh_token&refresh_token=ae3911b6-225e-42a1-bd80-f528d60319f5&scope=read_profile"
{
	"access_token":"d6866efa-b536-4fb6-8314-1618faed576c",
	"token_type":"bearer",
	"refresh_token":"ae3911b6-225e-42a1-bd80-f528d60319f5",
	"expires_in":179,
	"scope":"read_profile"
}


Step B: Now access the BookPrice by providing the retrieved access

curl -X GET http://localhost:12345/myapi/bookPrice/105 -H "authorization:Bearer d6866efa-b536-4fb6-8314-1618faed576c"



B)Using Refresh Token with Password Type
Running Steps:
Step1: Send POST Request to Authorization Server to get the Access Token
A) Eendpoint - /oauth/token
B) Query Parameters
 - ClientID , 
 - Client Screct , 
 - grant_type=password
 - RO username , 
 - RO password , 
 - scope
curl -X POST http://localhost:12345/oauth/token --user satishapp:satish123 -H "content-type: application/x-www-form-urlencoded" -d"grant_type=password&username=satish&password=satish&scope=read_profile" 


Above POST request will send the Access Token in the Response as follows
{
	"access_token":"7079e3fe-4061-48ae-acc7-16cad315bd4c",
	"token_type":"bearer",
	"refresh_token":"ae3911b6-225e-42a1-bd80-f528d60319f5",
	"expires_in":44,
	"scope":"read_profile"
}

curl -X GET http://localhost:12345/myapi/bookPrice/105 -H "authorization: Bearer 7079e3fe-4061-48ae-acc7-16cad315bd4c"

Now you can get the Access Token again with Refresh Token when your Acces token expires.
Step A)
A) Eendpoint - /oauth/ token
B) Query Parameters
 - clientId,
 - clientSecrect
 - grant_type=refresh_token
 - refresh_token= -----  
 
curl -X POST http://localhost:12345/oauth/token --user satishapp:satish123 -H "content-type: application/x-www-form-urlencoded" -d "grant_type=refresh_token&refresh_token=ae3911b6-225e-42a1-bd80-f528d60319f5&scope=read_profile"
{
	"access_token":"7079e3fe-4061-48ae-acc7-16cad315bd4c",
	"token_type":"bearer",
	"refresh_token":"ae3911b6-225e-42a1-bd80-f528d60319f5",
	"expires_in":179,
	"scope":"read_profile"
}


Step B: Now access the BookPrice by providing the retrieved access

curl -X GET http://localhost:12345/myapi/bookPrice/105 -H "authorization:Bearer 7079e3fe-4061-48ae-acc7-16cad315bd4c"
