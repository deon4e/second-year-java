
SELECT productVendor, productCode, (2 * quantityInStock) as newStock 
FROM products
WHERE productVendor LIKE ('%to%') 
AND productVendor LIKE ("Ex%");