import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add-contact")
public class AddContactServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("addContacts.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String first = request.getParameter("firstName");
        String last = request.getParameter("lastName");
        String phone = request.getParameter("phone");

        if(first == null || last == null || phone == null){
            response.sendRedirect("/add-contact");
        }else if(first.equals("") || last.equals("") || phone.equals("")){
            response.sendRedirect("/add-contact");
        }else{
            try{
                Long.parseLong(phone);

                if(phone.length() == 10){
                    Contacts allContacts = ContactsDaoFactory.getContacts();
                    allContacts.saveContact(new Contact(first, last, phone));
                    List<Contact> update = allContacts.getContacts();
                    request.setAttribute("contacts", update);
                    request.getRequestDispatcher("contacts.jsp").forward(request, response);
                }else {
                    response.sendRedirect("/add-contact");
                }

            }catch (Exception e){
                response.sendRedirect("/add-contact");
            }

        }
    }
}
