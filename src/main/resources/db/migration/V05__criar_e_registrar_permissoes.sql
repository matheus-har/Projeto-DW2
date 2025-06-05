CREATE TABLE permissions (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE users_permissions (
	id_users BIGINT(20) NOT NULL,
	id_permissions BIGINT(20) NOT NULL,
	PRIMARY KEY (id_users, id_permissions),
	FOREIGN KEY (id_users) REFERENCES users(id),
	FOREIGN KEY (id_permissions) REFERENCES permissions(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (id,name, email, password, birth_date, gender, telephone, active) 
	values (5'Administrador', 'admin@ifsp.edu.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', '2000-01-01', 'MASCULINO', '12911110000', 1);
	
INSERT INTO permission (id, description) values (1, 'ROLE_REGISTER_USER');
INSERT INTO permission (id, description) values (2, 'ROLE_REMOVE_USER');
INSERT INTO permission (id, description) values (3, 'ROLE_SEARCH_USER');

INSERT INTO permission (id, description) values (4, 'ROLE_REGISTER_PRODUCT');
INSERT INTO permission (id, description) values (5, 'ROLE_REMOVE_PRODUCT');
INSERT INTO permission (id, description) values (6, 'ROLE_SEARCH_PRODUCT');

INSERT INTO permission (id, description) values (7, 'ROLE_REGISTER_COMPANY');
INSERT INTO permission (id, description) values (8, 'ROLE_REMOVE_COMPANIY');
INSERT INTO permission (id, description) values (9, 'ROLE_SEARCH_COMPANIY');

INSERT INTO permission (id, description) values (10, 'ROLE_REGISTER_DONATION');
INSERT INTO permission (id, description) values (11, 'ROLE_REMOVE_DONATION');
INSERT INTO permission (id, description) values (12, 'ROLE_SEARCH_DONATION');


-- admin
INSERT INTO user_permission (id_user, id_permission) values (5, 1);
INSERT INTO user_permission (id_user, id_permission) values (5, 2);
INSERT INTO user_permission (id_user, id_permission) values (5, 3);
INSERT INTO user_permission (id_user, id_permission) values (5, 4);
INSERT INTO user_permission (id_user, id_permission) values (5, 5);
INSERT INTO user_permission (id_user, id_permission) values (5, 6);
INSERT INTO user_permission (id_user, id_permission) values (5, 7);
INSERT INTO user_permission (id_user, id_permission) values (5, 8);
INSERT INTO user_permission (id_user, id_permission) values (5, 9);
INSERT INTO user_permission (id_user, id_permission) values (5, 10);
INSERT INTO user_permission (id_user, id_permission) values (5, 11);
INSERT INTO user_permission (id_user, id_permission) values (5, 12);


INSERT INTO user_permission (id_user, id_permission) values (1, 1);
INSERT INTO user_permission (id_user, id_permission) values (1, 3);
INSERT INTO user_permission (id_user, id_permission) values (1, 4);
INSERT INTO user_permission (id_user, id_permission) values (1, 6);
INSERT INTO user_permission (id_user, id_permission) values (1, 7);
INSERT INTO user_permission (id_user, id_permission) values (1, 9);
INSERT INTO user_permission (id_user, id_permission) values (1, 10);
INSERT INTO user_permission (id_user, id_permission) values (1, 12);

INSERT INTO user_permission (id_user, id_permission) values (2, 1);
INSERT INTO user_permission (id_user, id_permission) values (2, 3);
INSERT INTO user_permission (id_user, id_permission) values (2, 4);
INSERT INTO user_permission (id_user, id_permission) values (2, 6);
INSERT INTO user_permission (id_user, id_permission) values (2, 7);
INSERT INTO user_permission (id_user, id_permission) values (2, 9);
INSERT INTO user_permission (id_user, id_permission) values (2, 10);
INSERT INTO user_permission (id_user, id_permission) values (2, 12);

INSERT INTO user_permission (id_user, id_permission) values (3, 1);
INSERT INTO user_permission (id_user, id_permission) values (3, 3);
INSERT INTO user_permission (id_user, id_permission) values (3, 4);
INSERT INTO user_permission (id_user, id_permission) values (3, 6);
INSERT INTO user_permission (id_user, id_permission) values (3, 7);
INSERT INTO user_permission (id_user, id_permission) values (3, 9);
INSERT INTO user_permission (id_user, id_permission) values (3, 10);
INSERT INTO user_permission (id_user, id_permission) values (3, 12);

INSERT INTO user_permission (id_user, id_permission) values (4, 1);
INSERT INTO user_permission (id_user, id_permission) values (4, 3);
INSERT INTO user_permission (id_user, id_permission) values (4, 4);
INSERT INTO user_permission (id_user, id_permission) values (4, 6);
INSERT INTO user_permission (id_user, id_permission) values (4, 7);
INSERT INTO user_permission (id_user, id_permission) values (4, 9);
INSERT INTO user_permission (id_user, id_permission) values (4, 10);
INSERT INTO user_permission (id_user, id_permission) values (4, 12);





