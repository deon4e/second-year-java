SELECT orders.orderNumber, orders.comments, customers.customerName
FROM orders
INNER JOIN customers ON orders.customerNumber = customers.customerNumber
WHERE(orders.status = 'Disputed')