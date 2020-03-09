

В системе заданы таблицы 

product(id, name, type_id, expired_date, price)

type(id, name)

Задание.

1. Написать запрос получение всех продуктов с типом "СЫР"

2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"

3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.

4. Написать запрос, который выводит самый дорогой продукт.

5. Написать запрос, который выводит количество всех продуктов определенного типа.

6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  

8. Вывести все продукты и их тип.
====================================================================================================================

1. SELECT p.name, p.price FROM product AS p LEFT JOIN type AS t ON p.type_id = t.id WHERE t.name = 'СЫР';

2. SELECT * FROM product WHERE name LIKE '%мороженное%';

3. SELECT * FROM product WHERE expired_date BETWEEN TO_CHAR(current_date + interval '1 month', 'yyyy-mm-01')::date
                                                AND TO_CHAR(current_date + interval '2 month', 'yyyy-mm-01')::date;

4. SELECT * FROM product ORDER BY price DESC LIMIT 1;

5. SELECT count(p.type_id) from product AS p LEFT JOIN type t ON p.type_id = t.id WHERE t.name = 'СЫР';

6. SELECT p.name, p.price, p.expired_date from product AS p LEFT JOIN type t ON p.type_id = t.id WHERE t.name IN ('СЫР', 'МОЛОКО');

7. SELECT t.name, count(*) total from product AS p LEFT JOIN type t ON p.type_id = t.id GROUP BY t.name HAVING count(t.id) < 10;

8. SELECT p.name, p.expired_date, p.price, t.name as type_name from product AS p LEFT JOIN type t ON p.type_id = t.id;