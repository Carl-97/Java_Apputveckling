--No semicolon at end, just continue writing next row, all MUST be on the same row for each insert
--INSERT INTO TABLE_NAME(TABLE_COLUMN,...) VALUES(TABLE_VALUE,...)

INSERT INTO DINNERTABLE(TABLESIZE) VALUES (8),(6),(4)

INSERT INTO TODAYSLUNCH(DATE, DESCRIPTION, NAME) VALUES ('2023-02-22','Varmrätt','Pasta'),('2023-02-22','Varmrätt','Kött'),('2023-02-22','Varmrätt','Vegetarisk')

INSERT INTO ITEMS(DESCRIPTION, ITEMCATEGORY, NAME, PRICE) VALUES ('desc', 'V', 'Oxfilé', 250)