DESCRIBE ARTIST;

/* DISPLAY ARTIST NAMES THAT START WITH R */
/* The modules means "any after that" */
SELECT NAME FROM ARTIST WHERE NAME LIKE 'R%';
/* Hangman, you can use under scores to tell that the letter
is variable */
/* Give me the names that start with anything, second later is 'a'
and the rest doesn't matter */
SELECT NAME FROM ARTIST WHERE NAME LIKE '_a%';
SELECT NAME FROM ARTIST WHERE NAME LIKE '_a_k%';

/* GROUP BY */
SELECT FIRSTNAME, COUNT(FIRSTNAME) AS REPEATS
FROM CUSTOMER
GROUP BY FIRSTNAME
HAVING COUNT(FIRSTNAME) > 1
ORDER BY REPEATS DESC;
/* Remember default for ORDER BY is ASC */

/* Which customers have spent more than 45 dollars? */
SELECT C.FIRSTNAME, C.LASTNAME, SUM(I.TOTAL) AS AMOUNT_SPENT_LIFE_TIME
FROM CUSTOMER C, INVOICE I
WHERE 
C.CUSTOMERID = I.CUSTOMERID
GROUP BY (C.FIRSTNAME, C.LASTNAME)
HAVING SUM(I.TOTAL) > 45;

/* How many times has each customer bought something? */
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, COUNT(*) AS TIMES_AT_THE_STORE
FROM CUSTOMER C, INVOICE I
WHERE 
C.CUSTOMERID = I.CUSTOMERID
GROUP BY (C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME);