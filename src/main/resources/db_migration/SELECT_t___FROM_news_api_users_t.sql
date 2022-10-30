create table news_api.users
(
    username  varchar(250) not null
        constraint users_pk
            primary key
        constraint users_username_key
            unique,
    password  varchar(250) not null,
    firstname varchar(250) not null,
    lastname  varchar(250) not null,
    role      varchar(250) not null,
    lock      boolean
);

alter table news_api.users
    owner to postgres;

INSERT INTO news_api.users (username, password, firstname, lastname, role, lock) VALUES ('admin', '$2a$12$1R/N6z8Gwh/BqgrPeQZiQeZsXQ.c6vMk59Wsimxmwg70wq9pVOPwy', 'admin', 'admin', 'ADMIN', false);
INSERT INTO news_api.users (username, password, firstname, lastname, role, lock) VALUES ('user', '$2a$12$CX1BU0PS8aKnnTuQuQ7cC.e/UOU7oTvbZGPfrdF64ndfDYjOa/2L2', 'user', 'user', 'USER', false);