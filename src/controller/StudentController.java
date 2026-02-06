package controller;

import model.dto.StudentCreateDto;
import model.dto.StudentResponseDto;
import model.service.StudentService;
import model.service.StudentServiceImpl;

import java.util.List;

public class StudentController {
    private StudentService studentService
            = new StudentServiceImpl();
    public StudentResponseDto createNewStudent(
            StudentCreateDto studentCreateDto
    ){
        return studentService.createStudent(studentCreateDto);
    }
    public List<StudentResponseDto> getAllStudents(){
        return studentService.getAllStudents();
    }
    public StudentResponseDto getByUuid(String uuid){
        return studentService.searchByUuid(uuid);
    }
    public String deleteByUuid(String uuid){
        return studentService.deleteStudentByUuid(uuid);
    }
}
