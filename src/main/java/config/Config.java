package config;

public class Config {
    public String getURL(){
        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    }

    public String getUsername(){
        return "eddy";
    }

    public String getPassword(){
        return "eddySecretP@assw0rd";
    }
}
