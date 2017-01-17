CREATE TABLE `user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(250) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` char(1) DEFAULT NULL,
  `updated_by` varchar(250) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user_roles` (
  `user_account_id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  KEY `FK_9alsrb1bgf963xcw9lpxcu8km` (`user_account_id`),
  CONSTRAINT `FK_9alsrb1bgf963xcw9lpxcu8km` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `user_account`(`id`, `created_by`, `created_date`, `deleted`, `updated_by`, `updated_date`, `password`, `username`)
values(1, 'System', now(), 'N', 'System', now(), '$2a$06$NywVYP8UldH.bOzUFdBgrue4kOSEA0MwDIQ5Rg.Uo5hUKo9z.pBxq', 'admin');

insert into `user_roles`(`user_account_id`, `role`)
values(1, 'ROLE_ADMIN');