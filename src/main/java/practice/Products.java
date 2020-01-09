package practice;

import java.util.List;
//This is the DAO interface

interface Products {
    List<Product> all();
    void insert(Product product);
}
