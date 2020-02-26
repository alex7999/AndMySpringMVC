� ���� ������� ����� ������ 
��������� ��� ������ ����� Maven � ������ java 
��������� groupId � artifactId  version
� pom.xml ��������� packaging war, ���� � ���������� ������ ������� ��� ������ war ����, � �� jar.
��� �� � ��� ���� ����������� ����������� 
spring-core
spring-web
spring-webmvc
javax.servlet
jackson-databind ��� ������ � �������
jackson-dataformat-xml

������� ����� AndMySpringMVCRestController
��������� ��� ���� ��������� @RestController, ����� ������ ��������� ��� ��� ���������, � ����� �� ����� ��������� web.xml
��� ������� ������� ������ ������������� �������� ��������� @RequestMapping
��� ���� ���� war ���� �������������, � ���� Maven �������� clean � ����� package.
� ���������� ����������� war ����.


���������� ������
������� �� ���� https://tomcat.apache.org/download-90.cgi
32-bit/64-bit Windows Service Installer
��������� ����������
�� �������� Configuration ����������� ����� ������� ���� 
����� ����������� ������ java ������������ � �������
��������� � ������� war ���� ���������� � ����� webapps � ��������, ������� ���������� ������
������������� ������



������� ������ ����, ��� ����� � ������� ��������:
create database test_db;
show databases;
use test_db;

������� ������� DICTIONARY
create table DICTIONARY(
id int not null primary key auto_increment,
discriminator varchar(10),
name varchar(25),
ext_id int
);

������� ������ dictionary
insert into dictionary(discriminator, name)
value('ROLE', 'USER');

insert into dictionary(discriminator, name)
value('ROLE', 'ADMIN');

������� ������� user
create table user(
id int not null PRIMARY KEY AUTO_INCREMENT,
name varchar(25),
role varchar(4)
);

������ ������ � �������
insert into user (name, role)
value('user1', 'ADMIN' );

��� ����� ���������� �������� foreign key ��� ���� ext_id
alter table dictionary
    -> add constraint user_id_fk
    -> foreign key (ext_id) references user (id) on delete cascade on update cascade;
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`satest_db`.`#sql-a70_8`, CONSTRAINT `user_id_fk` FOREIGN KEY (`ext_id`) REFERENCES `user` (`id`) 
ON DELETE CASCADE ON UPDATE CASCADE)
��������� ������ ��������� ��� ���� ������ ��������� ��������� �����������
������� ������� dictionary

delete from dictionary;

�������� ��������� ������
alter table dictionary
    -> add constraint user_id_fk
    -> foreign key (ext_id) references user (id) on delete cascade on update cascade;
    � ���� ��� �������.
    
     
     insert into dictionary(descriminator, name, ext_id)
         -> value('role','user1',2);
         
         ������� ������� ���� �������� ������� �������
         
         select d.id, d.name, u.name from dictionary d left join user u
             -> on (d.ext_id = u.id);
         +----+-------+------+
         | id | name  | name |
         +----+-------+------+
         |  3 | user1 | saha |
         +----+-------+------+
         1 row in set (0.01 sec)
         
         ������� ���� https://www.boraji.com/spring-4-hibernate-5-integration-example-with-zero-xml

�������� ������� �����
 CREATE TABLE film (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) DEFAULT NULL,
  genre varchar(100) DEFAULT NULL,
  duration int(11) DEFAULT NULL,
  PRIMARY KEY (id)
)



�������� ������� ����

 CREATE TABLE hall (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(25) DEFAULT NULL,
  qRow int(11) DEFAULT NULL,
  qPosition int(11) DEFAULT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE place (
  id int(11) NOT NULL AUTO_INCREMENT,
  position int(11) DEFAULT NULL,
  nrow int(11) DEFAULT NULL,
  hall_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKi6xueble16lcu6ftbkb0jf0mf (hall_id),
  CONSTRAINT FKi6xueble16lcu6ftbkb0jf0mf FOREIGN KEY (hall_id) REFERENCES hall (id),
  CONSTRAINT place_ibfk_1 FOREIGN KEY (hall_id) REFERENCES hall (id)
)

�������� �������� �� �������� ���� ����� ������� ����
delimiter |
create trigger create_places after insert on hall
	for each row begin 
		set @i = 1;
		while @i <= new.qrow do
			set @j = 1;
			while @j <= new.qposition do
 				insert into place (hall_id, position, nrow) values(new.id, @j, @i);
				set @j = @j + 1;
			end while;
			set @i = @i + 1;
		end while;
	end;
delimiter ;

�������� ������� �������

CREATE TABLE sessionfilm (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) DEFAULT NULL,
  timeStart timestamp NULL DEFAULT NULL,
  timeFinish timestamp NULL DEFAULT NULL,
  film_id int(11) DEFAULT NULL,
  hall_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKk2xs8jwc1ksv14bepkob3f35j (film_id),
  KEY FK4mmjgbt8f4rtbgldg99vfoova (hall_id),
  CONSTRAINT FK4mmjgbt8f4rtbgldg99vfoova FOREIGN KEY (hall_id) REFERENCES hall (id),
  CONSTRAINT FKk2xs8jwc1ksv14bepkob3f35j FOREIGN KEY (film_id) REFERENCES film (id)
)



�������� ������� �������

create table Ticket(
id int,
session_id int not null,
place_id int not null,
user_id int,
primary key(session_id, place_id)
);