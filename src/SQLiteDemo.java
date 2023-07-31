import org.sqlite.SQLiteDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


//Example
public class SQLiteDemo {

    //Example for sql statement for new table
    static String createTableSQL = "CREATE TABLE IF NOT EXISTS Items (\n"
            + " id integer PRIMARY KEY,\n"
            + " name text NOT NULL,\n"
            + " description text NOT NULL,\n"
            + " type text NOT NULL\n"
            + ");";


    static SQLiteDataSource ds = null;
    public static void main(String[] args) {
        String url = "jdbc:sqlite:dungeon.db";

        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:questions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println( "Opened database successfully" );

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()) {

            statement.execute(createTableSQL);

            System.out.println("Table created successfully!");

            // example
            String itemsinserted = "INSERT INTO Items(id, name, description, type) VALUES(1, 'Healing Potion', 'Restores health', 'potion');";

            statement.execute(itemsinserted);

            System.out.println("Room created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit( 0 );
        }

        System.out.println("press enter to close program/window");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}

