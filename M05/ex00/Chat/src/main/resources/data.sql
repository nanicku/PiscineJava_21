insert into users (login, password)
VALUES ('Felix', '123456');
insert into users (login, password)
VALUES ('BangChan', '11');
insert into users (login, password)
VALUES ('LeeMinho', '22');
insert into users (login, password)
VALUES ('Changbin', '123456');
insert into users (login, password)
VALUES ('Hyunjin', '123456');
insert into users (login, password)
VALUES ('HanJisung', '123456');
insert into users (login, password)
VALUES ('Seungmin', '123456');
insert into users (login, password)
VALUES ('Jeongin', '123456');

insert into chatrooms (name, owner)
VALUES ('Singing', 2),
       ('Dancing', 1),
       ('Communication', 3),
       ('Drawing', 5),
       ('Fans', 4);

insert into messages (author, room, text, date)
VALUES (2, 1, 'I am here, let''s sing', current_timestamp AT TIME ZONE 'UTC'),
       (2, 2, 'I am not here, let''s Dance', current_timestamp AT TIME ZONE 'UTC'),
       (1, 5, 'I am here, hello my fans!', current_timestamp AT TIME ZONE 'UTC'),
       (7, 3, 'I am a boy', current_timestamp AT TIME ZONE 'UTC'),
       (8, 3, 'let''s communicate', current_timestamp AT TIME ZONE 'UTC'),
       (3, 3, 'I go to home', current_timestamp AT TIME ZONE 'UTC'),
       (4, 1, 'I like this', current_timestamp AT TIME ZONE 'UTC'),
       (5, 2, 'no no no', current_timestamp AT TIME ZONE 'UTC'),
       (6, 3, 'Yes, I am here', current_timestamp AT TIME ZONE 'UTC'),
       (3, 5, 'only without quarrels', current_timestamp AT TIME ZONE 'UTC'),
       (4, 5, 'love me as i am', current_timestamp AT TIME ZONE 'UTC'),
       (5, 4, 'let''s draw', current_timestamp AT TIME ZONE 'UTC');


insert into communication
VALUES (1, 3);
insert into communication
VALUES (2, 3);
insert into communication
VALUES (3, 5);
insert into communication
VALUES (1, 8);
insert into communication
VALUES (2, 5);
insert into communication
VALUES (3, 4);