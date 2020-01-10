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
        String isEmpty = request.getParameter("empty");
        String firstIsEmpty = request.getParameter("firstempty");
        String lastIsEmpty = request.getParameter("lastempty");
        String phoneIsEmpty = request.getParameter("phonempty");
        request.setAttribute("enterFirst", request.getParameter("enterFirst"));
        request.setAttribute("enterLast", request.getParameter("enterLast"));
        request.setAttribute("enterPhone", request.getParameter("enterPhone"));

        if(firstIsEmpty != null){
            request.setAttribute("firstMessage", "First Name Can Not Be Empty");
        }

        if(lastIsEmpty != null){
            request.setAttribute("lastMessage", "Last Name Can Not Be Empty");
        }

        if(phoneIsEmpty != null){
            request.setAttribute("phoneMessage", "Phone Can Not Be Empty");
        }

        request.getRequestDispatcher("addContacts.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String first = request.getParameter("firstName");
        String last = request.getParameter("lastName");
        String phone = request.getParameter("phone");

        if(first == null || last == null || phone == null){
            response.sendRedirect("/add-contact?empty=true");
        }else if(first.equals("") || last.equals("") || phone.equals("")){
            String resQuery = "/add-contact?empty";
            if(first.equals("")){
                //response.sendRedirect("/add-contact?firtsempty");
                resQuery += "&firstempty";
            }else {
                request.setAttribute("enterFirst", first);
            }
            if(last.equals("")){
                //response.sendRedirect("/add-contact?lastempty");
                resQuery += "&lastempty";
            }else{
                request.setAttribute("enterLast", last);
            }

            if(phone.equals("")){
                //response.sendRedirect("/add-contact?phoneempty");
                resQuery += "&phonempty";
            }else{
                request.setAttribute("enterPhone", phone);
            }

            response.sendRedirect(resQuery);
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
