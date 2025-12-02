package repository;

import entity.User;
import repository.base.AbstractCrudRepository;
import util.ApplicationContext;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.List;

public class UserRepository extends AbstractCrudRepository {

    public UserRepository(Connection connection) {
        super(connection);
    }

    public void save(User user) {
        try {

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO login_info (USERNAME, PASSWORD) VALUES (? , ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.execute();
            ResultSet getId = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected Object getEntity(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public String getTableName() {
        return "login_info";
    }

    @Override
    public void save(Object object) {

    }

    @Override
    public List<Object> findAll(String column) {
        return List.of();
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }
}
