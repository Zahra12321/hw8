package repository.base;

import java.util.List;

public interface CrudRepository {
    Object findBy(String column, Object value);

    Object save(Object object);
}
