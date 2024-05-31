-- create table roles
CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE
);

-- create table authorities
CREATE TABLE authorities
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE
);

-- create table users
CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    full_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    role_id    INTEGER,
    CONSTRAINT fk_users_role FOREIGN KEY (role_id) REFERENCES roles (id)
);

-- create table roles_authorities
CREATE TABLE roles_authorities
(
    role_id        INTEGER NOT NULL,
    authorities_id INTEGER NOT NULL,
    CONSTRAINT pk_roles_authorities PRIMARY KEY (role_id, authorities_id),
    CONSTRAINT fk_roles_authorities_role FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT fk_roles_authorities_authority FOREIGN KEY (authorities_id) REFERENCES authorities (id)
);

-- create table user_roles
CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES roles (id)
);

-- create table role_authorities
CREATE TABLE role_authorities
(
    role_id        INTEGER NOT NULL,
    authorities_id INTEGER NOT NULL,
    CONSTRAINT pk_role_authorities PRIMARY KEY (role_id, authorities_id),
    CONSTRAINT fk_role_authorities_role FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT fk_role_authorities_authority FOREIGN KEY (authorities_id) REFERENCES authorities (id)
);