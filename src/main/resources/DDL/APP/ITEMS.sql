create table ITEMS
(
    ITEM_ID      INTEGER default GENERATED_BY_DEFAULT generated always as identity
        primary key,
    DESCRIPTION  VARCHAR(255),
    ITEMCATEGORY CHAR(1),
    NAME         VARCHAR(255),
    PRICE        INTEGER
);

