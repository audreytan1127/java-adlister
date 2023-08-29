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
        String deliveryOrPickup = req.getParameter("deliver-pickup");
        String size = req.getParameter("size");
        String sauce = req.getParameter("sauce-amount");
        String[] toppings = req.getParameterValues("toppings");

        System.out.printf("Customer name: %s%n",name);
        System.out.printf("Customer Address: %s%n", address);
        System.out.println(deliveryOrPickup + "\n");
        System.out.printf("Size of Pizza: %s%n", size);
        System.out.printf("Sauce: %s%n", sauce);
        System.out.printf("Toppings: %s%n", Arrays.toString(toppings));

    }

}
