-- CREATE TABLE role (
-- 	role_id INTEGER NOT NULL AUTO_INCREMENT, 
-- 	name VARCHAR(255), 
-- 	PRIMARY KEY (role_id)
-- );

-- CREATE TABLE user (
-- 	username VARCHAR(15) NOT NULL, 
-- 	email VARCHAR(255) NOT NULL, 
-- 	name VARCHAR(255) NOT NULL, 
-- 	password VARCHAR(255) NOT NULL, 
-- 	PRIMARY KEY (username)
-- );

-- CREATE TABLE user_role (
-- 	role_id INTEGER NOT NULL, 
-- 	username VARCHAR(255) NOT NULL, 
-- 	PRIMARY KEY (username, role_id)
-- );

-- Create table userrole 

CREATE TABLE userrole (
role_id INTEGER NOT NULL, 
rolename VARCHAR(255), 
PRIMARY KEY (role_id)
);

CREATE TABLE users (
username VARCHAR(15) NOT NULL, 
email VARCHAR(255) NOT NULL, 
userpassword VARCHAR(255) NOT NULL, 
PRIMARY KEY (username)
);

CREATE TABLE user_role (
username VARCHAR(255) NOT NULL, 
role_id INTEGER NOT NULL, 
PRIMARY KEY (username, role_id)
);


ALTER TABLE user_role ADD CONSTRAINT fk_user_role_role_id FOREIGN KEY (role_id) REFERENCES userrole (role_id);
ALTER TABLE user_role ADD CONSTRAINT fk_user_role_username FOREIGN KEY (username) REFERENCES users (username);

INSERT INTO userrole VALUES (1,'ROLE_ADMIN');
INSERT INTO userrole VALUES (2,'ROLE_USER');
INSERT INTO users VALUES ('admin', 'admin@hien.com', '$2a$06$WfXHoFhYT/cXcyNOZQsjMuXRyydgcUTMJcMweF0m8RMub2HS1rCHu');
INSERT INTO user_role VALUES ('admin', 1);

--PostgreSQL syntax:  INSERT  INTO lists VALUES (id,'KO','SPH', '5')




-- Create table Role 





-- Create table User 



-- Create table user_role 



-- Alter table 



-- Insert into 



-- Co mau nghe si nhi - ngay nao no cung nghe bai na 