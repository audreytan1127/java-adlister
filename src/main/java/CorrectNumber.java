import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/correct")
public class CorrectNumber extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int randomNum = Integer.parseInt(req.getParameter("random"));
        int userGuess = Integer.parseInt(req.getParameter("userGuess"));
        req.setAttribute("message", "You Win! You guessed " + userGuess + " and the number was " + randomNum);
        req.getRequestDispatcher("guess-number-outcome.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
