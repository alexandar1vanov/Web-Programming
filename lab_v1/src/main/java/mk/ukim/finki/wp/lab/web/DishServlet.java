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
import java.util.List;

@WebServlet(name = "DishServlet", urlPatterns = "/dish")
public class DishServlet extends HttpServlet {
    private DishService dishService;
    private ChefService chefService;
    private SpringTemplateEngine springTemplateEngine;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        this.dishService = context.getBean(DishService.class);
        this.chefService = context.getBean(ChefService.class);
        this.springTemplateEngine = context.getBean(SpringTemplateEngine.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long chefId = Long.valueOf(request.getParameter("chefId"));
//        log("chefId: " + chefId);

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request, response);
        WebContext context = new WebContext(webExchange);

        List<Dish> dishes = dishService.listDishes();
//        log("dishes: " + dishes);

        context.setVariable("dishes", dishes);

        Chef chef = chefService.findById(chefId);
        context.setVariable("chef", chef);

        response.setContentType("text/html; charset=UTF-8");
        springTemplateEngine.process("dishlist.html", context, response.getWriter());
    }

}
