drop database websiteTOEIC;

create database websiteTOEIC;

use websiteTOEIC;

-- Tao bang phan quyen
CREATE TABLE Role
(
	roleID INT (11) AUTO_INCREMENT,
    rolename NVARCHAR(500),
    
    PRIMARY KEY(roleID)
);

-- Tao bang nguoi dung
Create table User
(
	userID int(11) auto_increment,
    username varchar(100) not null,
    password varchar(20) not null,
    fullname nvarchar(200),
    email varchar(200),
    roleID int(11),
    
    primary key (userID),
    foreign key (roleID) references Role(roleID) on delete cascade
);

-- Tao bang chu de tu vung TOPICWORDS (topicwordID, topicname, topicwordimage)
Create table Topicwords
(
	topicwordID int(11) auto_increment,
    topicname varchar(300),
    topicwordimage varchar(45),
    
    primary key (topicwordID)
);

-- Tao bang tu vung VOCABULARY (wordID, num, content, main, wordimage, pronounce, spelling, example, typeword, topicwordID)
Create table Words
(
	wordID int(11),
	num int(11),
	content varchar(300),
	translate nvarchar(300),
	wordimage varchar(45),
    pronounce varchar(45),
	typeword int(11),
	topicwordID int(11),
        
	primary key(wordID),
	foreign key(topicwordID) references Topicwords(topicwordID) on delete cascade
);

-- Tao bang de nguoi dung them tu vung vao danh muc ua thich 	Myword (userID, wordID)
Create table Mywords
(
	userID int(11),
    wordID int(11),
    
    primary key(userID, wordID),
    foreign key(userID) references User(userID) on delete cascade,
    foreign key(wordID) references Words(wordID) on delete cascade
);

-- Tao bang chu de ngu phap TOPICGRAMMAR (topicgrammarID, grammarname,grammarimage)
Create table Topicgrammar
(
	topicgrammarID int(11) auto_increment, 
    grammarname nvarchar(300),
    grammarimage varchar(45),
    
    primary key(topicgrammarID)
);

-- Tao bang noi dung cua tung chu de ngu phap CONTENTSGRAMMAR (grammarID, sectiongrammar, contents, example, topicgrammarID)
Create table Contentsgrammar
(
	grammarID int(11) auto_increment,
    sectionname nvarchar(500),
    contents text,
    topicgrammarID int(11),
    
    primary key(grammarID),
    foreign key(topicgrammarID) references Topicgrammar(topicgrammarID) on delete cascade
);

-- Tao bang lich su lam bai HISTORY (historyID, timetest, memberID)
Create table Historyexam
(
	historyexamID int(11) auto_increment,
    timetest timestamp,
    userID int(11),
    
    primary key(historyexamID),
    foreign key(userID) references User(userID) on delete no action
);

-- Tao bang luu tru bai thi EXAMINATION (examinationID, examinationname, image, crateddate)
Create table Examination
(
	examinationID int(11) auto_increment,
    examinationname nvarchar(100),
    examinationimage varchar(45),
    createdate timestamp,
    
    primary key(examinationID)
);

-- Tao bang ket qua lam bai thi Resultexamination(examinationID, historyID, numcorrect, numincorrect)
Create table Resultexamination
(
    numcorrect int(11),
    numincorrect int(11),
    examinationID int(11),
    historyexamID int(11),
    
    primary key(examinationID, historyexamID),
    foreign key (historyexamID) references Historyexam(historyexamID) on delete no action,
    foreign key(examinationID) references Examination(examinationID) on delete no action
);

-- Tao bang luu tru cau hoi cho trung bo de thi Examquestion(exaquestionID, part, num, audio, image, paragraph, question, option1, option2, option3, option4, correctanswer, examinationID)
Create table Examquestion
(
	exaquestionID int(11) auto_increment, 
    part int(11), 
    num int(11), 
    audio varchar(45), 
    image varchar(45), 
    paragraph TEXT, 
    question varchar(300), 
    option1 varchar(100), 
    option2 varchar(100), 
    option3 varchar(100), 
    option4 varchar(100), 
    correctanswer varchar(100),
    examinationID int(11),
    
    primary key(exaquestionID),
    foreign key(examinationID) references Examination(examinationID) on delete cascade
);
        
        
    