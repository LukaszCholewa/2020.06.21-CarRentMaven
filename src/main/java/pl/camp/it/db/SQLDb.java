package pl.camp.it.db;

import pl.camp.it.model.Bus;
import pl.camp.it.model.Car;
import pl.camp.it.model.User;
import pl.camp.it.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLDb {
    public static final Connection connection = connect();

    private static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car-rent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Brak połączenia z bazą !!");
        return null;
    }

    public static void saveVehicle(Vehicle vehicle) {
        try {
            Statement statement = connect().createStatement();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tvehicle (brand, model, vin, rent, personsAmount, wheelsCount)")
                    .append(" values('")
                    .append(vehicle.getBrand())
                    .append("', '")
                    .append(vehicle.getModel())
                    .append("', '")
                    .append(vehicle.getVin())
                    .append("', ")
                    .append(vehicle.isRent());

            if (vehicle instanceof Bus) {
                Bus temp = (Bus) vehicle;
                sql.append(", ")
                        .append(temp.getPersonsAmount())
                        .append(", ")
                        .append(temp.getWheelsCount());

            } else {
                sql.append(", ")
                        .append("NULL")
                        .append(", ")
                        .append("NULL");
            }
            sql.append(")");

            statement.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehicle> getAllVehicles() {
        List<Vehicle> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();

            ResultSet wyniki = statement
                    .executeQuery("SELECT * FROM tvehicle");

            while (wyniki.next()) {
                int id = wyniki.getInt("id");
                String brand = wyniki.getString("brand");
                String model = wyniki.getString("model");
                String vin = wyniki.getString("vin");
                boolean rent = wyniki.getBoolean("rent");

                Integer personsAmount = wyniki.getInt("personsAmount");
                Integer wheelsCount = wyniki.getInt("wheelsCount");

                if (wyniki.wasNull()) {
                    resultList.add(new Car(id, brand, model, vin, rent));
                } else {
                    resultList.add(new Bus(id, brand, model, vin, rent, personsAmount, wheelsCount));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public static void updateVehicleRent(Vehicle vehicle) {
        try {
            Statement statement = connection.createStatement();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE tvehicle SET rent = ")
                    .append(vehicle.isRent())
                    .append(" WHERE id = ")
                    .append(vehicle.getId());

            statement.executeUpdate(sql.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getUserByLogin(String login) {
        try {
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM tuser WHERE login = '" + login +"'";

            ResultSet result = statement.executeQuery(sql);

            if (result.next()){
                User user = new User();
                user.setId(result.getInt("id"));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));

                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}




