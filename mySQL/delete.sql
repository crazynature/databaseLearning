--1.
DELETE FROM `cs5200`.`address`
WHERE  person_id = (SELECT id FROM cs5200.person WHERE username ="alice") 
AND `primary` = true;

--2.
SET @maxOrder = (SELECT MAX(`order`) FROM `cs5200`.`widget` 
JOIN `cs5200`.`page` 
ON page_id = `cs5200`.`page`.`id` WHERE `cs5200`.`page`.`title` = "Contact") ;

DELETE FROM `cs5200`.`widget` 
WHERE `order` = @maxOrder
AND page_id = (SELECT id FROM `cs5200`.`page` WHERE `cs5200`.`page`.`title` = "Contact");

--3.

SET @id = (SELECT id FROM(SELECT MAX(`updated`), id FROM 
(SELECT `cs5200`.`page`.`updated`,`cs5200`.`page`.`id` FROM `cs5200`.`page` 
JOIN `cs5200`.`website` ON website_id = `cs5200`.`website`.`id` 
WHERE `cs5200`.`website`.`name` = "Wikipedia") AS a) AS b) ;

DELETE FROM `cs5200`.`page` 
WHERE `id` = @id;

CASCADE delete roles

--4.

DELETE FROM `cs5200`.`website` WHERE name = "CNET"

CASCADE delete page,priviledg,and roles
