public class Contact {
    private long id;
    private String firstName;
    private String lastName;
    private String phone;

    public Contact(){}

    public Contact(String firstName, String LastName, String phone){
        this.firstName = firstName;
        this.lastName = LastName;
        this.phone = phone;
    }
    public Contact(int id, String firstName, String LastName, String phone){
        this.id = id;
        this.firstName = firstName;
        this.lastName = LastName;
        this.phone = phone;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public long getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getPhone(){
        return this.phone;
    }
}
