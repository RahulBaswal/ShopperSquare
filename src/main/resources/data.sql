/*add amin account*/

INSERT INTO roles (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO users (id, email, password, first_Name, last_Name) VALUES
(1, 'admin@gmail.com', '$2a$12$0SHNiDQuluDlpiz7k.ifYelQ22c/r7ZdSYhh8y7TZtqvwOBOXKse2', 'Admin', 'Rahul');

INSERT INTO user_role(user_id, role_id) VALUES
(1,1),
(1,2);

