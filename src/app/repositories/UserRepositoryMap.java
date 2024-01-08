package app.repositories;

import app.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserRepositoryMap implements UserRepository{

    private Map<Integer, User> users = new HashMap<>();
    private int currentId;

    @Override
    public void save(User entity) {
        entity.setId(++currentId);
        users.put(currentId, entity);
    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
