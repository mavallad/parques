-- name: create-park<!
-- creates a new park record
INSERT INTO parks
(name, city, address, latitude, longitude, floor_type_id, description)
VALUES (:name, :city, :address, :latitude, :longitude, :floor_type_id, :description)

-- name: update-park!
-- update an existing park record
UPDATE parks
SET name = :name, city = :city, address = :address,
    latitude = :latitude, longitude = :longitude,
    floor_type_id = :floor_type_id, description = :description,
    modification_date = :modification_date
WHERE id = :id

-- name: get-parks
-- selects all available parks
SELECT * FROM parks

-- name: get-park
-- retrieve a park given the id.
SELECT * FROM parks
WHERE id = :id

-- name: delete-park!
-- delete a park given the id
DELETE FROM parks
WHERE id = :id
