SELECT officeCode, COUNT(*) as numReps 
FROM employees
WHERE (jobtitle = 'Sales Rep')
GROUP BY officeCode