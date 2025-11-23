package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "chefList", urlPatterns = "/listChefs")
public class ChefListServlet extends HttpServlet {
    private ChefService chefService;
    private SpringTemplateEngine springTemplateEngine;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        this.chefService = context.getBean(ChefService.class);
        this.springTemplateEngine = context.getBean(SpringTemplateEngine.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request, response);

        WebContext context = new WebContext(webExchange);

        List<Chef> chefs;
        chefs = chefService.listChefs();

        System.out.println("chefs loaded: " + chefs);
        System.out.println("chefs loaded size: " + chefs.size());
        context.setVariable("chefs", chefs);

        log(chefs.toString());

        response.setContentType("text/html; charset=UTF-8");
        springTemplateEngine.process("listChefs.html", context, response.getWriter());
    }
}
