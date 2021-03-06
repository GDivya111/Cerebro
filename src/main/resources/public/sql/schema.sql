-- Core Java Definitions
DROP TABLE IF EXISTS CORE_JAVA_DEFINITION;

CREATE TABLE CORE_JAVA_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS CORE_JAVA_SEQUENCE;

CREATE SEQUENCE CORE_JAVA_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Apache Kafka definitions
DROP TABLE IF EXISTS APACHE_KAFKA_DEFINITION;

CREATE TABLE APACHE_KAFKA_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS APACHE_KAFKA_SEQUENCE;

CREATE SEQUENCE APACHE_KAFKA_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Groovy Definitions
DROP TABLE IF EXISTS GROOVY_DEFINITION;

CREATE TABLE GROOVY_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS GROOVY_SEQUENCE;

CREATE SEQUENCE GROOVY_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Maven Definitions
DROP TABLE IF EXISTS MAVEN_DEFINITION;

CREATE TABLE MAVEN_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS MAVEN_SEQUENCE;

CREATE SEQUENCE MAVEN_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Jenkins Definitions
DROP TABLE IF EXISTS JENKINS_DEFINITION;

CREATE TABLE JENKINS_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS JENKINS_SEQUENCE;

CREATE SEQUENCE JENKINS_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- MongoDB Definitions
DROP TABLE IF EXISTS MONGODB_DEFINITION;

CREATE TABLE MONGODB_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS MONGODB_SEQUENCE;

CREATE SEQUENCE MONGODB_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Docker Definitions
DROP TABLE IF EXISTS DOCKER_DEFINITION;

CREATE TABLE DOCKER_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS DOCKER_SEQUENCE;

CREATE SEQUENCE DOCKER_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Mockito Definitions
DROP TABLE IF EXISTS MOCKITO_DEFINITION;

CREATE TABLE MOCKITO_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS MOCKITO_SEQUENCE;

CREATE SEQUENCE MOCKITO_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Scala Definitions
DROP TABLE IF EXISTS SCALA_DEFINITION;

CREATE TABLE SCALA_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS SCALA_SEQUENCE;

CREATE SEQUENCE SCALA_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Multithreading Definitions
DROP TABLE IF EXISTS CONCURRENCY_DEFINITION;

CREATE TABLE CONCURRENCY_DEFINITION
(
 ID NUMBER PRIMARY KEY, 
 DESCRIPTION VARCHAR(5000),
 DETAILS VARCHAR(10000),
 IMAGE_PATHS VARCHAR(10000)
);

DROP SEQUENCE IF EXISTS CONCURRENCY_SEQUENCE;

CREATE SEQUENCE CONCURRENCY_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;