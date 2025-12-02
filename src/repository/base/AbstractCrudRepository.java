package repository.base;

import java.sql.*;

public abstract class AbstractCrudRepository implements CrudRepository {

    protected final Connection connection;
    private PreparedStatement findByIdStatement;

    public AbstractCrudRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object findBy(String column, Object value) {
        try {
            //PreparedStatement statement = getFindByIdStatement();
            PreparedStatement statement = connection.prepareStatement("select * from " + getTableName() + " where " + column + " = ?");
            statement.setObject(1, value);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getEntity(resultSet);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*protected PreparedStatement getFindByIdStatement() {
        if (findByIdStatement == null) {
            try {
                findByIdStatement = connection.prepareStatement("select * from " + getTableName() + " where id = ?");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return findByIdStatement;
    }*/

    protected abstract Object getEntity(ResultSet resultSet);

    public abstract String getTableName();

}
