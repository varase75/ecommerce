Ecommerce
======================

Search price<br/>
This endpoint searches for price and should be able to filter by:
 - productId
 - brandId
 - date (format yyyy-MM-dd HH:mm)

[**GET**] /price

Example:
```
curl -X GET 'http://localhost:8090/price?productId=35455&brandId=1&date=2020-06-14%2010%3A00' -H 'accept: */*'
```