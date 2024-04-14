package certificationNumber2;

import certificationNumber2.model.Employee;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlJDBC {

    private final String sqlSelectGetById = "select * from employee where id = ?";
    private final String sqlDeleteEmpById = "delete from employee where id = ?";
    private final String sqlDeleteCompById = "delete from company where id = ?";
    private final String sqlInsertCompany = "insert into company(\"name\") values (?)";
    private final String sqlInsertEmployee = "insert into employee (first_name, last_name, middle_name, email, phone, birthdate, company_id)" +
            " values (?,?,?,?,?,?,?)";

    public final Connection connection;

    public ControlJDBC(String connection, String user, String pass) {
        try {
            this.connection = DriverManager.getConnection(connection, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int createCompany(String name) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertCompany, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.executeUpdate();

            ResultSet key = statement.getGeneratedKeys();
            key.next();
            return key.getInt(7);
        } catch (SQLException e) {
            System.out.println("Error when calling createCompany method" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public int createEmployee(String firstName, String lastName, String middleName,
                              String email, String phone, String birthdate, Integer companyId) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertEmployee, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = dateFormat.parse(birthdate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, middleName);
            statement.setString(4, email);
            statement.setString(5, phone);
            statement.setDate(6, new java.sql.Date(date.getTime()));
            statement.setInt(7, companyId);
            statement.executeUpdate();
            ResultSet key = statement.getGeneratedKeys();
            key.next();
            return key.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error when calling createEmployee method" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Employee selectEmployeeInfo(Integer id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlSelectGetById);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Employee(
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("middle_name"),
                    resultSet.getString("email"),
                    resultSet.getString("avatar_url"),
                    resultSet.getString("phone"),
                    resultSet.getString("birthdate"),
                    resultSet.getBoolean("is_active"),
                    resultSet.getInt("company_id")
            );
        } catch (SQLException e) {
            System.out.println("Error when calling selectEmployeeInfo method" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deleteEmp(Integer id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlDeleteEmpById);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error when calling deleteEmp method" + e.getMessage());
        }
    }

    public void deleteComp(Integer id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlDeleteCompById);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error when calling deleteComp method" + e.getMessage());
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("error Connection close" + e.getMessage());
        }
    }
}
