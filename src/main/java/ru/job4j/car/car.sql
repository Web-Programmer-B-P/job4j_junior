CREATE DATABASE car;

\connect car;

CREATE TABLE carcass (
	id serial PRIMARY KEY,
	name varchar(500)
);

CREATE TABLE engine (
	id serial PRIMARY KEY,
	name varchar(500),
	description varchar(500)
);

CREATE TABLE transmission (
	id serial PRIMARY KEY,
	name varchar(500),
	description varchar(500)
);

INSERT INTO carcass (name) VALUES ('Седан'), ('Хэтчбек'), ('Уневирсал');
INSERT INTO engine (name, description) VALUES ('Дизель', 'Дизельный двигатель'), ('Бензиновый', 'Бензиновый двигатель'), ('Электро', 'Электро-двигатель');
INSERT INTO transmission (name, description) VALUES ('Механика', 'Коробка передач механического переключения скоростей'), ('Полуавтомат', 'полуавтоматическая коробка'), ('Автомат', 'автоматическая коробка');

CREATE TABLE car (
	id serial PRIMARY KEY,
	name varchar(500) NOT NULL,
	carcass_id int REFERENCES carcass (id) NOT NULL DEFAULT 1,
	engine_id int REFERENCES engine (id)NOT NULL DEFAULT 1,
	transmission_id int REFERENCES transmission (id) NOT NULL DEFAULT 1
);

INSERT INTO car (name, carcass_id, engine_id, transmission_id) VALUES ('Москвич', 2, 2, 1), ('Ваз2110', 3, 2, 1), ('Таврия', 2, 2, 1);



