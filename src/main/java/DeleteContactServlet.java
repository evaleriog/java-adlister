import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/delete")
public class DeleteContactServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.getRequestDispatcher("deleteContacts.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id = request.getParameter("id");

        try{
            long idErase = Long.parseLong(id);
            Contacts contacts = ContactsDaoFactory.getContacts();
            contacts.deleteContactById(idErase);
            List<Contact> update = contacts.getContacts();
            request.setAttribute("contacts", update);
            request.getRequestDispatcher("contacts.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
