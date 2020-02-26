В идее создаем новый проект 
Указываем что проект будет Maven и версию java 
указываем groupId и artifactId  version
В pom.xml указываем packaging war, чтоб в результате сборки проекта был создан war файл, а не jar.
Так же в пом файл прописываем зависимости 
spring-core
spring-web
spring-webmvc
javax.servlet
jackson-databind для работы с джейсон
jackson-dataformat-xml

создаем класс AndMySpringMVCRestController
указываем для него аннотацию @RestController, чтобы спринг определил его как контролер, и тогда не нужно создавать web.xml
для методов которые должны выполнитьсяпо реквесту указываем @RequestMapping
Для того чтоб war файл сформировался, в меню Maven нажимаем clean а затем package.
В результате формируется war файл.


Развернуть ТОМКАТ
Перейти на сайт https://tomcat.apache.org/download-90.cgi
32-bit/64-bit Windows Service Installer
Запускаем установщик
На закладке Configuration установщика можно указать порт 
далее указывается версия java используемая в проекте
созданный в проекте war файл закидываем в папку webapps в каталоге, котором установлен Томкат
Перезапускаем томкат



Создаем пустую базу, для этого в консоле набираем:
create database test_db;
show databases;
use test_db;

Создаем таблицу DICTIONARY
create table DICTIONARY(
id int not null primary key auto_increment,
discriminator varchar(10),
name varchar(25),
ext_id int
);

Создаем записи dictionary
insert into dictionary(discriminator, name)
value('ROLE', 'USER');

insert into dictionary(discriminator, name)
value('ROLE', 'ADMIN');

Создаем таблицу user
create table user(
id int not null PRIMARY KEY AUTO_INCREMENT,
name varchar(25),
role varchar(4)
);

Вносим данные в таблицу
insert into user (name, role)
value('user1', 'ADMIN' );

Для связи двухтаблиц создадим foreign key для поля ext_id
alter table dictionary
    -> add constraint user_id_fk
    -> foreign key (ext_id) references user (id) on delete cascade on update cascade;
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`satest_db`.`#sql-a70_8`, CONSTRAINT `user_id_fk` FOREIGN KEY (`ext_id`) REFERENCES `user` (`id`) 
ON DELETE CASCADE ON UPDATE CASCADE)
возникает ошибка поскольку уже есть записи наршающие ссылочную целостность
очистим таблицу dictionary

delete from dictionary;

повторим изменение таблиы
alter table dictionary
    -> add constraint user_id_fk
    -> foreign key (ext_id) references user (id) on delete cascade on update cascade;
    в этот раз успешно.
    
     
     insert into dictionary(descriminator, name, ext_id)
         -> value('role','user1',2);
         
         сделаем выборку чтоб получить сводную таблицу
         
         select d.id, d.name, u.name from dictionary d left join user u
             -> on (d.ext_id = u.id);
         +----+-------+------+
         | id | name  | name |
         +----+-------+------+
         |  3 | user1 | saha |
         +----+-------+------+
         1 row in set (0.01 sec)
         
         хороший пост https://www.boraji.com/spring-4-hibernate-5-integration-example-with-zero-xml

Создание таблицы Фильм
 CREATE TABLE film (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) DEFAULT NULL,
  genre varchar(100) DEFAULT NULL,
  duration int(11) DEFAULT NULL,
  PRIMARY KEY (id)
)



Создание таблицы Залы

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

создание триггера по внесению мест после вставки Зала
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

Создание таблицы Сеансов

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



создание таблицы Билетов

create table Ticket(
id int,
session_id int not null,
place_id int not null,
user_id int,
primary key(session_id, place_id)
);