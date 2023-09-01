import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JDBCAlbumDao {

    private Connection connection;


    public JDBCAlbumDao() {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/codeup_test_db?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "codeup"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertAlbum(Album album) {
        int lastInsertedId = 0;
        try {
            Statement statement = connection.createStatement();
            String insertQuery = String.format("INSERT INTO albums (artist, name, release_date, sales, genre) VALUES ('%s', '%s', %d, %f, '%s')",
                    album.getArtist(),
                    album.getName(),
                    album.getReleaseDate(),
                    album.getSales(),
                    album.getGenre()
            );
            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                lastInsertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lastInsertedId;
    }
    public int deleteAlbum(String albumName) {
        int lastInsertedId = 0;
        try {
            Statement statement = connection.createStatement();
            String deleteQuery = String.format("DELETE FROM albums WHERE name = '%s'", albumName);
            statement.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lastInsertedId;
    }

    public static void main(String[] args) {
        JDBCAlbumDao albumDao = new JDBCAlbumDao();

//       // for insert album function
//        Album album = new Album(
//                "Kendrick Lamar",
//                "To Pimp a Butterfly",
//                2015,
//                24.2,
//                "Hip hop");
//        int lastInsertedId = albumDao.insertAlbum(album);
//        System.out.println("Added a new album with an id of..." + lastInsertedId);


//       // for delete function
        albumDao.deleteAlbum("Bad");
    }
}