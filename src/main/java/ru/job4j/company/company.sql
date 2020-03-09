

CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);
есть две таблицы )
нужно
// 1) Retrieve in a single query:
// - names of all persons that are NOT in the company with id = 5
// - company name for each person
// 2) Select the name of the company with the maximum number of persons + number of persons in this company

1)  SELECT p.name, c.name AS company_name FROM person AS p LEFT JOIN company AS c ON p.company_id = c.id WHERE c.id NOT IN(5);

2)  SELECT c.name AS company_name_with_max_numbers_of_persons, count(*) AS number_person from company AS c
        LEFT JOIN person AS p ON p.company_id = c.id
            GROUP BY c.id, c.name
                ORDER BY c.id DESC
                    LIMIT 1;