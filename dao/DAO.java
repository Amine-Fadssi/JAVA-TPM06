package tp06.dao;

import tp06.entities.Client;

import java.util.List;

public interface DAO<T, U> {
    void save(T o);
    void removeById(U id);
    List<T> getAll();
    void update(T o);
}
