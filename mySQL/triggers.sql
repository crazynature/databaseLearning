
	
	
DROP TRIGGER IF EXISTS `cs5200`.`page_role_AFTER_INSERT`;

DELIMITER $$
USE `cs5200`$$
CREATE DEFINER = CURRENT_USER TRIGGER `cs5200`.`page_role_AFTER_INSERT` AFTER INSERT ON `page_role` FOR EACH ROW
BEGIN
Set @id = (SELECT `page_id` from inserted);
Set @d_id = (SELECT `developer_id` from inserted);
Set @role = (SELECT `role` from inserted);
if @ role = "writer"
	then Set @p = "create, read, update";
 
elseif @ role = "editor"
	then Set @p = "read, update";
elseif @ role = "reviewer"
	then Set @p = " read,";
   end if;
INSERT INTO `cs5200`.`page_priviledge`
(`page_id`,
`developer_id`,
`priviledge`)
VALUES
(@id,
@d_id,
@p);

END$$
DELIMITER ;


