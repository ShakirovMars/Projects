
CREATE TABLE Users(
    id int IDENTITY (1 ,1) PRIMARY KEY,
    email  VARCHAR(50)  NOT NULL,
    pass VARCHAR(5) NOT NULL,
    sex  VARCHAR(10) NOT NULL,
    sub  VARCHAR(10) NOT NULL,
	inf  VARCHAR(10) NOT NULL);