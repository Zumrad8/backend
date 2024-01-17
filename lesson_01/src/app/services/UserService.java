package app.services;

import app.domain.User;
import app.repositories.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(String email, String password) {


        //TODO проверка параметров на null и пустоту - домашнее задание
        if(email == null || email.isEmpty()) { // ""
            throw new IllegalArgumentException("Email не может быть пустым");
        }
        if(password == null || password.isEmpty()) { // ""
            throw new IllegalArgumentException("Password не может быть пустым");
        }

        if(!email.contains("@")){
            throw new IllegalArgumentException("Email must contain @");
        }

        for (User user : repository.findAll()) {
           if(email.equals(user.getEmail())){
               throw new IllegalArgumentException("Пользователем с таким именем уже зарегистрирован");
           }
        }

        // TODO проверить, не существует ли уже в БД пользователя с таким email

        User existedUser = repository.findByEmail(email);

        if(existedUser != null){
            throw new IllegalArgumentException("Email уже занят");
        }

        repository.save(new User(email, password));
    }
    public User getUserById(int userId){

//        if(userId > 0){
//           return repository.findById(userId);
//        } else {
//            throw new IllegalArgumentException("Некорректный идентификатор");
//        }

        User user = repository.findById(userId);
        if(user == null) {
            throw new NoSuchElementException("Пользователь не существует");
        }
        return user;
    }

    public List<User> getAllUsers(){
        //return repository.findAll();

        List<User> users = repository.findAll();

        if(users.isEmpty()){
            throw new NoSuchElementException("Список пользователей пуст");
        }
        return users;
    }

    //TODO реализовать методы по получению одного и всех пользователей
}
