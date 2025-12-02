package repository.base;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BaseEntity {

    protected final Connection connection;

    private PreparedStatement findByIdStatement;

    protected AbstractCrudRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public BaseDomain findById(Integer id) {
        try {
            PreparedStatement statement = getFindByIdStatement();
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                BaseDomain domain = getBaseDomain(resultSet);
                domain.setId(resultSet.getInt(1));
                return domain;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected PreparedStatement getFindByIdStatement() {
        if (findByIdStatement == null) {
            try {
                findByIdStatement = connection.prepareStatement("select * from " + getTableName() + " where id = ?");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return findByIdStatement;
    }

    protected abstract BaseDomain getBaseDomain(ResultSet resultSet);

    public abstract String getTableName();
     */
}
