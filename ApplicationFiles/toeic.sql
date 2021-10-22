-- Tao bang role
CREATE TABLE role
(
   roleid bigint(20) PRIMARY KEY,
   name nvarchar(100)
);
INSERT INTO  role values (1, 'admin');
INSERT INTO  role values (2, 'user');

-- Tao bang user
CREATE TABLE user
(
    userid bigint(20) PRIMARY KEY AUTO_INCREMENT,
    username varchar(20),
    name nvarchar(100),
    email varchar(100),
    roleid bigint(20),
    FOREIGN KEY (roleid) REFERENCES role(roleid)
);
INSERT INTO user values(1, 'admin', 'Ho Van Hieu', '18110282@student.hcmute.edu.vn',1 );