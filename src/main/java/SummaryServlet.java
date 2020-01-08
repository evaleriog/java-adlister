import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/order-summary")
public class SummaryServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String product = request.getParameter("product");
        String quantity = request.getParameter("quantity");

        out.println("<h1>The Summary of your order is: </h1>");
        out.println("<p>Product: " + product + "</p>");
        out.println("<p>Quantity: " + quantity + "</p>");
    }
}
