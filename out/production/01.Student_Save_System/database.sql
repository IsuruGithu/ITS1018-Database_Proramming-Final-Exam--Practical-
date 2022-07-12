CREATE DATABASE IF NOT EXISTS ijse;
USE ijse;

//Student------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Student`(
    student_id VARCHAR(45) NOT NULL,
    student_name VARCHAR(45) NOT NULL DEFAULT 'Unknown',
    email TEXT NOT NULL DEFAULT 'No-email',
    contact VARCHAR(20) NOT NULL DEFAULT 'No-contact',
    address TEXT,
    nic VARCHAR(45),
    CONSTRAINT PRIMARY KEY (student_id));

SHOW TABLES;
DESC `Student`;

//Registration-------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Registration`(
    registration_id VARCHAR(45) NOT NULL,
    reg_date DATE,
    student_id VARCHAR(45),
    intake_id VARCHAR(45),
    CONSTRAINT PRIMARY KEY (registration_id),
    CONSTRAINT FOREIGN KEY(student_id) REFERENCES Student(student_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY(intake_id) REFERENCES Intake(intake_id) ON DELETE CASCADE ON UPDATE CASCADE);

SHOW TABLES;
DESC `Registration`;

//Course--------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Course`(
    course_id VARCHAR(45) NOT NULL,
    course_name VARCHAR(45),
    cost DOUBLE,
    duration VARCHAR(45),
    subject_id VARCHAR(45),
    CONSTRAINT PRIMARY KEY (course_id),
    CONSTRAINT FOREIGN KEY(subject_id) REFERENCES Subject(subject_id) ON DELETE CASCADE ON UPDATE CASCADE);

SHOW TABLES;
DESC `Course`;

//Payment--------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Payment`(
    payment_id VARCHAR(45) NOT NULL,
    date DATE,
    cost DOUBLE,
    registration_id VARCHAR(45),
    CONSTRAINT PRIMARY KEY (payment_id),
    CONSTRAINT FOREIGN KEY(registration_id) REFERENCES Registration(registration_id) ON DELETE CASCADE ON UPDATE CASCADE);

SHOW TABLES;
DESC `Payment`;

//Teacher--------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Teacher`(

    teacher_id VARCHAR(45),
    name VARCHAR(45) NOT NULL,
    nic VARCHAR(45) NOT NULL,
    contact VARCHAR(45) NOT NULL,
    address TEXT NOT NULL,
    CONSTRAINT PRIMARY KEY(teacher_id)
    );

SHOW TABLES;
DESC `Teacher`;

//Subject---------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Subject`(

    subject_id VARCHAR(45),
    subject_name VARCHAR(45) NOT NULL,
    credit DOUBLE,
    teacher_id VARCHAR(45) NOT NULL,
    CONSTRAINT PRIMARY KEY (subject_id),
    CONSTRAINT FOREIGN KEY(teacher_id) REFERENCES Teacher(teacher_id) ON DELETE CASCADE ON UPDATE CASCADE);

SHOW TABLES;
DESC `Subject`;

//Intake-----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intake`(

    intake_id VARCHAR(45),
    start_date DATE NOT NULL,
    intakecol VARCHAR(45),
    description VARCHAR(45),
    course_id VARCHAR(45),
    CONSTRAINT PRIMARY KEY(intake_id),
    CONSTRAINT FOREIGN KEY(course_id) REFERENCES Course(course_id) ON DELETE CASCADE ON UPDATE CASCADE);

SHOW TABLES;
DESC `Intake`;