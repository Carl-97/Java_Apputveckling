create table TODAYSLUNCH
(
    LUNCH_ID    INTEGER default GENERATED_BY_DEFAULT generated always as identity
        primary key,
    DATE        DATE,
    DESCRIPTION VARCHAR(255),
    NAME         VARCHAR(255),
    PRICE        INTEGER
);

