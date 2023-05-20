create database Youtube;

use Youtube;


CREATE TABLE studentInfo(
Id INT,
Name VARCHAR(50),
Marks INT
);

INSERT INTO studentInfo VALUES ( 1,"XYZ",400);
INSERT INTO studentInfo VALUES ( 2,"ABC",360);
INSERT INTO studentInfo VALUES ( 3,"PQR",358);
INSERT INTO studentInfo VALUES ( 4,"WYZ",450);
INSERT INTO studentInfo VALUES ( 5,"EFG",268);
INSERT INTO studentInfo VALUES ( 6,"OMP",310);
INSERT INTO studentInfo VALUES ( 7,"LMN",430);
INSERT INTO studentInfo VALUES ( 8,"ASD",256);

SELECT* FROM studentInfo;