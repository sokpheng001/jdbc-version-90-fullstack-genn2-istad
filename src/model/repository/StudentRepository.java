package model.repository;

import model.entities.Student;

import java.util.ArrayList;
import java.util.List;

// dao
public class StudentRepository {
    // use List<Student> as database to store students' data
    private List<Student> students = new ArrayList<>();
    public List<Student> findAll(){
        return this.students;
    }
    public Student save(Student student){
        students.add(student);
        return student;
    }
    public Student findById(Integer id){
        return this.students.stream()
                .filter(s->s.getId().equals(id))
                .findFirst().get();
    }
    public int delete(Student student){
        students.remove(student);
        return 1;
    }
    public Student update(Student student){
        // ...
        return null;
    }
}
