CREATE DATABASE IF NOT EXISTS COMP3095;
USE COMP3095;
grant all on COMP3095.* to 'admin'@'localhost' identified by 'admin'; 

CREATE TABLE USERS 
( 
	id int(11) AUTO_INCREMENT PRIMARY KEY, 
	firstname varchar(255),
	lastname varchar(255),
	email varchar(255), 
	phone varchar(15),
	year varchar(10),
	major varchar(15),
	username varchar(20),
	password varchar(20)
);


CREATE TABLE POSTS 
( 
	post_id int(11) AUTO_INCREMENT NOT NULL, 
	user varchar(255),
	post_time DATETIME DEFAULT NOW(),
    post_text TEXT,
	PRIMARY KEY (post_id)
);

CREATE TABLE COMMENTS
( 
	comment_id int(11) AUTO_INCREMENT NOT NULL, 
	user varchar(255),
	comment_time DATETIME DEFAULT NOW(),
    comment_text TEXT,
	post_id int(11) NOT NULL,
	PRIMARY KEY (comment_id), 
 	FOREIGN KEY (post_id) REFERENCES POSTS (post_id)
);


INSERT INTO `USERS` (`id`, `firstname`, `lastname`, `email`, `phone`, `year`, `major`, `username`, `password`) VALUES
(99, NULL, NULL, `admin@domain.ca`, NULL, NULL, NULL, `admin`, `admin`);
