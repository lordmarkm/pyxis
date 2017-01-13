DROP TABLE IF EXISTS `category_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(250) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` char(1) DEFAULT NULL,
  `updated_by` varchar(250) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--Create some default category groups
insert into `category_group`(id, name, deleted, created_by, created_date, updated_by, updated_date) values
    (1, 'Makeup', 'N', 'System', now(), 'System', now()),
    (2, 'Scents', 'N', 'System', now(), 'System', now()),
    (3, 'Body', 'N', 'System', now(), 'System', now()),
    (4, 'Bath', 'N', 'System', now(), 'System', now()),
    (5, 'Hair', 'N', 'System', now(), 'System', now());

--Handle many-to-one mapping of category to category-group
alter table `category` add column `category_group_id` bigint(20) DEFAULT NULL;
alter table `category` add constraint `fk_category_category_group` foreign key(`category_group_id`) references `category_group`(id);

--Assign default categories to category groups
update `category` set `category_group_id`=1 where name='Lipsticks';
update `category` set `category_group_id`=1 where name='Masks';
update `category` set `category_group_id`=1 where name='Eye Shadow';
update `category` set `category_group_id`=2 where name='Perfume';











