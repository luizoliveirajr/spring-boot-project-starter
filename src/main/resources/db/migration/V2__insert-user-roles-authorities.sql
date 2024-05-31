-- Add roles
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

-- Add authorities
INSERT INTO authorities (name) VALUES ('READ');
INSERT INTO authorities (name) VALUES ('WRITE');

-- Add users
INSERT INTO users (full_name, email, password, role_id) VALUES ('admin', 'admin@hotmail.com', '$2a$10$QuyOfu0HAKViWtMlOkpFNembnAxfky.yBPTyoBdpZv6P8XAemaGp2',1);

-- Assign roles to users
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- Assign ROLE_ADMIN to admin user

-- Assign authorities to roles
INSERT INTO role_authorities (role_id, authorities_id) VALUES (1, 1); -- Assign READ authority to ROLE_ADMIN
INSERT INTO role_authorities (role_id, authorities_id) VALUES (1, 2); -- Assign WRITE authority to ROLE_ADMIN

