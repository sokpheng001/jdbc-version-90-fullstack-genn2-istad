package view;

import controller.StudentController;
import model.dto.StudentCreateDto;
import model.dto.StudentResponseDto;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UI {
    private static StudentController studentController
             = new StudentController();
    private static StudentCreateDto insertStudentData(){
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
        return new StudentCreateDto(name,email,pass,bod);
    }

    private static void tableDisplay(List<StudentResponseDto> students){
        Table table = new Table(6, BorderStyle.CLASSIC);
        String [] columns = {"UUID","NAME","EMAIL","PROFILE","CARD_ID","BIRTH_OF_DATE"};
        for(String col: columns){
            table.addCell(col,new CellStyle(CellStyle.HorizontalAlign.center));
        }
        // add data
        for(StudentResponseDto s: students){
            table.addCell(s.uuid(),new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(s.userName(),new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(s.email(),new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(s.profile(),new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(s.cardId(),new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(s.birthOfDate().toString(),new CellStyle(CellStyle.HorizontalAlign.center));
        }
        System.out.println(table.render());
    }
    private static void thumbnail(){
        System.out.println("""
                ============== Student Management ===============
                1. Create Student
                2. Search Student by UUID
                3. Update Student by UUID
                4. Delete Student by UUID
                5. View All Students
                0. Exit
                """);
    }
    private static void pressEnterToContinue(){
        System.out.print(">> Press Enter to continue...");
        new Scanner(System.in).nextLine();
    }
    public static void getUI(){
        while (true){
            thumbnail();
            System.out.print("[+] Insert option: ");
            int opt = new Scanner(System.in).nextInt();
            switch (opt){
                case 1 ->{
                    StudentResponseDto studentResponseDto
                            = studentController.createNewStudent(insertStudentData());
                    tableDisplay(List.of(studentResponseDto));
                    pressEnterToContinue();
                }
                case 2->{
                    System.out.print("[+] Insert student's UUID: ");
                    String uuid = new Scanner(System.in).nextLine();
                    tableDisplay(List.of(studentController.getByUuid(uuid)));
                    pressEnterToContinue();
                }
                case 5->{
                    tableDisplay(studentController.getAllStudents());
                    pressEnterToContinue();
                }
                default -> {
                    System.out.println("Invalid option");
                }
            }
        }
    }
}
