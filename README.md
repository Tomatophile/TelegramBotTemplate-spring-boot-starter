# TelegramBotTemplate
### It is lib for simple creating telegram bots

---

add my repository in pom.xml or settings.xml

#### [https://raw.githubusercontent.com/Tomatophile/mvn-repository/master/]

>>\<repository>\
>>\<id>tomato-repo\</id>\
>>\<name>tomato-repo\</name>\
>>\<url>https://raw.githubusercontent.com/Tomatophile/mvn-repository/master\</url>\
>>\</repository>

then add this parent

>>\<parent>\
>>  \<groupId>org.telegram.tomatophile\</groupId>\
>>  \<artifactId>TelegramBotTemplate-spring-boot-starter-parent\</artifactId>\
>>  \<version>1.0-SNAPSHOT\</version>\
>>  \<relativePath/>\
>>\</parent>

and this dependency

>>\<dependency>\
>>  \<groupId>org.telegram.tomatophile\</groupId>\
>>  \<artifactId>TelegramBotTemplate-spring-boot-starter\</artifactId>\
>>  \<version>1.0-SNAPSHOT\</version>\
>>\</dependency>

create main class like this

![Main class](https://i.ibb.co/LxcffQ1/image.png)

then extend AbstractTelegramBot class like this (your class must be @Component)

![Bot class](https://i.ibb.co/6bLQSNR/image.png)

and imlement Callback, Command and Text classes

example: 

![Example command](https://i.ibb.co/2scZZ74/image.png)

You can check working example on [BirthdayBot-bottemplate-example](https://github.com/Tomatophile/BirthdayBot-bottemplate-example)
