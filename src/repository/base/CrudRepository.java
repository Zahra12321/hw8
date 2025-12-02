package repository.base;

import java.util.List;

public interface CrudRepository {
    void save(Object object);

    Object findBy(String column, Object value);

    List<Object> findAll(String column);

    void deleteById(Integer id);

    long count();

    boolean existsById(Integer id);
}
