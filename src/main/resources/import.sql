INSERT INTO unit(name) VALUES ('Kg');

INSERT INTO location(name) VALUES('Novi Sad');

INSERT INTO company(name, pib, address, location_id) values ('Continental', '85479658', 'Radnicka 28', 1);

INSERT INTO groupOfProducts(name, company_id) VALUES('Hrana', 1);

INSERT INTO product(name, groupOfProducts_id, unit_id) VALUES ('Brasno', 1, 1);