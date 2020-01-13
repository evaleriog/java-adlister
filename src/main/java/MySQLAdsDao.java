import java.sql.*;
import java.util.*;
import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {
    private Connection connection;
    private List<Ad> allAds;

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(config.getURL(), config.getUsername(), config.getPassword());
    }

    public List<Ad> all() throws SQLException{
        if(allAds == null){
            String query = "SELECT * FROM ads";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                allAds.add(new Ad(rs.getLong("id"),rs.getLong("userId"),rs.getString("title"), rs.getString("description")));
            }
        }

        return allAds;
    }

    public Long insert(Ad ad) throws SQLException{
        String query = "INSERT INTO ads(userId, title, description) VALUES (" + ad.getUserId() + ",'" + ad.getTitle() + "','" + ad.getDescription() +"')";
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()){
            return rs.getLong(1);
        }else{
            return 0L;
        }
    }
}
