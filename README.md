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