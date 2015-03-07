package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.mock.MockUserMealRepository;
import ru.javawebinar.topjava.repository.mock.MockUserRepository;

import java.util.Arrays;
import java.util.Date;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        MockUserRepository mockUserRepository = (MockUserRepository) appCtx.getBean("mockUserRepository");
        mockUserRepository = appCtx.getBean(MockUserRepository.class);

        appCtx.close();

        //my check
        System.out.println("\n\n");
        try (ConfigurableApplicationContext appCtx2 = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println(appCtx2.getBean(MockUserMealRepository.class));
            MockUserMealRepository mumr = appCtx2.getBean(MockUserMealRepository.class);
            mumr.delete(3);
            mumr.getAllMeals();
            mumr.getMeal(3);
            mumr.save(new UserMeal("myMeal",1000,new Date()));
        }
    }
}
