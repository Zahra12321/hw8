package repository;

import repository.base.AbstractCrudRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class CardRepository extends AbstractCrudRepository {

    public CardRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected Object getEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    public String getTableName() {
        return "";
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
