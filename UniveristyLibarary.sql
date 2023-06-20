CREATE TABLE Account (
  ACC_ID int AUTO_INCREMENT primary key,
  Email varchar(50),
  Password varchar(8)
);
CREATE TABLE Admin (
  A_ID int,
  FirstName varchar(50),
  LastName varchar(50),
  City varchar(50),
  Street varchar(50),
  PhoneNumber varchar(50),
  Gender varchar(8),
  Role varchar(50),
  ACC_ID int,
  PRIMARY KEY (A_ID),
  CONSTRAINT FK_Account 
  FOREIGN KEY (ACC_ID) 
  REFERENCES Account(ACC_ID)
  ON DELETE CASCADE 
  ON UPDATE CASCADE
);
CREATE TABLE Book (
  ISBN int,
  Title varchar(70),
  Category varchar(70),
  Languge  varchar(70),
  Edition varchar(70),
  PublisingYear varchar(70),
  PRIMARY KEY (ISBN)
);
CREATE TABLE Student (
  S_ID int,
  FirstName varchar(50),
  LastName varchar(50),
  City varchar(50),
  Street varchar(50),
  PhoneNumber varchar(50),
  Gender varchar(8),
  Department varchar(50),
  ACC_ID int,
  PRIMARY KEY (S_ID),
  CONSTRAINT FK_SAccount 
  FOREIGN KEY (ACC_ID) 
  REFERENCES Account(ACC_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE Publisher (
  Name varchar(50),
  City varchar(50),
  Country varchar(50),
  Street varchar(50),
  ISBN int,
CONSTRAINT P_Book
  FOREIGN KEY (ISBN) 
  REFERENCES Book(ISBN)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  PRIMARY KEY (Name, ISBN)
);


CREATE TABLE Author (
  Name varchar(50),
  Nationality varchar(50),
  ISBN int,
CONSTRAINT A_Book
  FOREIGN KEY (ISBN) 
  REFERENCES Book(ISBN)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  PRIMARY KEY (Name, ISBN)
);


CREATE TABLE Borrow (
  S_ID int,
  ISBN int,
  IssueDate Date,
  ReturnDate Date,
  CONSTRAINT S_Borrow
  FOREIGN KEY (S_ID) 
 REFERENCES Student(S_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT B_Borrow
  FOREIGN KEY (ISBN) 
  REFERENCES Book(ISBN)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  PRIMARY KEY (S_ID, ISBN)
);


