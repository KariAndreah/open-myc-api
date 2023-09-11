# OPEN MYC API 

Welcome to OpenMYC: Locate the Laughs

All the open mic data in NYC in one place, 
easily accessible through a modern RESTful API.

## Get Requests

`GET /mics`
Get All Mics 

`Get /mics/{id}`
Get Mic by ID

`GET /mics/findByDay?day={day}`
Get Mic by Day (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)

`GET /mics/findByDayFree?day={day}`
Get Mic by Day and Free (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)

`GET /mics/findByDayTime?day={day}&startTime={startTime}&endTime={endTime}`
Get Mic by:
Day (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)
Time('HH:MM:SS')

`GET /mics/findByAllFree?day={day}&borough={borough}&startTime={startTime}&endTime={endTime}`
Get Mic by All Parameters and Free 
Day (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)
Borough (Manhattan, Queens, Bronx, Brooklyn, Staten-Island)
Time('HH:MM:SS')



All requests have Pagination and Sorting, append parameters:
pageNo={}
pageSize={}
sortBy={}





