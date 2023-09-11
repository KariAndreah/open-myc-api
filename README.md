# OPEN MYC API 

**Welcome to Open MYC API: Locate the Laughs**

All the comedy open mic info in the New York City five boroughs in one place, easily accessible through a modern RESTful API.

**This API is hosted on [Heroku](https://open-myc-api-b3fdf5fc5994.herokuapp.com/).**

All data is stored in a Heroku Postgres Database. The API was built using Spring Boot. 



## Get Requests

### Get all mics 
`GET /mics`

### Get mics by id
`Get /mics/{id}`

### Get mics by day 
`GET /mics/findByDay?day={day}`


**day**: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday

### Get free mics by day 
`GET /mics/findByDayFree?day={day}`


**day**: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday

### Get mics by day and time 
`GET /mics/findByDayTime?day={day}&startTime={startTime}&endTime={endTime}`


**day**: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
**startTime**: HH:MM:SS\
**endTime**: HH:MM:SS

### Get mics by day, borough, and time 
`GET /mics/findByAll?day={day}&borough={borough}&startTime={startTime}&endTime={endTime}`


**day**: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday\
**borough**: Manhattan, Queens, Bronx, Brooklyn, Staten-Island\
**startTime**: HH:MM:SS\
**endTime**: HH:MM:SS

### Get free mics by day, borough, and time 
`GET /mics/findByAllFree?day={day}&borough={borough}&startTime={startTime}&endTime={endTime}`


**day**: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday\
**borough**: Manhattan, Queens, Bronx, Brooklyn, Staten-Island\
**startTime**: HH:MM:SS\
**endTime**: HH:MM:SS 

***@Parameters are optional***

***All requests have Pagination and Sorting, append parameters:***\
pageNo={}\
pageSize={}\
sortBy={}





