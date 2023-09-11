# OPEN MYC API 

**Welcome to OpenMYC: Locate the Laughs**

All the comedy open mic data in NYC in one place, 
easily accessible through a modern RESTful API.

**This API is hosted on [Heroku](https://open-myc-api-b3fdf5fc5994.herokuapp.com/).**



## Get Requests

`GET /mics`\
Get All Mics 

`Get /mics/{id}`\
Get Mic by ID

`GET /mics/findByDay?day={day}`\
Get Mics by day (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)

`GET /mics/findByDayFree?day={day}`\
Get Mics by:\
day (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)\
And Free 

`GET /mics/findByDayTime?day={day}&startTime={startTime}&endTime={endTime}`\
Get Mics by:\
day (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)\
time('HH:MM:SS')

`GET /mics/findByAll?day={day}&borough={borough}&startTime={startTime}&endTime={endTime}`\
Get Mics by All Parameters:\
day (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)\
borough (Manhattan, Queens, Bronx, Brooklyn, Staten-Island)\
time('HH:MM:SS')

`GET /mics/findByAllFree?day={day}&borough={borough}&startTime={startTime}&endTime={endTime}`\
Get Mics by All Parameters and Free:\ 
day (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)\
borough (Manhattan, Queens, Bronx, Brooklyn, Staten-Island)\
time('HH:MM:SS')

*@Parameters are optional*

*All requests have Pagination and Sorting, append parameters:*\
pageNo={}\
pageSize={}\
sortBy={}





