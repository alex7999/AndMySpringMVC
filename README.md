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