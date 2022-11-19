create table document(
    id UUID PRIMARY KEY,
    name varchar(256),
    object_id varchar(256),
    object_type varchar(256)
);

create table person(
    id          UUID PRIMARY KEY,
    name       varchar(256),
    object_id   varchar(256),
    object_type varchar(256)
);
