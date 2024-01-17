package app.repositories;

import java.util.List;

//CRUD - Create Read Update Delete
public interface CrudRepository<T> {

    void save(T entity);

    T findById(int id);

    List<T> findAll();

    void update(T entity);

    void deleteById(int id);
}
