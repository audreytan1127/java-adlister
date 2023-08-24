import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//    // Bonus 2 in Servlet Exercise: print hit count when localhost:8080/count visited
@WebServlet("/count")
public class HitCount extends HttpServlet {
    private static int hitCount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String reset = req.getParameter("reset");
        if (reset != null) {
            hitCount = 0;
            res.sendRedirect(getServletContext().getContextPath() + "/count");
        } else {
            res.getWriter().println("<h1>How many times this page has been visited: </h1>" + hitCount++);
        }
    }
}
