package controller;

import model.dto.StudentCreateDto;
import model.dto.StudentResponseDto;
import model.service.StudentService;
import model.service.StudentServiceImpl;

public class StudentController {
    private StudentService studentService
            = new StudentServiceImpl();
    public StudentResponseDto createNewStudent(
            StudentCreateDto studentCreateDto
    ){
        return studentService.createStudent(studentCreateDto);
    }
}
