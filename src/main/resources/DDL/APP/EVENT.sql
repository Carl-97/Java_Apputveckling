create table EVENT
(
    EVENT_ID    INTEGER not null
        constraint "EVENT_pk"
            primary key,
    DESCRIPTION VARCHAR(128),
    DATE        DATE    not null,
    NAME        VARCHAR(128)
);

