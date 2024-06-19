INSERT INTO
    room_type(description, image_path, type)
VALUES
    ('Regular Room with balcony', '/images/rooms/regular.jpg', 'Regular Room'),
    ('Deluxe room with an astonishing view and a big balcony', '/images/rooms/deluxe.jpg', 'Deluxe Room');

INSERT INTO
    rooms(beds, price, room_type_id)
VALUES
    (2,100,1),
    (2,100,1),
    (4,200,1),
    (3,150,1),
    (4,200,1),
    (2,200,2),
    (2,200,2),
    (2,200,2),
    (3,300,2),
    (4,400,2);

INSERT INTO
    extra_type(description, title)
VALUES
    ('Free wifi for unlimited use.','wifi'),
    ('Smart TV with internet access', 'tv'),
    ('AC','ac');

INSERT INTO
    room_extras(room_id, extra_type_id)
VALUES
    (1, 1), -- Room 1 has Wifi
    (1, 2), -- Room 1 has TV
    (2, 1), -- Room 2 has Wifi
    (2, 3), -- Room 2 has Minibar
    (3, 2), -- Room 3 has TV
    (3, 3), -- Room 3 has Minibar
    (4, 1), -- Room 4 has Wifi
    (4, 2), -- Room 4 has TV
    (5, 1), -- Room 5 has Wifi
    (5, 2), -- Room 5 has TV
    (5, 3), -- Room 5 has Minibar
    (6, 2), -- Room 6 has TV
    (6, 3), -- Room 6 has Minibar
    (7, 1), -- Room 7 has Wifi
    (8, 2), -- Room 8 has TV
    (9, 1), -- Room 9 has Wifi
    (9, 3), -- Room 9 has Minibar
    (10, 2), -- Room 10 has TV
    (10, 3); -- Room 10 has Minibar



