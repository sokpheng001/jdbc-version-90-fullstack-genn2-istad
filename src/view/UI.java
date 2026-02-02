package view;

import controller.StudentController;
import model.dto.StudentCreateDto;
import model.dto.StudentResponseDto;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

public class UI {
    private static StudentController studentController
             = new StudentController();
    private static void thumbnail(){
        System.out.println("""
                ============== Student Management ===============
                1. Create Student
                2. Search Student by UUID
                3. Update Student by UUID
                4. Delete Student by UUID
                5. Exit
                """);
    }
    public static void getUI(){
        thumbnail();
        System.out.print("[+] Insert option: ");
        int opt = new Scanner(System.in).nextInt();
        switch (opt){
            case 1 ->{
                System.out.println("[+] Create user feature");
                System.out.print("[+] Insert student's name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("[+] Insert student's email: ");
                String email = new Scanner(System.in).nextLine();
                System.out.print("[+] Insert student's password: ");
                String pass = new Scanner(System.in).nextLine();
                System.out.println("[+] Insert birth of date: YYY-MMM-DD");
                System.out.print("[+] Insert year: ");
                Integer year = new Scanner(System.in).nextInt();
                System.out.print("[+] Insert month: ");
                Integer month = new Scanner(System.in).nextInt();
                System.out.print("[+] Insert day: ");
                Integer day = new Scanner(System.in).nextInt();
                LocalDate bod = LocalDate.of(year,month,day);
                StudentCreateDto studentCreateDto
                         = new StudentCreateDto(name,email,pass,bod);
                StudentResponseDto studentResponseDto
                 = studentController.createNewStudent(studentCreateDto);
                System.out.println(studentResponseDto);
            }
            default -> {
                System.out.println("Invalid option");
            }
        }
    }
}
