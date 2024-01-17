package de.aittr.g_31_2_rest.repositories;

import de.aittr.g_31_2_rest.domain.Parrot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class ParrotRepository implements CrudRepository<Parrot>{

    private final String DB_DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    private final String DB_ADDRESS = "jdbc:mysql://localhost:3306/";
    private final String DB_NAME = "31_2_parrots";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "zumrad1992";

    // Метод, который подключается к БД и возвращает объект подключения
    private Connection getConnection() {
        try {
            Class.forName(DB_DRIVER_PATH);
            // jdbc:mysql://localhost:3306/31_2_parrots?user=root&password=zumrad1992
            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_ADDRESS, DB_NAME, DB_USERNAME, DB_PASSWORD);
            return DriverManager.getConnection(dbUrl);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Parrot save(Parrot obj) {
        return null;
    }

    @Override
    public List<Parrot> getAll() {
        return null;
    }

    @Override
    public Parrot getById(int id) {
        return null;
    }

    @Override
    public void update(Parrot obj) {

    }

    @Override
    public void deleteById(int id) {

    }
}
