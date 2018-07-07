-- create database
CREATE DATABASE BDU_DL;

USE BDU_DL;
-- create all possible tables
CREATE TABLE Student
(
	[sid] INT PRIMARY KEY IDENTITY,
	pass VARCHAR(50) NOT NULL DEFAULT('bdu'),
	fname VARCHAR(50) NOT NULL,
	lname VARCHAR(50) NOT NULL,
	sex VARCHAR(6) NOT NULL CHECK(sex IN ('Male','Female')),
	dob DATE NOT NULL,
	dept VARCHAR(50) NOT NULL,
	aStatus INT NOT NULL CHECK(aStatus > 290),
	rYear INT NOT NULL DEFAULT(YEAR(GETDATE())),
	phoneNumber VARCHAR(50) NOT NULL
)

CREATE TABLE Professor
(
	pid INT PRIMARY KEY IDENTITY,
	pass VARCHAR(50) NOT NULL DEFAULT('bdu'),
	fname VARCHAR(50) NOT NULL,
	lname VARCHAR(50) NOT NULL,
	dept VARCHAR(50) NOT NULL,
	phoneNumber VARCHAR(50) NOT NULL
)

CREATE TABLE [Admin]
(
	aid INT PRIMARY KEY IDENTITY,
	pass VARCHAR(50) NOT NULL,
	fname VARCHAR(50) NOT NULL,
	lname VARCHAR(50) NOT NULL
)

CREATE TABLE Assignment
(
	assid INT PRIMARY KEY IDENTITY,
	pid INT FOREIGN KEY REFERENCES Professor,
	question TEXT NOT NULL,
	submitedDate DATETIME NOT NULL DEFAULT(GETDATE())
)

CREATE TABLE Material
(
	mid INT PRIMARY KEY IDENTITY,
	pid INT FOREIGN KEY REFERENCES Professor,
	title VARCHAR(100) NOT NULL,
	url VARCHAR(100) NOT NULL,
	uploadDate DATETIME NOT NULL DEFAULT(GETDATE())
)

CREATE TABLE Answer
(
	assid INT FOREIGN KEY REFERENCES Assignment,
	[sid] INT FOREIGN KEY REFERENCES Student,
	url VARCHAR(100) NOT NULL,
	submitedDate DATETIME NOT NULL DEFAULT(GETDATE()),
	mark float CHECK(mark >= 0 AND mark < 100),
	CONSTRAINT pk_answer PRIMARY KEY(assid,[sid])
)

CREATE TABLE News
(
	nid INT PRIMARY KEY IDENTITY,
	title VARCHAR(100) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	postedDate DATETIME NOT NULL DEFAULT(GETDATE())
)
 ---- delete table
drop table Answer
drop table News
drop table Student
drop table Professor
drop table Material
drop table[Admin] 
drop table Assignment
-- Adding data and retrieve data 
INSERT INTO Student VALUES ('bdu','Tamiru','Zenebe','Male','1991-10-03','csed',400,2003,'+251920774461'),
                            ('bdu','Teshager','Wossen','Male','1990-01-09','csed',500,2003,'+251918000000'),
                            ('bdu','Yosef','Kefale','Male','1992-10-13','csed',600,2003,'+251918010203'),
                            ('bdu','Yodit','zegeye','Female','1992-10-13','csed',600,2003,'+251918010203')
select *from Student
INSERT INTO Professor VALUES ('bdu','Tsegaw','T','csed','+251920020202'),
                            ('bdu','Desta','B','csed','+251918040506'),
                            ('bdu','Yibeltal','T','csed','+251918010103'),
                            ('bdu','haileyesus','l','csed','+251918066666')
   select *from Professor
INSERT INTO [Admin] VALUES ('bdu','Ashagre','T')
   select *from [Admin]


INSERT INTO Assignment VALUES (1,'What is Normalization?',GETDATE()),
                               (2,'What is ajax?',GETDATE()),
                               (3,'What is javaScript?',GETDATE()),
                                (4,'What is firewall?',GETDATE())
                               
   select *from Assignment                              
