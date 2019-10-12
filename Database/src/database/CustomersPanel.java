/*
TABLE CREATION:

CREATE TABLE GEW.Customers ( 
    `CustomerID` 	INT PRIMARY KEY AUTO_INCREMENT,
    `First Name` 	varchar(30) DEFAULT NULL,
    `Last Name` 	varchar(30) DEFAULT NULL,
    `Email` 		varchar(50) DEFAULT NULL,
    `Address` 		varchar(50) DEFAULT NULL,
    `Phone` 		varchar(30) DEFAULT NULL
    )

INSERT ROW:

INSERT INTO GEW.Customers
	(`First Name`, `Last Name`, `Email`, `Address`, `Phone`)
VALUES 
	("Gordon", "Man", "Gordon.Mannie@gmail.com", "14518 Juniper St. San Leandro, CA", 
     "(510) 693 - 9915)")

ADD COLUMN:

ALTER TABLE GEW.Customers ADD Birthday VARCHAR(20)

REMOVE COLUMN:

ALTER TABLE GEW.Customers DROP Birthday;


 */
package database;

/**
 *
 * @author gordonman
 */
public class CustomersPanel {
    
}
