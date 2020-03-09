create database items;
\connect items;

	 create table users (
	 	id serial PRIMARY KEY,
	 	name varchar(200),
	 	surname varchar(200),
	 	item_id int
	 	);

	 create table item (
	 	id serial PRIMARY KEY,
	 	name varchar(1000),
	 	descriptions varchar(2000),
	 	comments_id int,
	 	attachs_id int
	 	);

	 create table comments (
	 	id serial PRIMARY KEY,
	 	descriptions varchar(2000)
	 	);

	 create table attachs (
	 	id serial PRIMARY KEY,
	 	name varchar(200)
	 	);

	 create table state (
	 	id serial PRIMARY KEY,
	 	status boolean,
	 	item_id int
	 	);

	 create table category (
	 	id serial PRIMARY KEY,
	 	descriptions text,
	 	item_id int
	 	);

	 create table role (
	 	id serial PRIMARY KEY,
	 	name varchar(200),
	 	users_id int
	 	);

	 create table rules (
	 	id serial PRIMARY KEY,
	 	rule varchar(2000)
	 	);

	 create table role_rules (
	 	id serial PRIMARY KEY,
	 	role_id int,
	 	rules_id int
	 	);

	 ALTER TABLE users ADD CONSTRAINT users_constrain FOREIGN KEY (item_id) REFERENCES item (id);
	 ALTER TABLE item ADD CONSTRAINT item_comment_constrain FOREIGN KEY (comments_id) REFERENCES comments (id);
	 ALTER TABLE item ADD CONSTRAINT item_attachs_constrain FOREIGN KEY (attachs_id) REFERENCES attachs (id);
	 ALTER TABLE state ADD CONSTRAINT item_constrain FOREIGN KEY (item_id) REFERENCES item (id);
	 ALTER TABLE category ADD CONSTRAINT item_constrain FOREIGN KEY (item_id) REFERENCES item (id);
	 ALTER TABLE role ADD CONSTRAINT users_id_constrain FOREIGN KEY (users_id) REFERENCES users (id);
	 ALTER TABLE role_rules ADD CONSTRAINT role_id_constrain FOREIGN KEY (role_id) REFERENCES role (id);
	 ALTER TABLE role_rules ADD CONSTRAINT rules_id_constrain FOREIGN KEY (rules_id) REFERENCES rules (id);

	 INSERT INTO comments (descriptions) VALUES ('Это фейковый комментарий 1'), ('Проверка связи 2'), ('Инициализация 3'), ('Загон данных 4');
	 INSERT INTO attachs (name) VALUES ('Файл 1'), ('Новый файл 2'), ('Еще файлик 3'), ('Аудио файл 4');
	 INSERT INTO item (name, descriptions, comments_id, attachs_id) VALUES
	 													 ('Пробная заявка 1', 'Заявка на успешное выполнение запроса', 1, 3), ('Заявка на комп', 'Собрать новый комп на базе core i9', 4, 1), ('Всего по немногу', 'нужно уточнить', 2, 2);
	INSERT INTO users (name, surname, item_id) VALUES ('Владислав', 'Черномырдин', 1), ('Никола', 'Дружинников', 2);
	INSERT INTO state (status, item_id) VALUES (true, 3), (false, 1);
	INSERT INTO category (descriptions, item_id) VALUES ('Категория заявки', 2), ('Новая категория рыба для заявки', 1);
	INSERT INTO role (name, users_id) VALUES ('Администратор', 1), ('Гость', 2);
	INSERT INTO rules (rule) VALUES ('Незнаю что здесь должно быть'), ('Для кого или чего эти правила');
	INSERT INTO role_rules (role_id, rules_id) VALUES (1, 2), (2, 1);
