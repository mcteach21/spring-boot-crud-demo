package mc.apps.spring.beans;

import mc.apps.spring.SpringSamplesApplication;
import mc.apps.spring.jpa.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(MyRunner.class) ;

    @Autowired
    UserRepository repository;

    @Autowired
    private ApplicationContext appContext;

    @Override
    public void run(String... args) throws Exception {
        log.info("MyRunner : run..");
        log.info("*******************************************");
        log.info("Liste beans : ");
        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.asList(beans).forEach(bean ->log.info(bean));

        log.info("*******************************************");
        repository.findAll().forEach((user) -> {
            log.info("{}", user);
        });
        log.info("*******************************************");
    }
}
