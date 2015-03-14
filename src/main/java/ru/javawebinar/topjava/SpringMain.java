package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.service.UserMealServiceImpl;
import ru.javawebinar.topjava.web.meal.UserMealRestController;
import ru.javawebinar.topjava.web.user.AdminUserRestController;
import ru.javawebinar.topjava.model.UserMeal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public class SpringMain {
    public static void main(String[] args) {
//        // java 7 Automatic resource management
//        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
//            System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
//            AdminUserRestController adminController = appCtx.getBean(AdminUserRestController.class);
//            adminController.delete(7);
//            //adminController.getByMail("dummy");
//        }
//
//        //old with close resources
//        System.out.println("\n");
//        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
//        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
//        MockUserRepositoryImpl mockUserRepositoryImpl = (MockUserRepositoryImpl) appCtx.getBean("mockUserRepositoryImpl");
//        mockUserRepositoryImpl = appCtx.getBean(MockUserRepositoryImpl.class);
//
//        appCtx.close();
//
//        //my check
//        System.out.println("\n\nMockUserMealRepositoryImpl:");
//        try (ConfigurableApplicationContext appCtx2 = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
//            System.out.println(appCtx2.getBean(MockUserMealRepositoryImpl.class));
//            MockUserMealRepositoryImpl mumr = appCtx2.getBean(MockUserMealRepositoryImpl.class);
//            User user = new User();
//            user.setId(0);
////            mumr.delete(3);
////            mumr.getAllMeals(LoggedUser.id());
////            mumr.getMeal(3);
////            mumr.save(new UserMeal("myMeal",user, 1000, new Date(), new Date()));
//        }
//
//
//        //my check2 from Controller
//        System.out.println("\n\nUserMealRestController:");
//        try (ConfigurableApplicationContext appCtx2 = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
//            System.out.println(appCtx2.getBean(UserMealRestController.class));
//            UserMealRestController mumr = appCtx2.getBean(UserMealRestController.class);
//            User user = new User();
//            user.setId(0);
//            mumr.delete(3);
////            mumr.deleteAllMeals(LoggedUser.id());
////            mumr.getAllMeals(LoggedUser.id());
////            mumr.getMeal(3);
////            mumr.save(new UserMeal("myMeal", user, 1000, new Date(), new Date()));
////            mumr.update(1);
////            mumr.getMeal(1);
//            //try sort by startDate with existing list
//            UserMeal m1 = new UserMeal("m1", new User(), 1, new Date(1234567890l), new Date(1234567890123l));
//            UserMeal m2 = new UserMeal("m2", new User(), 2, new Date(12345678901l), new Date(1234567890123l));
//            UserMeal m3 = new UserMeal("m3", new User(), 3, new Date(123456789012l), new Date(1234567890123l));
//            List<UserMeal> userMeals = new ArrayList<>();
//            userMeals.add(m3);
//            userMeals.add(m2);
//            userMeals.add(m1);
//            System.out.println("Before filter by startDate:");
//            for (UserMeal userMeal : userMeals) {
//                System.out.println("startDate: " + userMeal.getFromDate() );
//            }
//            UserMealService service = appCtx2.getBean(UserMealServiceImpl.class);
//            List<UserMeal> filteredList = service.filterByBetweenDates(new Date(1234567900), new Date(12345678901234l), userMeals);
//            System.out.println("After filter by startDate: " + new Date(1234567900)+ ", endDate: " + new Date(12345678901234l));
//            for (UserMeal userMeal : filteredList) {
//                System.out.println("startDate: " + userMeal.getFromDate() );
//            }
//
//        }
//
//
//        //my check3 through annotations
//        System.out.println("\n\ntry annotation");
//        try (AnnotationConfigApplicationContext appCtx3 = new AnnotationConfigApplicationContext("ru.javawebinar.topjava")) {
//            UserMealRestController mumr3 = appCtx3.getBean(UserMealRestController.class);
//            //mumr3.getMeal(3);
//        }
    }
}
