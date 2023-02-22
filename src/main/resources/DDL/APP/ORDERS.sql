create table ORDERS
(
    ORDERS_ID INTEGER not null
        constraint "ORDERS_pk"
            primary key,
    TABLE_FK  INTEGER not null
        constraint "ORDERS_DINNERTABLE_TABLE_ID_fk"
            references DINNERTABLE,
    QUANTITY  INTEGER not null,
    PRICE     DOUBLE  not null,
    ITEM_FK   INTEGER not null
        constraint "ORDERS_ITEMS_ITEM_ID_fk"
            references ITEMS
);

