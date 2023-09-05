import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private final Connection connection;


    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword());
    }

    @Override
    public List<Ad> all() throws SQLException {
        List<Ad> ads = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM ads");
        while (rs.next()) {
            Ad ad = new Ad(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getString("description")
            );
            ads.add(ad);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad){
        long lastInsertedId = 0;

        Statement statement = null;
        try {
            statement = connection.createStatement();

            String insertQuery = String.format("INSERT INTO ads(user_id, title, description) VALUES('%d','%s','%s') ",
                    ad.getUserId(),
                    ad.getTitle(),
                    ad.getDescription()
            );
            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                lastInsertedId = rs.getInt(1);
            }
            return lastInsertedId;
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
