
INSERT INTO users1 (id , name , lastname, login, password)  VALUES (1, 'ivan', 'ivanov', 'ivanushka', '$2a$04$jSO6ibDUkdofTqx1nEfe6uaVqb2Ks3M0UwtlfZOX.VDc45UumELqK');
INSERT INTO users1 (id , name , lastname, login, password) VALUES (2, 'stas', 'stasov', 'stasic', '$2a$04$jSO6ibDUkdofTqx1nEfe6uaVqb2Ks3M0UwtlfZOX.VDc45UumELqK');


INSERT INTO roles1 VALUES (1, 'USER');
INSERT INTO roles1 VALUES (2, 'ADMIN');

INSERT INTO users_roles1 VALUES (1, 1);
INSERT INTO users_roles1 VALUES (2, 2);
