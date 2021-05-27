INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_MODERATOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

-- Aanmaken van default users
INSERT INTO app_user(id, email, username, password) VALUES
(999, 'admin@admin.com', 'admin', '$2y$12$Z9aYkDN6v98IWJWQvlIYSOMbW5p4jdkRK9vdh8OybpF7FpQzgFi9K');

-- Hier maak koppel je de user in de database (role_id: 3 = admin level)
INSERT INTO user_role(user_id, role_id) VALUES
(999, 3);