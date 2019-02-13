--1.
UPDATE `cs5200`.`phone`
SET
`phone` = "333-444-5555"
WHERE person_id = (SELECT id FROM cs5200.person
WHERE username = "charlie") AND `primary` = true;

--2.
SET @o = (SELECT `order` FROM cs5200.widget WHERE name = "head345");
SET @pID = (SELECT page_id FROM cs5200.widget WHERE name = "head345");

UPDATE cs5200.widget SET `order` = CASE `order`
WHEN @o THEN 3
ELSE `order` + 2
END
WHERE page_id = @pID;

--3.
UPDATE  `cs5200`.`page`
SET 
`title` = CONCAT("CNET - ", `title`)
WHERE website_id in (SELECT id FROM
cs5200.website WHERE name = "CNET");

--4.
SET @Brole = (SELECT role FROM cs5200.page_role WHERE developer_id = (SELECT id FROM cs5200.person WHERE username = "charlie") AND `page_id` = (SELECT id FROM cs5200.page WHERE `title` = "CNET - Home"));
SET @Crole = (SELECT role FROM cs5200.page_role WHERE developer_id = (SELECT id FROM cs5200.person WHERE username = "bob") AND `page_id` = (SELECT id FROM cs5200.page WHERE `title` = "CNET - Home"));

UPDATE `cs5200`.`page_role`
SET
`role` = @Brole
WHERE `developer_id` = (SELECT id FROM cs5200.person WHERE username = "charlie")AND `page_id` = (SELECT id FROM cs5200.page WHERE `title` = "CNET - Home");
UPDATE `cs5200`.`page_role`
SET
`role` = @Crole
WHERE `developer_id` = (SELECT id FROM cs5200.person WHERE username = "bob")AND `page_id` =(SELECT id FROM cs5200.page WHERE `title` = "CNET - Home");



 

