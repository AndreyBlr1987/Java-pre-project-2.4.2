
INSERT INTO users VALUES (1, 'Vanya', 'ivanov', 'ivan', '$2a$04$jSO6ibDUkdofTqx1nEfe6uaVqb2Ks3M0UwtlfZOX.VDc45UumELqK');
INSERT INTO users VALUES (2, 'Stas', 'Stasov', 'Stas', '$2a$04$jSO6ibDUkdofTqx1nEfe6uaVqb2Ks3M0UwtlfZOX.VDc45UumELqK');


INSERT INTO roles VALUES (1, 'USER');
INSERT INTO roles VALUES (2, 'ADMIN');

INSERT INTO users_roles VALUES (1, 1);
INSERT INTO users_roles VALUES (2, 2);
