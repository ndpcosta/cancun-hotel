CREATE TABLE tb_customer (
    id int PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE tb_room (
    id int PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE tb_booking (
    id int PRIMARY KEY,
    customer_id INT NOT NULL,
    room_id INT NOT NULL,
    checkin_date DATE NOT NULL,

    FOREIGN KEY (customer_id) REFERENCES tb_customer (id),
    FOREIGN KEY (room_id) REFERENCES tb_room (id)
);