INSERT INTO unit(name) VALUES ('Kg');

INSERT INTO location(name) VALUES('Novi Sad');

INSERT INTO company(name, pib, address, location_id) values ('Continental', '85479658', 'Radnicka 28', 1);

INSERT INTO group_of_products(name, company_id) VALUES('Hrana', 1);

INSERT INTO product(name, group_of_products_id, unit_id) VALUES ('Brasno', 1, 1);

INSERT INTO authority values (1, 'ADMINISTRATOR')
INSERT INTO authority values (2, 'EMPLOYEE')
INSERT INTO `warehouse`.`employee` (`employee_id`, `full_name`, `password`, `role`, `username`, `company_id`) VALUES (1, 'Nikola Nikolic', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 1, '123', 1);
INSERT INTO `warehouse`.`user_authority` (`id`, `authority_id`, `employee_employee_id`) VALUES (1, 1, 1);
