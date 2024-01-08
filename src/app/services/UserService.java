package app.services;

import app.domain.User;
import app.repositories.UserRepository;

import java.util.List;
import java.util.Map;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(String email, String password) {

        //TODO проверка параметров на null и пустоту - домашнее задание

        if(!email.contains("@")){
            throw new IllegalArgumentException("Email must contain @");
        }

        for (User user : repository.findAll()) {
           if(email.equals(user.getEmail())){
               throw new IllegalArgumentException("Пользователем с таким именем уже зарегистрирован");
           }
        }

        // TODO проверить, не существует ли уже в БД пользователя с таким email

        repository.save(new User(email, password));
    }
    public User getUserById(int userId){

        if(userId > 0){
           return repository.findById(userId);
        } else {
            throw new IllegalArgumentException("Некорректный идентификатор");
        }
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    //TODO реализовать методы по получению одного и всех пользователей
}
