CREATE VIEW deleveloper_roles_and_privileges AS
SELECT p.firstName,p.lastName,p.username,p.email,
w.name,w.visits,w.updated,
wr.role,
page.title,page.views,page.updated,
pr.role
FROM (((cs5200.person as p join cs5200.website_role as wr on p.id = wr.developer_id)
inner join cs5200.website as w on wr.website_id = w.id)
inner join cs5200.page on w.id = page.website_id)
inner join cs5200.page_role as pr on page.id = pr.page_id;

//I did't complete the trigger , so the privilledge part not in the view
join cs5200.page_priviledge as pp on p.id = page.developer_id;
join cs5200.website_priviledge as wp on p.id = wp.developer_id;

