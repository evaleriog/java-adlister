import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/contacts")
public class ContactsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Contacts myContacts = ContactsDaoFactory.getContacts();
        List<Contact> allContacts = myContacts.getContacts();
        request.setAttribute("contacts", allContacts);
        request.getRequestDispatcher("contacts.jsp").forward(request, response);
    }
}
