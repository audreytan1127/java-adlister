import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/pizza-order")
public class PizzaOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pizza.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pizza.jsp").forward(req,resp);

        String name = req.getParameter("username");
        String address = req.getParameter("address");
        String size = req.getParameter("size");
        String sauce = req.getParameter("sauce");
        String[] toppings = {req.getParameter("toppings")};

        System.out.println(name);
        System.out.println(address);
        System.out.println(size);
        System.out.println(sauce);
        for(String topping:toppings){
        System.out.println(topping);
        }

        req.setAttribute(name, "name");
        req.setAttribute(address, "address");
        req.setAttribute(size, "size");
        req.setAttribute(sauce, "sauce");
        req.setAttribute(Arrays.toString(toppings), "toppings");

    }

}
