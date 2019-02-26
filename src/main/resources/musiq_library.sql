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
INSERT INTO `musiq_library`.`artist` (`id`, `artist_name`, `artist_type`, `is_followed`)
VALUES (1, 'Queen', 'BAND', 0);
INSERT INTO `musiq_library`.`artist` (`id`, `artist_name`, `artist_type`, `is_followed`)
VALUES (2, 'Bon Jovi', 'BAND', 0);
INSERT INTO `musiq_library`.`artist` (`id`, `artist_name`, `artist_type`, `is_followed`)
VALUES (3, 'Eminem', 'SOLO', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `musiq_library`.`album`
-- -----------------------------------------------------
START TRANSACTION;
USE `musiq_library`;
INSERT INTO `musiq_library`.`album` (`id`, `album_title`, `artist_id`, `release_year`)
VALUES (1, 'Bohemian Rhapsody', 1, 1975);
INSERT INTO `musiq_library`.`album` (`id`, `album_title`, `artist_id`, `release_year`)
VALUES (2, 'Slippery When Wet', 2, 1986);
INSERT INTO `musiq_library`.`album` (`id`, `album_title`, `artist_id`, `release_year`)
VALUES (3, 'The Marshall Mathers LP', 3, 2000);

COMMIT;


-- -----------------------------------------------------
-- Data for table `musiq_library`.`song`
-- -----------------------------------------------------
START TRANSACTION;
USE `musiq_library`;
INSERT INTO `musiq_library`.`song` (`id`, `title`, `release_year`, `album_id`, `is_favorite`)
VALUES (1, 'Living on a Prayer', 1986, 2, 0);
INSERT INTO `musiq_library`.`song` (`id`, `title`, `release_year`, `album_id`, `is_favorite`)
VALUES (2, 'Bohemian Rhapsody', 1975, 1, 1);
INSERT INTO `musiq_library`.`song` (`id`, `title`, `release_year`, `album_id`, `is_favorite`)
VALUES (3, 'The Real Slim Shady', 2000, 3, 1);

COMMIT;

