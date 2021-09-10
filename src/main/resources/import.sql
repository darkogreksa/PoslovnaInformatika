INSERT INTO unit(name) VALUES ('Kg');
INSERT INTO unit(name) VALUES ('L');
INSERT INTO unit(name) VALUES ('Komad');

INSERT INTO location(name) VALUES('Novi Sad');
INSERT INTO location(name) VALUES('Beograd');
INSERT INTO location(name) VALUES('Niš');

--COMPANY
INSERT INTO company(name, pib, address, location_id) values ('Continental', '85479658', 'Radnicka 28', 1);
INSERT INTO company(name, pib, address, location_id) values ('Bosch', '12334123', 'Nemanjina 1', 2);

--GOROUP OF PRODUCTS
INSERT INTO group_of_products(name, company_id) VALUES('Hrana', 1);
INSERT INTO group_of_products(name, company_id) VALUES('Piće', 1);

INSERT INTO group_of_products(name, company_id) VALUES('Hrana', 2);
INSERT INTO group_of_products(name, company_id) VALUES('Piće', 2);

--PRODUCT
INSERT INTO product(name, group_of_products_id, unit_id) VALUES ('Brašno', 1, 1);
INSERT INTO product(name, group_of_products_id, unit_id) VALUES ('Kisela voda', 2, 2);

--AUTHORITY
INSERT INTO authority values (1, 'ADMINISTRATOR')
INSERT INTO authority values (2, 'EMPLOYEE')

--User1
INSERT INTO `warehouse`.`employee` (`employee_id`, `full_name`, `password`, `role`, `username`, `company_id`) VALUES (1, 'Nikola Nikolic', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 1, '1', 1);
INSERT INTO `warehouse`.`user_authority` (`id`, `authority_id`, `employee_employee_id`) VALUES (1, 1, 1);
--User2
INSERT INTO `warehouse`.`employee` (`employee_id`, `full_name`, `password`, `role`, `username`, `company_id`) VALUES (2, 'Marko Markovic', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 1, '2', 2);
INSERT INTO `warehouse`.`user_authority` (`id`, `authority_id`, `employee_employee_id`) VALUES (2, 1, 2);

--BUISNESS PARTNER
INSERT INTO business_partner(pib, address, name, company_id, location_id) VALUES ('123123', 'Jevrejska 32', 'Neki partner', 1, 1);
INSERT INTO business_partner(pib, address, name, company_id, location_id) VALUES ('231231', 'Partizanska 22', 'Neki partner dva', 2, 2);

--BUISNESS YEAR
INSERT INTO business_year(year, closed, company_id) VALUES (2018, true, 1);
INSERT INTO business_year(year, closed, company_id) VALUES (2019, true, 1);
INSERT INTO business_year(year, closed, company_id) VALUES (2021, false, 1);

INSERT INTO business_year(year, closed, company_id) VALUES (2021, false, 2);
INSERT INTO business_year(year, closed, company_id) VALUES (2020, true, 2);

--WAREHOUSE
INSERT INTO warehouse(name, company_id) VALUES ('Magacin 1', 1);
INSERT INTO warehouse(name, company_id) VALUES ('Magacin 2', 1);

INSERT INTO warehouse(name, company_id) VALUES ('Magacin 3', 2);
INSERT INTO warehouse(name, company_id) VALUES ('Magacin 4', 2);

--PRODUCT CARD
INSERT INTO `warehouse`.`product_card` (`product_card_id`, `inbound_traffic_quantity`, `inbound_traffic_value`, `initial_state_quantity`, `initial_state_value`, `outgoing_traffic_quantity`, `outgoing_traffic_value`, `price`, `total_amount`, `total_value`, `business_year_id`, `product_id`, `warehouse_id`) VALUES ('1', '2', '20', '0', '0', '0', '0', '10', '2', '20', '1', '1', '1');
INSERT INTO `warehouse`.`product_card` (`product_card_id`, `inbound_traffic_quantity`, `inbound_traffic_value`, `initial_state_quantity`, `initial_state_value`, `outgoing_traffic_quantity`, `outgoing_traffic_value`, `price`, `total_amount`, `total_value`, `business_year_id`, `product_id`, `warehouse_id`) VALUES ('2', '0', '0', '1', '15', '0', '0', '130000', '0', '130000', '2', '2', '1');
INSERT INTO `warehouse`.`product_card` (`product_card_id`, `inbound_traffic_quantity`, `inbound_traffic_value`, `initial_state_quantity`, `initial_state_value`, `outgoing_traffic_quantity`, `outgoing_traffic_value`, `price`, `total_amount`, `total_value`, `business_year_id`, `product_id`, `warehouse_id`) VALUES ('3', '0', '0', '1', '10', '0', '0', '100', '1', '100', '4', '1', '1');

--INVOICE
INSERT INTO `warehouse`.`invoice` (`invoice_id`, `date_of_formation`, `document_type`, `ordinal_invoice_number`, `posting_date`, `status`, `business_partner_id`, `business_year_id`, `warehouse_id`) VALUES ('1', '2018-05-08', 'Primka', '1', '2018-05-09', 'Formiranje', '1', '1', '1');

INSERT INTO `warehouse`.`invoice_line_item` (`invoice_line_item_id`, `price`, `quantity`, `value`, `invoice_id`, `product_id`) VALUES ('1', '10', '1', '10', '1', '1');

INSERT INTO `warehouse`.`warehouse_card_analytics` (`warehouse_card_analytics_id`, `ordinal_number`, `price`, `quantity`, `traffic_direction`, `traffic_type`, `value`, `invoice_line_item_id`, `product_card_id`) VALUES ('1', '1', '10', '1', 'IN', 'PR', '10', '1', '1');
