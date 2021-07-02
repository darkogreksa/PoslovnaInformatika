INSERT INTO unit(name) VALUES ('Kg');
INSERT INTO unit(name) VALUES ('L');
INSERT INTO unit(name) VALUES ('Komad');

INSERT INTO location(name) VALUES('Novi Sad');
INSERT INTO location(name) VALUES('Beograd');
INSERT INTO location(name) VALUES('Niš');

INSERT INTO company(name, pib, address, location_id) values ('Continental', '85479658', 'Radnicka 28', 1);
INSERT INTO company(pib, address, name, location_id) values ('12345', 'Nemanjina 1', 'Jugodrvo', 2);

INSERT INTO group_of_products(name, company_id) VALUES('Hrana', 1);
INSERT INTO group_of_products(name, company_id) VALUES('Piće', 2);

INSERT INTO product(name, group_of_products_id, unit_id) VALUES ('Brašno', 1, 1);
INSERT INTO product(name, group_of_products_id, unit_id) VALUES ('Kisela voda', 2, 2);

INSERT INTO authority values (1, 'ADMINISTRATOR')
INSERT INTO authority values (2, 'EMPLOYEE')
INSERT INTO `warehouse`.`employee` (`employee_id`, `full_name`, `password`, `role`, `username`, `company_id`) VALUES (1, 'Nikola Nikolic', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 1, '123', 1);
INSERT INTO `warehouse`.`user_authority` (`id`, `authority_id`, `employee_employee_id`) VALUES (1, 1, 1);

INSERT INTO business_partner(pib, address, name, company_id, location_id) VALUES ('123123', 'Jevrejska 32', 'Neki partner', 1, 1);

INSERT INTO business_year(year, closed, company_id) VALUES (2018, true, 1);
INSERT INTO business_year(year, closed, company_id) VALUES (2019, true, 1);
INSERT INTO business_year(year, closed, company_id) VALUES (2020, true, 2);

INSERT INTO warehouse(name, company_id) VALUES ('Magacin 1', 1);
INSERT INTO warehouse(name, company_id) VALUES ('Magacin 2', 1);
INSERT INTO warehouse(name, company_id) VALUES ('Magacin 3', 2);
INSERT INTO warehouse(name, company_id) VALUES ('Magacin 4', 2);



