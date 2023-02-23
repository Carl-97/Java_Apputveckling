create table ORDERS
(
    ORDERS_ID INTEGER default GENERATED_BY_DEFAULT generated always as identity
        primary key,
    ITEM_FK   INTEGER,
    PRICE     DOUBLE,
    QUANTITY  INTEGER,
    TABLE_FK  INTEGER
);

