--1.
INSERT INTO `cs5200`.`person`
(`id`,
`firstName`,
`lastName`,
`username`,
`password`,
`email`)
VALUES
("12",
"Alice",
"Wonder",
"alice",
"alice",
"alice@wonder.com");
INSERT INTO `cs5200`.`person`
(`id`,
`firstName`,
`lastName`,
`username`,
`password`,
`email`)
VALUES
("23",
"Bob",
"Marley",
"bob",
"bob",
"bob@marley.com");
INSERT INTO `cs5200`.`person`
(`id`,
`firstName`,
`lastName`,
`username`,
`password`,
`email`)
VALUES
("34",
"Charles",
"Garcia",
"charlie",
"charlie",
"chuch@garcia.com");

INSERT INTO `cs5200`.`person`
(`id`,
`firstName`,
`lastName`,
`username`,
`password`,
`email`)
VALUES
("45",
"Dan",
"Martin",
"dan",
"dan",
"dan@martin.com");
INSERT INTO `cs5200`.`person`
(`id`,
`firstName`,
`lastName`,
`username`,
`password`,
`email`)
VALUES
("56",
"Ed",
"Karaz",
"ed",
"ed",
"ed@kar.com");

INSERT INTO `cs5200`.`developer`
(`id`,
`developer_key`)
VALUES
("12",
"4321rewq");
INSERT INTO `cs5200`.`developer`
(`id`,
`developer_key`)
VALUES
("23",
"5432trew");
INSERT INTO `cs5200`.`developer`
(`id`,
`developer_key`)
VALUES
("34",
"6543ytre");
INSERT INTO `cs5200`.`user`
(`id`,
`user_key`)
VALUES
("45",
"7654fda");
INSERT INTO `cs5200`.`user`
(`id`,
`user_key`)
VALUES
("56",
"5678dfgh");

--2.

INSERT INTO `cs5200`.`website`
(`id`,
`name`,
`description`,
`visits`)
VALUES
("123",
"Facebook",
"an online social media and social networking service",
"1234234");
INSERT INTO `cs5200`.`website`
(`id`,
`name`,
`description`,
`visits`)
VALUES
("234",
"Twitter",
"an online news and social networking service",
"4321543");
INSERT INTO `cs5200`.`website`
(`id`,
`name`,
`description`,
`visits`)
VALUES
("345",
"Wikipedia",
"a free online encyclopedia",
"3456654");
INSERT INTO `cs5200`.`website`
(`id`,
`name`,
`description`,
`visits`)
VALUES
("456",
"CNN",
"an American basic cable and satellite television news channel",
"6543345");
INSERT INTO `cs5200`.`website`
(`id`,
`name`,
`description`,
`visits`)
VALUES
("567",
"CNET",
"an American media website that publishes reviews, news, articles, blogs, podcasts and
videos on technology and consumer electronics",
"5433455");
INSERT INTO `cs5200`.`website`
(`id`,
`name`,
`description`,
`visits`)
VALUES
("678",
"Gizmodo",
"a design, technology, science and science fiction website that also writes articles on
politics",
"4322345");

INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("123",
"12",
"owner");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("234",
"23",
"owner");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("345",
"34",
"owner");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("456",
"12",
"owner");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("567",
"23",
"owner");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("678",
"34",
"owner");

INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("123",
"23",
"editor");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("234",
"34",
"editor");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("345",
"12",
"editor");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("456",
"23",
"editor");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("567",
"34",
"editor");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("678",
"12",
"editor");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("123",
"34",
"admin");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("234",
"12",
"admin");

INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)VALUES
("345",
"23",
"admin");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("456",
"34",
"admin");

INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("567",
"12",
"admin");
INSERT INTO `cs5200`.`website_role`
(`website_id`,
`developer_id`,
`role`)
VALUES
("678",
"23",
"admin");

--3.

INSERT INTO `cs5200`.`page`
(`id`,
`website_id`,
`title`,
`description`,
`views`)
VALUES
("123",
"567",
"Home",
"Landing page",
"123434");
INSERT INTO `cs5200`.`page`
(`id`,
`website_id`,
`title`,
`description`,
`views`)
VALUES
("234",
"678",
"About",
"Website description",
"234545");
INSERT INTO `cs5200`.`page`
(`id`,
`website_id`,
`title`,
`description`,
`views`)
VALUES
("567",
"567",
"Profile",
"Users can configure their personal information",
"567878");
INSERT INTO `cs5200`.`page`
(`id`,
`website_id`,
`title`,
`description`,
`views`)
VALUES
("345",
"345",
"Contact",
"Addresses, phones, and contact info",
"345656");

