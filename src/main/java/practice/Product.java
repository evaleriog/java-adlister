package practice;
/*
* This is the Model or JavaBean which represents an
* entitie.
* */
public class Product {
    private String name;
    private double price;

    //provides a zero argument constructor
    public Product(){}

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    //has getters and setters
    public String getName() {
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
