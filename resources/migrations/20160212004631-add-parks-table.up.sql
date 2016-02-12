CREATE TABLE parks
(id bigserial PRIMARY KEY,
 name text NOT NULL,
 city text NOT NULL,
 latitude double precision NOT NULL,
 longitude double precision NOT NULL,
 floor_type_id integer NOT NULL REFERENCES floor_types(id),
 description text);
