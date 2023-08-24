import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/partner")
public class PartnerServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  //  Access to this doGet localhost:8080/partner?name=Justin = will print Justin in h1
//        String name = request.getParameter("name");
//        if(name != null){
//            response.getWriter().println("<h1>" + name + "</h1>");
//        } else {
//            response.getWriter().println("<h1>Partner</h1>");
//        }
    }

}
