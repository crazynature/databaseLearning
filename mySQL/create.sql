--1.
create schema `cs5200`  (already exist for A1)
--2.
CREATE TABLE `cs5200`.`person` (
 `id` INT NOT NULL,
 `firstName` VARCHAR(45) NULL,
 `lastName` VARCHAR(45) NULL,
 `username` VARCHAR(45) NOT NULL,
 `password` VARCHAR(45) NOT NULL,
 `email` VARCHAR(45) NULL,
 `dob` DATE NULL,
 PRIMARY KEY (`id`));
 
 CREATE TABLE `cs5200`.`developer` (
 `id` INT NOT NULL,
 `developer_key` VARCHAR(45) NOT NULL,
 PRIMARY KEY (`id`),
 CONSTRAINT `developer_person_generalization`
 FOREIGN KEY (`id`)
 REFERENCES `cs5200`.`person` (`id`)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION);
 
 CREATE TABLE `cs5200`.`user` (
 `id` INT NOT NULL,
 `user_agreement` TINYINT,
 `user_key` VARCHAR(45),
  PRIMARY KEY (`id`),
 CONSTRAINT `user_person_generalization`
 FOREIGN KEY (`id`)
 REFERENCES `cs5200`.`person` (`id`)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION);
 
-- 3.
 CREATE TABLE `cs5200`.`website` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(45) NOT NULL,
 `description` VARCHAR(200) NULL,
 `created` DATETIME NOT NULL DEFAULT '2018-10-08' ,
 `updated` DATETIME NOT NULL DEFAULT '2018-10-08' ,
 `visits` INT NULL,
 `developer_id` INT NULL,
 PRIMARY KEY (`id`),
 INDEX `developer_id_fk_idx` (`developer_id` ASC),
 CONSTRAINT `developer_id_fk`
 FOREIGN KEY (`developer_id`)
 REFERENCES `cs5200`.`developer` (`id`)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION);
 
 
 CREATE TABLE `cs5200`.`page` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `website_id` INT NOT NULL,
 `title` VARCHAR(45) NOT NULL,
 `description` VARCHAR(1000) NULL,
 `created` DATE NOT NULL DEFAULT '2018-09-05' ,
 `updated` DATE NOT NULL DEFAULT '2018-10-08' ,
 `views` INT NULL,
 PRIMARY KEY (`id`),
 INDEX `website_id_fk_idx` (`website_id` ASC),
 CONSTRAINT `website_id_fk`
 FOREIGN KEY (`website_id`)
 REFERENCES `cs5200`.`website` (`id`)
 ON DELETE CASCADE
 ON UPDATE NO ACTION);
 
 CREATE TABLE `cs5200`.`weiget` (
  `id` INT NOT NULL,
 `page_id` INT NOT NULL,
 `name` VARCHAR(45) NULL,
 `width` INT NULL,
 `height` INT NULL,
 `css_class` VARCHAR(45) NULL,
 `css_style` VARCHAR(45) NULL,
 `text` VARCHAR(45) NULL,
 `order` INT NULL,
 `size` INT NULL DEFAULT 2,
 `html` VARCHAR(45) NULL,
 `src` VARCHAR(45) NULL,
 `url` VARCHAR(45) NULL,
 `sharable` TINYINT(1) NULL,
 `expandable` TINYINT(1) NULL,
 `DTYPE` VARCHAR(45) NULL DEFAULT 'WEIGET',
  PRIMARY KEY (`id`));
  
  CREATE TABLE `cs5200`.`phone` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `phone` VARCHAR(45) NOT NULL,
 `primary` TINYINT(1) NOT NULL DEFAULT FALSE,
 `person_id` INT NOT NULL,
 PRIMARY KEY (`id`),
 CONSTRAINT `person_id_fk`
 FOREIGN KEY (`person_id`)
 REFERENCES `cs5200`.`person` (`id`)
 ON DELETE CASCADE
 ON UPDATE NO ACTION);
 
CREATE TABLE `cs5200`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street1` VARCHAR(45) NULL,
  `street2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zip` VARCHAR(45) NULL,
  `primary` TINYINT(1) NULL DEFAULT 0,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `address_person_fk`
    FOREIGN KEY (`person_id`)
    REFERENCES `cs5200`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

	
CREATE TABLE `cs5200`.`role` (
 `type` VARCHAR(45) NOT NULL,
 PRIMARY KEY (`type`));
 
 INSERT INTO `cs5200`.`role`
(`type`)
VALUES
("owner");
INSERT INTO `cs5200`.`role`
(`type`)
VALUES
("admin");
INSERT INTO `cs5200`.`role`
(`type`)
VALUES
("writer");
INSERT INTO `cs5200`.`role`
(`type`)
VALUES
("editor");
INSERT INTO `cs5200`.`role`
(`type`)
VALUES
("reviewer");
 
 
CREATE TABLE `cs5200`.`website_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `website_id` INT NULL,
  `develper_id` INT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `websit_id_idx` (`website_id` ASC),
  INDEX `developer_id_kf_idx` (`develper_id` ASC),
  INDEX `role_type_fk_idx` (`role` ASC),
  CONSTRAINT `websit_id_fk`
    FOREIGN KEY (`website_id`)
    REFERENCES `cs5200`.`website` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `developer_id_kf`
    FOREIGN KEY (`develper_id`)
    REFERENCES `cs5200`.`developer` (`id`)
    ON DELETE NO CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `role_type_fk`
    FOREIGN KEY (`role`)
    REFERENCES `cs5200`.`role` (`type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `cs5200`.`page_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `page_id` INT NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `developer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `developer_page_id_fk_idx` (`developer_id` ASC),
  INDEX `page_id_fk_idx` (`page_id` ASC),
  INDEX `role_page_type_fk_idx` (`role` ASC),
  CONSTRAINT `page_id_fk`
    FOREIGN KEY (`page_id`)
    REFERENCES `cs5200`.`page` (`id`)
    ON DELETE NO CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `developer_page_id_fk`
    FOREIGN KEY (`developer_id`)
    REFERENCES `cs5200`.`developer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role_page_type_fk`
    FOREIGN KEY (`role`)
    REFERENCES `cs5200`.`role` (`type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

	

 
 
 
  
  
