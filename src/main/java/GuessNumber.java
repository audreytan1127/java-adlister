import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/guess")
public class GuessNumber extends HttpServlet {
    Random randomNumber = new Random();
    int random = randomNumber.nextInt(3);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("guess-num.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userGuess = req.getParameter("guess");
        if(Integer.parseInt(userGuess) == random){
        resp.sendRedirect("correct-guess.jsp");
        } else if(Integer.parseInt(userGuess) < 0 || Integer.parseInt(userGuess) > 3) {
           resp.sendRedirect("guess-num.jsp");
        } else {
            resp.sendRedirect("incorrect-guess.jsp");
        }
    }
}
