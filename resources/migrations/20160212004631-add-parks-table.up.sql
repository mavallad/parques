CREATE TABLE parks
(id bigserial PRIMARY KEY,
 name text NOT NULL,
 city text NOT NULL,
 address text,
 latitude double precision NOT NULL,
 longitude double precision NOT NULL,
 floor_type_id integer NOT NULL REFERENCES floor_types(id),
 description text,
 is_active boolean DEFAULT true,
 creation_date timestamp DEFAULT current_timestamp,
 modification_date timestamp DEFAULT current_timestamp);
