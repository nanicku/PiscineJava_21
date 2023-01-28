CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    login    varchar(20) unique not null,
    password varchar(20)        not null
);

CREATE TABLE IF NOT EXISTS chatrooms
(
    id    SERIAL PRIMARY KEY,
    name  varchar(20) not null,
    owner int         not null REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS messages
(
    id     SERIAL PRIMARY KEY,
    author int  not null REFERENCES users (id),
    room   int  not null REFERENCES chatrooms (id),
    text   text not null,
    date   timestamp
);

CREATE TABLE IF NOT EXISTS communication
(
    id_room   int not null REFERENCES chatrooms (id),
    id_author int not null REFERENCES users (id)
);