package ru.javawebinar.topjava.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.BaseEntity;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for Meal
 *
 * Created by Dmitrii on 2/28/15.
 */
public class MealServlet extends HttpServlet {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MealServlet.class);
    private WebApplicationContext web;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        web = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //LOG.debug("redirect to mealList");
        LOG.debug("print table Meals for current user");

        UserMealService mealService = web.getBean(UserMealService.class);
        UserService userService = web.getBean(UserService.class);
        request.setAttribute("allMeals", mealService.getAll(BaseEntity.START_SEQ));
        request.setAttribute("userName", userService.get(BaseEntity.START_SEQ).getName());
        request.getRequestDispatcher("/WEB-INF/jsp/mealList.jsp").forward(request, response);
       // response.sendRedirect("mealList.jsp");
    }
}
