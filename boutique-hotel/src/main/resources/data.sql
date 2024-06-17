INSERT INTO
    room_type(description, image_path, type)
VALUES
    ('Regular Room for the regular price', 'images/rooms/regular.jpg', 'Regular Room'),
    ('Deluxe room with an astonishing view', 'images/rooms/deluxe.jpg', 'Deluxe Room');

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
    ('Wifi', 'Free wifi for unlimited use.'),
    ('TV', 'Smart TV with internet access'),
    ('Minibar', 'Minibar with cold alcoholic and non-alcoholic drinks');


