import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/order-form")
public class OrderServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        displayForm(response);
    }

    public void displayForm(HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();

        out.println("<form method=\"POST\" action =\"/order-summary\">");
        out.println("<label for='product'>Product</label>");
        out.println("<input id='product' name='product' />");
        out.println("<label for='quantity'>How Many?</label>");
        out.println("<input id='quantity' name='quantity' />");
        out.println("<input type='submit' name='submit' value='Submit' />");
        out.println("</form>");
    }
}
