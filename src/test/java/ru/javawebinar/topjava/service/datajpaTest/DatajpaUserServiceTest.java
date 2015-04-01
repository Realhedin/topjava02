package ru.javawebinar.topjava.service.datajpaTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.service.UserServiceTest;

/**
 * Created by Dmitrii on 4/1/15.
 */
@ActiveProfiles({"postgres","datajpa"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DatajpaUserServiceTest extends UserServiceTest {
}
