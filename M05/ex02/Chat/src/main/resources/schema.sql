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
    owner bigint      not null REFERENCES users (id)

);

CREATE TABLE IF NOT EXISTS messages
(
    id     SERIAL PRIMARY KEY,
    author bigint not null REFERENCES users (id),
    room   bigint not null REFERENCES chatrooms (id),
    text   text   not null,
    date   timestamp
);

CREATE TABLE IF NOT EXISTS communication
(
    roomId bigint not null,
    userId bigint not null,
    primary key (roomId, userId),
    CONSTRAINT fk_user1 foreign key (userId) references users (id),
    CONSTRAINT fk_chatroom2 foreign key (roomId) references chatrooms (id)
);

SELECT *, users.id as id, chatrooms.id as id_room
FROM messages
         LEFT JOIN users ON messages.author = users.id
         LEFT JOIN chatrooms ON messages.room = chatrooms.id