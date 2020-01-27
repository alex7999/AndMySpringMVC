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