DROP TABLE IF EXISTS Product;

CREATE TABLE IF NOT EXISTS Product
(
    Id    INT IDENTITY PRIMARY KEY,
    Name  VARCHAR(50) NOT NULL,
    Price INT         NOT NULL
);