package LibraryFunctions;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentDetails {

        String regDate;
        String studentName;
        String regNum;
        BookDetails borrowedBooks[] = new BookDetails[3];
        public int booksCount = 0;
        Scanner input = new Scanner(System.in);
        public StudentDetails()
        {
            System.out.println("Enter Student Name:");
            this.studentName = input.nextLine();
            System.out.println("Enter Registration Number:");
            this.regNum = input.nextLine();
            System.out.println("Enter Current Date:");
            this.regDate = input.nextLine();
            System.out.println("Successfully Registered!");

        }

}
