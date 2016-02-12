CREATE TABLE floor_types
(id serial PRIMARY KEY,
 name VARCHAR(40),
 description text);

INSERT INTO floor_types
 (name, description)
VALUES
 ('goma', 'Goma'),
 ('arena', 'Arena'),
 ('grava', 'Grava'),
 ('caucho', 'Caucho'),
 ('madera', 'Madera');
