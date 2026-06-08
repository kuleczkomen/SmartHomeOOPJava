import java.sql.*;

public class Database {
    // Magiczny URL - baza istnieje tylko w pamięci RAM
    private static final String URL = "jdbc:sqlite::memory:";

    // Trzymamy połączenie otwarte przez cały czas działania programu
    private static Connection connection;

    public static void initDatabase() {
        try {
            // Inicjalizujemy połączenie (nie zamykamy go tutaj!)
            connection = DriverManager.getConnection(URL);

            try (Statement stmt = connection.createStatement()) {
                // Tworzymy tabele
                stmt.execute("""
                    CREATE TABLE IF NOT EXISTS users (
                        id INTEGER PRIMARY KEY,
                        email TEXT NOT NULL,
                        user_type TEXT NOT NULL
                    )
                """);
                stmt.execute("""
                    CREATE TABLE IF NOT EXISTS company (
                        domain_name TEXT PRIMARY KEY,
                        number_of_employees INTEGER NOT NULL
                    )
                """);

                // Wstawiamy dane startowe
                stmt.execute("INSERT INTO company VALUES ('twojafirma.pl', 100)");
                stmt.execute("INSERT INTO users VALUES (1, 'stary@gmail.com', 'Customer')");

                System.out.println("Statyczna baza in-memory gotowa!");
            }
        } catch (SQLException e) {
            System.err.println("Błąd bazy: " + e.getMessage());
        }
    }

    public static Object[] getUserById(int userId) {
        String sql = "SELECT id, email, user_type FROM users WHERE id = ?";

        // UWAGA: Używamy statycznego 'connection', zamykamy tylko PreparedStatement i ResultSet
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Object[]{
                            rs.getInt("id"),
                            rs.getString("email"),
                            UserType.valueOf(rs.getString("user_type"))
                    };
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[] getCompany() {
        String sql = "SELECT domain_name, number_of_employees FROM company LIMIT 1";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return new Object[]{
                        rs.getString("domain_name"),
                        rs.getInt("number_of_employees")
                };
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveCompany(int newNumber) {
        String sql = "UPDATE company SET number_of_employees = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, newNumber);
            pstmt.executeUpdate();
            System.out.println("DB (Memory): Zaktualizowano liczbę pracowników na " + newNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveUser(User user) {
        String sql = "UPDATE users SET email = ?, user_type = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, user.getEmail());
            // Enum konwertujemy na String, bo tak zapisaliśmy go przy tworzeniu tabeli
            pstmt.setString(2, user.getType().name());
            pstmt.setInt(3, user.getUserId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("DB (Memory): Zapisano nowe dane użytkownika o ID: " + user.getUserId());
            } else {
                System.out.println("DB (Memory): Nie znaleziono użytkownika o ID: " + user.getUserId());
            }

        } catch (SQLException e) {
            System.err.println("Błąd podczas zapisu użytkownika: " + e.getMessage());
        }
    }
}