create table "outbox"
(
    id            uuid    not null unique primary key,
    aggregateid   varchar not null,
    aggregatetype varchar not null,
    type          varchar not null,
    payload       varchar not null
);
