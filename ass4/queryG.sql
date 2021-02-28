SELECT * 
FROM offices
WHERE (state IS NULL)
AND (addressLine2 IS NOT NULL)
