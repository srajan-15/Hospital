import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class VisitingHospital {
    static Scanner scan = null;
    static Connection connection = null;

    public void visitingCounter() {
        scan = new Scanner(System.in);
        // Your existing code...

        // Establish a database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Insert user data into the database
        try {
            String insertQuery = "INSERT INTO patients (name, age, mobnum, disease) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, age);
            preparedStatement.setLong(3, mobnum);
            preparedStatement.setString(4, disease);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Rest of your code...

    public static void main(String[] args) {
        new VisitingHospital().visitingCounter();
        VisitingHospital.visit();
        new VisitingHospital().listforMediciens();

        // Close the database connection
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
