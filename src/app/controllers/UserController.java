package app.controllers;

import app.domain.User;
import app.services.UserService;

import java.util.Scanner;

public class UserController {
    private Scanner scanner;
    private UserService service;

    public UserController(Scanner scanner, UserService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void addUser() {
        System.out.println("Введите email");
        String email = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        service.addUser(email, password);
    }

    public void getUserById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите идентификатор пользователя: ");
        int userId = scanner.nextInt();
        User user = service.getUserById(userId);

        if (user != null) {
            System.out.println("Пользователь найден: " + user);
        } else {
            System.out.println("Вы ввели некорректный идентификатор");
        }
    }

    public void getAllUsers() {
        System.out.println( service.getAllUsers());
    }


    //TODO реализовать метод получения одного пользователя из БД
    //TODO (идентификатор нужно запросить у клиента через консоль)
    //TODO реализовать метод получения всех пользователей
    //TODO Оба эти метода должны просто выводить результат в консоль
}
