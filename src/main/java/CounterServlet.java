import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet(name = "CounterServlet", urlPatterns = "/counter")
public class CounterServlet extends HttpServlet{
    int pageCounter = 0;


    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String userResponse = req.getParameter("reset");
        pageCounter++;

        if(userResponse != null && userResponse.toLowerCase().equals("yes")){
            pageCounter = 0;
            out.println("<p>Counter was reset</p>");
        }

        out.println("<p>The Page Counter: " + pageCounter + "</p>");
    }
}

