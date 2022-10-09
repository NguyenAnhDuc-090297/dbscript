CREATE USER ductest IDENTIFIED BY 123456;
--GRANT CREATE TABLE TO ductest;
GRANT ALL PRIVILEGES TO ductest;

CREATE TABLE ductest.cricketers_data(
   id NUMBER NOT NULL,
   First_Name VARCHAR(255),
   Last_Name VARCHAR(255),
   Place_Of_Birth VARCHAR(255),
   Country VARCHAR(255),
   PRIMARY KEY(id)
);