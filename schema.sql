CREATE TABLE Apparel (
	ApparelId int NOT NULL AUTO_INCREMENT,
	ApparelName varchar(255) NOT NULL,
	ApparelType varchar(255) NOT NULL,
	Price double NOT NULL,
	MakerId int,
PRIMARY KEY (ApparelId),
FOREIGN KEY (MakerId) REFERENCES Maker(MakerId)
);

CREATE TABLE Maker (
	MakerId int NOT NULL AUTO_INCREMENT,
	MakerName varchar(255) NOT NULL,
PRIMARY KEY (MakerId)
);

-- test data injection
INSERT INTO Maker
VALUES (1, 'Leikki');