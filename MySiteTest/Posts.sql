CREATE TABLE Posts(
    id int IDENTITY (1 ,1) PRIMARY KEY,
    UserId int NOT NULL,
    text VARCHAR(50) NOT NULL,
    date_post  smalldatetime NOT NULL);