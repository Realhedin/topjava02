package ru.javawebinar.topjava.service.jpaTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.service.UserMealServiceTest;

/**
 * Created by Dmitrii on 4/1/15.
 */
@ActiveProfiles({"postgres","jpa"})
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaUserMealServiceTest extends UserMealServiceTest {

}