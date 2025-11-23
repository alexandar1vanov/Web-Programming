package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ChefDetailsServlet", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {
    private ChefService chefService;
    private DishService dishService;
    private SpringTemplateEngine springTemplateEngine;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        this.chefService = context.getBean(ChefService.class);
        this.dishService = context.getBean(DishService.class);
        this.springTemplateEngine = context.getBean(SpringTemplateEngine.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request, response);
        WebContext context = new WebContext(webExchange);

        String method = request.getParameter("_method");

        if (method.equals("delete")) {
            String dishId = request.getParameter("dishId").toString();
            Long chefId = Long.valueOf(request.getParameter("chefId"));
            chefService.removeDish(chefId, dishId);
        }
        //chef id i dish id
        Long chefId = Long.valueOf(request.getParameter("chefId"));
        String dishId = request.getParameter("dishId");

        log("chefId: " + chefId);
        log("dishId: " + dishId);


        Chef chef = chefService.findById(chefId);
        Dish dish = dishService.findByDishId(dishId);

        chefService.addDishToChef(chefId, dishId);

        context.setVariable("chef", chef);
        context.setVariable("dish", dish);


        response.setContentType("text/html; charset=UTF-8");
        springTemplateEngine.process("chefDetails.html", context, response.getWriter());
    }
}
