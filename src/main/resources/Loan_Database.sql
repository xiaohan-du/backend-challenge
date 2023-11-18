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
