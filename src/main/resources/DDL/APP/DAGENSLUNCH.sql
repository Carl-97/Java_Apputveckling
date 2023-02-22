create table DAGENSLUNCH
(
    LUNCH_ID    INTEGER not null
        constraint "DAGENSLUNCH_pk"
        primary key,
    DESCRIPTION VARCHAR(100),
    DATE        DATE,
    NAME        VARCHAR(20),
    PRICE       INTEGER default 90 not null
);

