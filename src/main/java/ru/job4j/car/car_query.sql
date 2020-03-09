1. SELECT c.name, cc.name, e.name, t.name FROM car AS c 
		INNER JOIN carcass AS cc ON c.carcass_id = cc.id 
		INNER JOIN engine AS e ON c.engine_id = e.id 
		INNER JOIN transmission AS t ON c.transmission_id = t.id;

--Вывод всех кузовов которые не используются машинами
2.	SELECT cc.id, cc.name FROM car AS c RIGHT OUTER JOIN carcass AS cc ON c.carcass_id = cc.id WHERE c.id is null;

--Вывод всех двигателей которые не используются машинами
3. SELECT e.id, e.name FROM car AS c RIGHT OUTER JOIN engine AS e ON c.engine_id = e.id WHERE c.id is null;

--Выыод всех коробок передач которые не используют машины
4. SELECT t.id, t.name FROM car AS c RIGHT OUTER JOIN transmission AS t ON c.transmission_id = t.id WHERE c.id is null; 	