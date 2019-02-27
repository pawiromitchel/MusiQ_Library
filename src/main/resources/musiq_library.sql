-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
    'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema musiq_library
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `musiq_library`;

-- -----------------------------------------------------
-- Schema musiq_library
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `musiq_library` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `musiq_library`;

-- -----------------------------------------------------
-- Table `musiq_library`.`artist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musiq_library`.`artist`;

CREATE TABLE IF NOT EXISTS `musiq_library`.`artist`
(
  `id`          BIGINT(4)   NOT NULL AUTO_INCREMENT,
  `artist_name` VARCHAR(45) NOT NULL,
  `artist_type` VARCHAR(45) NOT NULL,
  `is_followed` INT(1)      NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musiq_library`.`album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musiq_library`.`album`;

CREATE TABLE IF NOT EXISTS `musiq_library`.`album`
(
  `id`           BIGINT(4)   NOT NULL AUTO_INCREMENT,
  `album_title`  VARCHAR(45) NOT NULL,
  `artist_id`    BIGINT(4)   NOT NULL,
  `release_year` INT(4)      NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `artist_id_idx` (`artist_id` ASC) VISIBLE,
  CONSTRAINT `artist_id`
    FOREIGN KEY (`artist_id`)
      REFERENCES `musiq_library`.`artist` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musiq_library`.`song`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musiq_library`.`song`;

CREATE TABLE IF NOT EXISTS `musiq_library`.`song`
(
  `id`           BIGINT(4)   NOT NULL AUTO_INCREMENT,
  `title`        VARCHAR(45) NOT NULL,
  `release_year` INT(4)      NULL,
  `album_id`     BIGINT(4)   NULL,
  `is_favorite`  INT(1)      NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `album_id_idx` (`album_id` ASC) VISIBLE,
  CONSTRAINT `album_id`
    FOREIGN KEY (`album_id`)
      REFERENCES `musiq_library`.`album` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `musiq_library`.`playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `musiq_library`.`playlist`;

CREATE TABLE IF NOT EXISTS `musiq_library`.`playlist`
(
  `id`            BIGINT(4)   NOT NULL AUTO_INCREMENT,
  `playlist_name` VARCHAR(45) NOT NULL,
  `song_id`       BIGINT(4)   NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `song_id_idx` (`song_id` ASC) VISIBLE,
  CONSTRAINT `song_id`
    FOREIGN KEY (`song_id`)
      REFERENCES `musiq_library`.`song` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `musiq_library`.`artist`
-- -----------------------------------------------------
START TRANSACTION;
USE `musiq_library`;
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`)
VALUES ('Queen', 'BAND', 0);
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`)
VALUES ('Bon Jovi', 'BAND', 0);
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`)
VALUES ('Eminem', 'SOLO', 0);
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`)
VALUES ('Michael Jackson', 'SOLO', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('\'N Sync', 'BAND', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('NWA', 'GROUP', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('Linkin Park', 'BAND', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('Marroon 5', 'BAND', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('Bruno Mars', 'SOLO', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('Daft Punk', 'DUO', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('Alicia Keys', 'SOLO', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('Jay-Z', 'SOLO', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('Beyonce', 'SOLO', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('Destiny\'s Child', 'GROUP', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('Boyz II Men', 'GROUP', '0');
INSERT INTO `musiq_library`.`artist` (`artist_name`, `artist_type`, `is_followed`) 
VALUES ('The Temptations', 'GROUP', '0');


COMMIT;


-- -----------------------------------------------------
-- Data for table `musiq_library`.`album`
-- -----------------------------------------------------
START TRANSACTION;
USE `musiq_library`;
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`)
VALUES ('Bohemian Rhapsody', 1, 1975);
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`)
VALUES ('Slippery When Wet', 2, 1986);
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`)
VALUES ('The Marshall Mathers LP', 3, 2000);
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('Thriller', '4', '1982');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('No Strings Attached', '5', '2000');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('Straight Outta Compton', '6', '1988');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('Meteora', '7', '2003');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('Songs About Jane', '8', '2003');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('24K Magic', '9', '2016');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('Random Access Memories', '10', '2010');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('Songs in a Minor', '11', '2001');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('The Blueprint 3', '12', '2009');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('I Am... Sasha Fierce', '13', '2008');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('The Writing\'s on the Wall', '14', '1999');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('Boomerang Soundtrack', '15', '1992');
INSERT INTO `musiq_library`.`album` (`album_title`, `artist_id`, `release_year`) 
VALUES ('The Temptations Sing Smokey', '16', '1965');


COMMIT;


-- -----------------------------------------------------
-- Data for table `musiq_library`.`song`
-- -----------------------------------------------------
START TRANSACTION;
USE `musiq_library`;
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`)
VALUES ('Living on a Prayer', 1986, 2, 0);
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`)
VALUES ('Bohemian Rhapsody', 1975, 1, 0);
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`)
VALUES ('The Real Slim Shady', 2000, 3, 0);
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('Thriller', '1982', '4', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('Bye Bye Bye', '2000', '5', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('F*ck the Police', '1988', '6', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('Numb', '2003', '7', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('This Love', '2003', '8', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('Finesse', '2016', '9', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('Get Lucky', '2010', '10', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('A Woman\'s Worth', '2001', '11', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('Empire State of Mind', '2009', '12', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('Single Ladies', '2008', '13', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('Say My Name', '1999', '14', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('End of the Road', '1992', '15', '0');
INSERT INTO `musiq_library`.`song` (`title`, `release_year`, `album_id`, `is_favorite`) 
VALUES ('My Girl', '1964', '16', '0');


COMMIT;

