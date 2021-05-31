package mc.apps.spring;

import mc.apps.spring.jpa.User;
import mc.apps.spring.jpa.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@SpringBootApplication
/**
 * @Configuration: Tags the class as a source of bean definitions for the application context.
 * @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
 * @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
 */
public class SpringSamplesApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringSamplesApplication.class) ;

    public static void main(String[] args) {
        SpringApplication.run(SpringSamplesApplication.class, args);
        log.info("start!");
    }

    /**
     * CommandLineRunner is an interface used to indicate that a bean
     * should run when it is contained within a SpringApplication.
     * => L'interface CommandLineRunner permet d'exécuter du code utilisateur
     * au démarrage d'une application Spring Boot.
     * cf. x.beans.MyRunner
     */
    @Bean
    public CommandLineRunner demo(UserRepository repository){

       return (args) -> {
            repository.save(new User("James", "Bond"));
            repository.save(new User("Jason", "Bourne"));

            log.info("-------------------------------");
            log.info("Liste 'users' : ");
            Iterable<User> items = repository.findAll();
            items.forEach(item ->log.info(item.toString()));
            log.info("-------------------------------");
        };
    }

}
