DROP TABLE user_role;
DROP TABLE role;
DROP TABLE password_reset_token;
DROP TABLE user_data;
DROP TABLE plan;


--
-- Table structure for table plan
--
CREATE TABLE plan (
  id number(4) NOT NULL,
  name char(30) NOT NULL,
  PRIMARY KEY (id)
) ;

commit;

--
-- Table structure for table publisher
--
CREATE TABLE User_Data (
  id number(10) NOT NULL ,
  username varchar(50) NOT NULL,
  password varchar(60) NOT NULL,
  enabled number(1) NOT NULL,
  email varchar(256) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  phone_number varchar(50) DEFAULT NULL,
  country varchar(2) DEFAULT NULL,
  description VARCHAR(500),
  profile_image_url VARCHAR(500),
  plan_id number(4)  DEFAULT 1 NOT NULL,
  stripe_customer_id VARCHAR(100),
  created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  updated_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  PRIMARY KEY (id),
  CONSTRAINT  users_ix_email  UNIQUE  (email),
  CONSTRAINT users_ix_username UNIQUE  (username),
  CONSTRAINT fk_plan_users FOREIGN KEY (plan_id) REFERENCES plan (id)
)

  COMMIT;
--
-- Table structure for table role
--
CREATE TABLE role (
  id number(10) NOT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

COMMIT;


--
-- Table structure for table user_role
--
CREATE TABLE user_role (
  id number(10)  NOT NULL ,
  user_id number(10)  NOT NULL,
  role_id number(10)  NOT NULL,
  PRIMARY KEY (id),

  CONSTRAINT fk_userrole_user_idx
  FOREIGN KEY (role_id)
  REFERENCES user_data (id),
  CONSTRAINT fk_userrole_role_idx
  FOREIGN KEY (role_id)
  REFERENCES role (id)


) ;

CREATE SEQUENCE userrole_seq START WITH 1;

CREATE OR REPLACE TRIGGER userrole_tr
BEFORE INSERT ON user_role
FOR EACH ROW

  BEGIN
    SELECT userrole_seq.NEXTVAL
    INTO   :new.id
    FROM   dual;
  END;

COMMIT;

--
-- Table structure for table password_reset_token
--
CREATE TABLE password_reset_token (
  id number(10)  NOT NULL ,
  token varchar(255) NOT NULL,
  user_id number(10)  NOT NULL,
  expiry_date TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT token_ix_token UNIQUE (token),
  CONSTRAINT fk_token_user FOREIGN KEY (user_id) REFERENCES user (id)
)

CREATE SEQUENCE password_reset_token_seq START WITH 1;

CREATE OR REPLACE TRIGGER password_reset_token_tr
BEFORE INSERT ON password_reset_token
FOR EACH ROW

  BEGIN
    SELECT password_reset_token_seq.NEXTVAL
    INTO   :new.id
    FROM   dual;
  END;

COMMIT;


COMMIT;


INSERT into plan VALUES ('1', 'Basic');
INSERT into plan VALUES ('2', 'Pro');

INSERT into role VALUES (1, 'ROLE_BASIC');
INSERT into role VALUES (2, 'ROLE_PRO');
INSERT into role VALUES (3, 'ROLE_ADMIN');

COMMIT;