INSERT INTO Material VALUES (1,'Advanced database lab manual ','http//Adatabase.pdf',GETDATE()),
                                (2,'java exercise ','http//javaTutorial.pdf',GETDATE()),
                                (3,'exercise w3school ','http//w3school.com',GETDATE()),
                                (4,'decription ','http//ceasar cipher.com',GETDATE())
    select *from Material 
   INSERT INTO Answer VALUES (1,1,'http//answer.sql',GETDATE(),70.5),
                              (2,2,'http//answer.java',GETDATE(),50.0),
                              (3,3,'http//answer.js',GETDATE(),60.45), 
                               (4,4,'http//answer.js',GETDATE(),90.45)
    select *from Answer
  INSERT INTO News VALUES ('latest news',' For All Students you Can See Your Assignments Result On Your Acount! ',GETDATE())        
  select *from News
  
  
  
  --delete a data from inserted data 
     
  delete from  Assignment where assid = 4;
  delete from  Student where [sid] = 4;
  
  -- update a data from inserted data 
  
  update  News set title = 'update News '  where nid = 1 ;
  update  Material set title = 'jsp and servlet ex '  where mid = 2;
  
  -- view
   
  --1
  
  create view d_learn
  as 
  select nid,title,content from News
  select *from d_learn
  
  --2
  
  create view m_student
  as 
  select fname,dept,aStatus,phoneNumber from Student
  select *from m_student
  
  ---searching 
  
  select *from  Professor where fname like '%w'
  select *from  Student where fname like '%Tamiru%'
  select *from  Student where fname like 'T%'
  select *from  Student where fname like '%f'
  
  ---function
  -------1
  create function displaySum( @sid int )
   returns float
   as
   begin 
        declare @sum float;
        select  @sum =(select  sum(mark)
        from Answer where @sid =[sid]);
        return @sum
        end
      select dbo.displaySum(1) 
      ------2
      
   create function displayAvg()
      returns float
      as
      begin
      declare @avg float;
      set  @avg =(select SUM(mark )/COUNT (mark) from Answer)
      return  @avg
      end
  select dbo.displayAvg()
 ---store procedure
 -------------1
 create procedure  d_Female_highestMark(@sex varchar (6))
 as
 select s.[sid],fname from Student s,Answer a where s.[sid]= a.[sid]
 and a.mark >=90 
 and s.sex=@sex
 
 execute  d_Female_highestMark 'Female'
 ---delete procedure
 drop procedure not_givingAssignment
  
  ----------2
 create procedure not_givingMaterial
    as
    select * from Professor p 
    where p.pid not in (select m.pid from Material m)
    execute not_givingMaterial
    -----------3
    create procedure not_givingAssignment
    as
    select * from Professor p 
    where p.pid not in (select a.pid from Assignment a)
    
  execute not_givingAssignment
  --------1
  create trigger aca_StatusChecker
  on Student
  for  insert
  as
  begin
  declare @Status int;
  set @Status = (select aStatus from inserted)
  if (@Status<290)
  begin 
  raiserror('not allwed less than 290',16,1)
  rollback transaction
  end
  end
  --------2
  create trigger n_update_mark 
  on Answer
  for update
  as
  if(update(mark))
  begin
  Raiserror ('student mark does not modified ',16,1)
  rollback transaction 
  end
----security
------login
    create login tmz with password ='abc'
    create login jossy with password ='abc'
    create login teshe with password ='abc'
    -------user
    create user tmz for login tmz
    create user jossy for login jossy	
    create user teshe for login teshe
    ------role
    create role Student
    create role Professor
    create role [Admin]
    ------schema
   create schema Student authorization tmz
   create schema News authorization teshe
   create schema [Admin] authorization jossy
   -------permission
   grant select on [Admin] to tmz with grant option
   grant select,insert,delete on News to Student
   --cancel permission
   revoke grant option for select on [Admin] from tmz CASCADE 
  --assign jossy to the member of Professor
    sp_addrolemember 'Professor','jossy'
  --remove jossy from the member of Professor
    sp_droprolemember 'Professor','jossy'
    
    
  --- transaction
  ----1
  create procedure updateValues(@oldPid int,@newPid int,@oldTitle varchar(100),@newTitle varchar(100),@oldAssiQ TEXT,@newAssiQ TEXT)
  as
  begin transaction t1
  
	update Material set pid = @newPid where pid = @oldPid;
	update Material set title = @newTitle where title = @oldTitle;
	update Assignment set question = @newAssiQ where question like @oldAssiQ;
	if @@ERROR <> 0
		rollback transaction t1
  commit
  
  ----2
  
  create procedure updateUrl_pass(@oldMUrl varchar(100),@newMUrl varchar(100),@oldAUrl varchar(100),@newAUrl varchar(100),@oldAPass varchar(50),@newAPass varchar(50))
  as
  begin transaction t2
  
	update Material set url = @newMUrl where url = @oldMUrl;
	update Answer set url = @newAUrl where url = @oldAUrl;
	update [Admin] set pass = @newAPass where pass = @oldAPass;
	if @@ERROR <> 0
		rollback transaction t2
  commit
  
  