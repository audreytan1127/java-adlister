import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//      //  This will have a form under the howdy h1. Whatever you submit will change the name on the partner page.
//        res.getWriter().println("<h1><a href='/partner'>Howdy</a></h1><form action = '/partner'><input name ='name'><button>Submit</button></form>");

//        // Exercise 1 in Servlet Exercise
//        res.getWriter().println("<h1>Hello World</h1>");

//        // Bonus 1 in Servlet Exercise: print name when localhost:8080/hello?name=
        String name = req.getParameter("name");
        if (name != null) {
            res.getWriter().println("<h1> Hello " + name + "!</h1>");
        } else {
            res.getWriter().println("<h1>Hello, World!</h1>");
        }



    }
}
