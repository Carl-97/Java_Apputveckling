create table ITEMS
(
    ITEM_ID        INTEGER not null
        constraint "ITEMS_pk"
            primary key,
    NAME           VARCHAR(20),
    DESCRIPTION    VARCHAR(100),
    PRICE          INTEGER not null,
    "itemCategory" INTEGER
);

