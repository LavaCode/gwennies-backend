INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_MODERATOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

-- Create default admin
INSERT INTO app_user(id, country, email, firstname, lastname, password, streetname, username, zipcode) VALUES
(999, 'adminland', 'admin@admin.com', 'admin', 'de baas', '$2y$12$Z9aYkDN6v98IWJWQvlIYSOMbW5p4jdkRK9vdh8OybpF7FpQzgFi9K', 'adminstreet 123A','admin', '1234AB');

-- Link defualt admin to role level [Role level 3 = ADMIN]
INSERT INTO user_role(user_id, role_id) VALUES
(999, 3);

-- Create default products [Start at ID 9001]
INSERT INTO product(long_description, name, price, quantity, short_description) VALUES 
('This is a cool mombag', 'BAG_01', 29.99, 2, 'handmade mombag');

-- Upload default images [to be made/tested]