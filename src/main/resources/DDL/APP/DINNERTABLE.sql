create table DINNERTABLE
(
    TABLE_ID  INTEGER default GENERATED_BY_DEFAULT generated always as identity
        primary key,
    TABLESIZE INTEGER
);

