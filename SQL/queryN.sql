SELECT officeCode, COUNT(*) as numEmps 
FROM employees
GROUP BY officeCode