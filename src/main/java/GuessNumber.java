import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/guess")
public class GuessNumber extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("guess-num.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userGuess = Integer.parseInt(req.getParameter("guess"));

        Random randomNumber = new Random();
        int random = randomNumber.nextInt(3) + 1;

        if(userGuess == random){
        resp.sendRedirect("/correct?random=" + random + "&userGuess=" + userGuess);
        } else if(userGuess < 1 || userGuess > 3) {
           req.getRequestDispatcher("guess-number-outcome.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/incorrect?random=" + random + "&userGuess=" + userGuess);
        }
    }
}
