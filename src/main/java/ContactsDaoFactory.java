public class ContactsDaoFactory {
    private static Contacts allContacts;

    public static Contacts getContacts(){
        if(allContacts == null){
            allContacts = new ContactsDao();
        }

        return allContacts;
    }
}
