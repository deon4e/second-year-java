SELECT orders.orderNumber, orders.status, orderdetails.priceEach, orderdetails.quantityOrdered, products.productName
FROM ((orderdetails
INNER JOIN orders ON orders.orderNumber = orderdetails.orderNumber)
INNER JOIN products ON orderdetails.productCode = products.productCode) 
WHERE(products.productVendor = 'Exoto Designs')
