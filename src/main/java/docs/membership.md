#Membership API Spec

##Register 
- Endpoint : POST /api/member
Request body:
``json
{
  "email": "user@nutech-integrasi.com",
  "first_name": "User",
  "last_name": "Nutech",
  "password": "abcdef1234"
}

``

Response body (Succes): 
`` json 
{
  "status": 0,
  "message": "Registrasi berhasil silahkan login",
  "data": null
}
``

Response body (failed): 
`` json 
{
  "status": 102,
  "message": "Paramter email tidak sesuai format",
  "data": null
}
``

##Login
- Endpoint : POST /api/auth
Request body:
``json
{
  "email": "user@nutech-integrasi.com",
  "password": "abcdef1234"
}

``

Response body (Succes): 
`` json 
{
  "status": 0,
  "message": "Login Sukses",
  "data": {
    "token": "Token",
    "expiredAt": 51635165 //milisecond
}
``
Response body (failed,400): 
`` json 
{
  "status": 102,
  "message": "Paramter email tidak sesuai format",
  "data": null
}
``

Response body (failed,401): 
`` json 
{
  "status": 103,
  "message": "Username atau password salah",
  "data": null
}
``

##Profile
- Endpoint : GET /api/member/current

Response body (Succes): 
`` json 
{
  "status": 0,
  "message": "Sukses",
  "data": {
    "email": "user@nutech-integrasi.com",
    "first_name": "User",
    "last_name": "Nutech",
    "profile_image": "https://yoururlapi.com/profile.jpeg"
  }
}
``

Response body (failed, 401): 
`` json 
{
  "status": 108,
  "message": "Token tidak tidak valid atau kadaluwarsa",
  "data": null
}
``


##Profile Update
- Endpoint : PATCH /api/member/current, //gunakan patch karna kalau put itu menimpa

Request body:
``json
{
  "first_name": "User Edited",
  "last_name": "Nutech Edited"
}
``

Response body (Succes): 
`` json 
{
  "status": 0,
  "message": "Update Pofile berhasil",
  "data": {
    "email": "user@nutech-integrasi.com",
    "first_name": "User Edited",
    "last_name": "Nutech Edited",
    "profile_image": "https://yoururlapi.com/profile.jpeg"
  }
}
``

Response body (failed, 401): 
`` json 
{
  "status": 108,
  "message": "Token tidak tidak valid atau kadaluwarsa",
  "data": null
}
``

##Profile image
- Endpoint : PUT /api/member/current

Request body:

file
string($binary)


Response body (Succes): 
`` json 
{
  "status": 0,
  "message": "Update Profile Image berhasil",
  "data": {
    "email": "user@nutech-integrasi.com",
    "first_name": "User Edited",
    "last_name": "Nutech Edited",
    "profile_image": "https://yoururlapi.com/profile-updated.jpeg"
  }
}
``

Response body (failed, 400): 
`` json 
  {
  "status": 102,
  "message": "Format Image tidak sesuai",
  "data": null
}
``

Response body (failed, 401): 
`` json 
{
  "status": 108,
  "message": "Token tidak tidak valid atau kadaluwarsa",
  "data": null
}
``

