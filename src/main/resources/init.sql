
CREATE DATABASE db1 CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE db2 CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE db1.`t_student` (
                             `id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
                             `name` VARCHAR ( 255 ) DEFAULT NULL,
                             `age` INT ( 11 ) DEFAULT NULL,
                             `classname` VARCHAR ( 255 ) DEFAULT NULL,
                             PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;


CREATE TABLE db1.`t_student_english` (
                                         `id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
                                         `name` VARCHAR ( 255 ) DEFAULT NULL,
                                         `age` INT ( 11 ) DEFAULT NULL,
                                         `classname` VARCHAR ( 255 ) DEFAULT NULL,
                                         PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;



CREATE TABLE db2.`t_teacher` (
                             `id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
                             `name` VARCHAR ( 255 ) DEFAULT NULL,
                             `age` INT ( 11 ) DEFAULT NULL,
                             `subject` VARCHAR ( 255 ) DEFAULT NULL,
                             PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;


CREATE TABLE db2.`t_teacher_english` (
                                         `id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
                                         `name` VARCHAR ( 255 ) DEFAULT NULL,
                                         `age` INT ( 11 ) DEFAULT NULL,
                                         `subject` VARCHAR ( 255 ) DEFAULT NULL,
                                         PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;