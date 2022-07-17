CREATE TABLE tb_guest (
    id int PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE tb_room (
    id int PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE tb_booking (
    id int PRIMARY KEY,
    guest_id INT NOT NULL,
    room_id INT NOT NULL,
    checkin_date DATE NOT NULL,
    checkout_date DATE NOT NULL,
    status VARCHAR(30) NOT NULL,

    FOREIGN KEY (guest_id) REFERENCES tb_guest (id),
    FOREIGN KEY (room_id) REFERENCES tb_room (id)
);