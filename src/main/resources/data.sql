INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_MODERATOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

INSERT INTO app_user(email, username, password) VALUES
('admin@admin.com','admin', '$2y$12$Z9aYkDN6v98IWJWQvlIYSOMbW5p4jdkRK9vdh8OybpF7FpQzgFi9K');

INSERT INTO user_role(user_id, role_id) VALUES
(1, 3);