CREATE SCHEMA IF NOT EXISTS loanschedule;
USE loanschedule;

-- -----------------------------------------------------
-- Table actions
-- -----------------------------------------------------

DROP TABLE IF EXISTS loan;


-- -----------------------------------------------------
-- Table loan
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS loan
(
    id int(11) NOT NULL AUTO_INCREMENT,
    payment DOUBLE,
    principal DOUBLE,
    interest DOUBLE,
    balance DOUBLE,
    PRIMARY KEY (`id`)
    )
    engine = InnoDB;

-- -----------------------------------------------------
-- Insert Data
-- -----------------------------------------------------

INSERT INTO loan (payment, principal, interest, balance)
VALUES (1735.15, 1610.15, 125.00, 18389.85),
       (1735.15, 1620.21, 114.94, 16769.64);
