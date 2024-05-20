package com.example.javaspringjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class JavaSpringJpaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(JavaSpringJpaApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(PersonneDBService.class);
//        PersonneDBService service = context.getBean(PersonneDBService.class);
//        List<PersonneDB> list = service.getAll();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getName()+"a");
//        }
//        context.close();
//        Personne pers = context.getBean(Personne.class);
//        Personne pers2 = context.getBean(Personne.class);
//        System.out.println(pers == pers2);
    }

}
