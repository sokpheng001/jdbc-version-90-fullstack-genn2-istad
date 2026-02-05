package model.repository;

import model.entities.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

// dao - data access object
public class StudentRepository {
    private final String dbUrl = "jdbc:postgresql://localhost:5432/school_db";
    private final String userName = "postgres";
    private final String password = "123";
    public List<Student> findAll(){
        String sql = """
                SELECT * FROM students;
                """;
        try(Connection connection = DriverManager.getConnection(
                dbUrl,userName,password
        )){
            System.out.println("Connected to database successfully");
        }catch (Exception exception){
            System.out.println("Error in fetching all students from database: " + exception.getMessage());
        }
        return null;
    }
    public Student save(Student student){

        return student;
    }
    public Student findById(Integer id){
        return null;
    }
    public int delete(Student student){

        return 1;
    }
    public Student update(Student student){
        // ...
        return null;
    }
}