INSERT INTO `cs5200`.`page`
(`id`,
`website_id`,
`title`,
`description`,
`views`)
VALUES
("456",
"456",
"Preferences",
"Where users can configure their preferences",
"456776");

INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("123",
"12",
"editor");

INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("234",
"23",
"editor");

INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("345",
"34",
"editor");
INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("456",
"12",
"editor");

INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("567",
"23",
"editor");

INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("123",
"23",
"reviewer");

INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("234",
"34",
"reviewer");
INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("345",
"12",
"reviewer");
INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("456",
"23",
"reviewer");
INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("567",
"34",
"reviewer");
INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("123",
"34",
"writer");
INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("234",
"12",
"writer");
INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("345",
"23",
"writer");
INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("456",
"34",
"writer");
INSERT INTO `cs5200`.`page_role`
(`page_id`,
`developer_id`,
`role`)
VALUES
("567",
"12",
"writer");

--4.


INSERT INTO `cs5200`.`widget`
(`id`,
`page_id`,
`name`,
`text`,
`order`,
`DTYPE`)
VALUES
("123",
"123",
"head123",
"Welcome",
"0",
"HEADING");


INSERT INTO `cs5200`.`widget`
(`id`,
`page_id`,
`text`,
`name`,
`order`,
`html`,
`DTYPE`)
VALUES
("234",
"234",
"<p>Lorem</p>",
"post234",
"0",
"<p>Lorem</p>",
"HTML");

INSERT INTO `cs5200`.`widget`
(`id`,
`page_id`,
`text`,
`name`,
`order`,
`DTYPE`)
VALUES
("345",
"345",
"Hi",
"head345",
"1",
"HEADING");

INSERT INTO `cs5200`.`widget`
(`id`,
`page_id`,
`name`,
`text`,
`order`,
`html`,
`DTYPE`)
VALUES
("456",
"345",
"intro456",
"<h1>Hi</h1>",
"2",
"<h1>Hi</h1>",
"HTML");


INSERT INTO `cs5200`.`widget`
(`id`,
`page_id`,
`name`,
`width`,
`height`,
`order`,
`url`,
`DTYPE`)
VALUES
("567",
"345",
"image345",
"50",
"100",
"3",
"/img/567.png",
"IMAGE");


INSERT INTO `cs5200`.`widget`
(`id`,
`page_id`,
`name`,
`width`,
`height`,
`order`,
`url`,
`DTYPE`)
VALUES
("678",
"456",
"video456",
"400",
"300",
"0",
"https://youtu.be/h67VX51QXiQ",
"YOUTUBE");



INSERT INTO `cs5200`.`phone`
(`phone`,
`primary`,
`person_id`)
VALUES
("123-234-3456",
true,
"12");

INSERT INTO `cs5200`.`phone`
(`phone`,
`primary`,
`person_id`)
VALUES
("234-345-4566",
false,
"12");


INSERT INTO `cs5200`.`phone`
(`phone`,
`primary`,
`person_id`)
VALUES
("345-456-5677",
true,
"23");


INSERT INTO `cs5200`.`phone`
(`phone`,
`primary`,
`person_id`)
VALUES
("321-432-5435",
true,
"34");


INSERT INTO `cs5200`.`phone`
(`phone`,
`primary`,
`person_id`)
VALUES
("432-432-5433",
false,
"34");
INSERT INTO `cs5200`.`phone`
(`phone`,
`primary`,
`person_id`)
VALUES
("543-543-6544",
false,
"34");

INSERT INTO `cs5200`.`address`
(`street1`,
`city`,
`zip`,
`primary`,
`person_id`)
VALUES
("123 Adam St.",
"Alton",
"01234",
true,
"12");

INSERT INTO `cs5200`.`address`
(`street1`,
`city`,
`zip`,
`primary`,
`person_id`)
VALUES
("234 Birch St.",
"Boston",
"02345",
false,
"12");

INSERT INTO `cs5200`.`address`
(`street1`,
`city`,
`zip`,
`primary`,
`person_id`)
VALUES
("345 Charles St.",
"Chelms",
"03455",
true,
"23");
INSERT INTO `cs5200`.`address`
(`street1`,
`city`,
`zip`,
`primary`,
`person_id`)
VALUES
("456 Down St.",
"Dalton",
"04566",
false,
"23");

INSERT INTO `cs5200`.`address`
(`street1`,
`city`,
`zip`,
`primary`,
`person_id`)
VALUES
("543 East St",
"Everett",
"01112",
false,
"23");

INSERT INTO `cs5200`.`address`
(`street1`,
`city`,
`zip`,
`primary`,
`person_id`)
VALUES
("654 Frank St.",
"Foulton",
"04322",
true,
"34");

