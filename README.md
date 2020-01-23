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