--1.a
SELECT id
FROM cs5200.developer;

--1.b
SELECT username
FROM cs5200.person
JOIN cs5200.developer
ON developer.id=person.id
WHERE developer.id=34;

--1.c
SELECT `username` 
FROM cs5200.person 
JOIN(SELECT `developer_id` 
FROM cs5200.website_role 
WHERE website_id = 
(SELECT `id` 
FROM cs5200.website 
WHERE `name` = "Twitter")
 AND `role` != "owner")
AS a
ON developer_id = cs5200.person.id

--1.d
SELECT username
FROM cs5200.person
JOIN(SELECT developer_id
FROM cs5200.page_role
JOIN cs5200.page
ON page_role.page_id=page.id
WHERE page.views<300000 AND role='reviewer') AS a
ON person.id=developer_id; 

--1.e
SELECT username
FROM cs5200.person
JOIN(SELECT page_role.developer_id
FROM cs5200.page_role
JOIN(SELECT * FROM cs5200.website 
JOIN(SELECT page_id,website_id,title
FROM cs5200.page 
JOIN cs5200.widget ON page_id=cs5200.page.id
WHERE DTYPE="HEADING") AS a
ON website_id=website.id
WHERE title="Home") AS b
ON page_role.page_id=b.page_id
WHERE role="writer") AS c
ON developer_id=person.id;

--2.a
SELECT *
FROM cs5200.website
order BY visits 
limit 1;

--2.b
SELECT name
FROM cs5200.website
WHERE id='678';

--2.c
SELECT * FROM cs5200.website AS web JOIN
(SELECT p.website_id FROM cs5200.page AS p JOIN cs5200.widget AS w
ON p.id = w.page_id
WHERE w.DTYPE = "YOUTUBE") AS a
ON web.id = a.website_id;


--2.d
SELECT *
FROM cs5200.website AS w
JOIN(SELECT website_id
FROM website_role
JOIN(SELECT p.id
FROM cs5200.person AS p
WHERE username="alice") AS a
ON developer_id=a.id
WHERE role="owner") AS b
ON website_id=w.id;

--2.e
SELECT*
FROM cs5200.website AS w 
JOIN(SELECT website_id
FROM cs5200.website_role
JOIN(SELECT p.id
FROM cs5200.person AS p
WHERE username="charlie") AS a
ON developer_id=a.id
WHERE role="admin") AS b
ON website_id=w.id
WHERE visits>6000000;

--3.a
SELECT *
FROM page
order BY views desc limit 1;

--3.b
SELECT *
FROM cs5200.page
WHERE id=234;

--3.c
SELECT*
FROM page
JOIN(SELECT pageid
FROM pagerole
JOIN(SELECT person.id
FROM person
WHERE username="alice") AS a
ON developer_id=a.id
WHERE role="editor") AS b
ON page_id=page.id;

--3.d
SELECT sum(views)
FROM page
JOIN(SELECT id FROM website
WHERE name="CNET") AS a
ON a.id=website_id;

--3.e
SELECT avg(views)
FROM cs5200.page
JOIN(SELECT id 
FROM cs5200.website
WHERE name="Wikipedia") AS a
ON a.id=website_id;



--4.a
SELECT * 
FROM cs5200.widget 
JOIN
(SELECT p.id 
FROM cs5200.page AS p 
JOIN cs5200.website AS w
ON website_id = w.id
WHERE w.name = "CNET" 
AND p.title = "Home") AS a
ON a.id = page_id;

--4.b.
SELECT * FROM cs5200.widget 
JOIN (SELECT p.id 
FROM cs5200.page AS p 
JOIN cs5200.website AS w
ON website_id = w.id
WHERE w.name = "CNN") AS a
ON a.id = page_id
WHERE DTYPE = "YOUTUBE";

--4.c.
 SELECT * FROM cs5200.widget AS w 
JOIN(SELECT page_id F
ROM cs5200.page_role 
JOIN(SELECT id FROM cs5200.person 
WHERE username = "alice") AS a
ON developer_id = a.id
WHERE role = "reviewer") AS b
ON w.page_id = b.page_id
WHERE DTYPE = "IMAGE";

--4.d.
SELECT COUNT(*) FROM cs5200.widget 
JOIN(SELECT p.id 
FROM cs5200.page AS p 
JOIN cs5200.website AS w
ON website_id = w.id
WHERE w.name = "Wikipedia") AS a
ON a.id = page_id;
