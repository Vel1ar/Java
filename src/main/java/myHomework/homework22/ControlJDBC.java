package myHomework.homework22;

import myHomework.homework22.model.Employee;

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

    public ControlJDBC(String connection, String user, String pass) throws SQLException {
        this.connection = DriverManager.getConnection(connection, user, pass);
    }

    public int createCompany(String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlInsertCompany, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, name);
        statement.executeUpdate();

        ResultSet key = statement.getGeneratedKeys();
        key.next();
        return key.getInt(1);
    }

    public int createEmployee(String firstName, String lastName, String middleName,
                              String mail, String phone, String birthdate, Integer companyId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlInsertEmployee, Statement.RETURN_GENERATED_KEYS);

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
        statement.setString(4, mail);
        statement.setString(5, phone);
        statement.setDate(6, new java.sql.Date(date.getTime()));
        statement.setInt(7, companyId);
        statement.executeUpdate();
        ResultSet key = statement.getGeneratedKeys();
        key.next();
        return key.getInt(1);
    }

    public Employee selectEmployeeInfo(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlSelectGetById);
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
    }

    public void deleteEmp(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlDeleteEmpById);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public void deleteComp(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sqlDeleteCompById);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public void close() throws SQLException {
        connection.close();
    }
}
