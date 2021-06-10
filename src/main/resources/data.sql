INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_MODERATOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

-- Create default admin [start ID at 901]
INSERT INTO app_user(id, email, username, password) VALUES
(901, 'admin@admin.com', 'admin', '$2y$12$Z9aYkDN6v98IWJWQvlIYSOMbW5p4jdkRK9vdh8OybpF7FpQzgFi9K');

-- Link defualt admin to role level [Role level 3 = ADMIN]
INSERT INTO user_role(user_id, role_id) VALUES
(901, 3);

-- Create default products [Start at ID 9001]
INSERT INTO product(id, long_description, name, price, quantity, short_description) VALUES 
(9001, 'This is a cool mombag', 'BAG_01', 29.99, 2, 'handmade mombag');

-- Upload default images [to be made/tested]