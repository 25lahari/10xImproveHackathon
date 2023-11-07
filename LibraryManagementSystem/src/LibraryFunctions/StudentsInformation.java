package LibraryFunctions;
import java.util.*;
public class StudentsInformation {
    Scanner input = new Scanner(System.in);
    StudentDetails theStudents[] = new StudentDetails[50];
    public static int count = 0;
    public void addStudent(StudentDetails s)
    {
        for (int i = 0; i < count; i++) {

            if (s.regNum.equalsIgnoreCase(
                    theStudents[i].regNum)) {
                System.out.println("Student of Reg Num " + s.regNum + " is Already Registered.");
                return;
            }
        }
        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }
    public void showAllStudents()
    {
        System.out.println("Student_Name\t\tReg Number\t\t\tReg Date");
        for (int i = 0; i < count; i++) {

            System.out.println(theStudents[i].studentName + "\t\t\t\t" + theStudents[i].regNum
                    + "\t\t\t\t\t" + theStudents[i].regDate);
        }
    }
    public int isStudent()
    {
        System.out.println("Enter Reg Number:");

        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {

            if (theStudents[i].regNum.equalsIgnoreCase(regNum)) {
                return i;
            }
        }

        // Print statements
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

    public void checkOutBook(BooksInformation book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println("checking out");
            book.showAllBooks();
            BookDetails b = book.checkOutBook();
            System.out.println("checking out");
            if (b != null) {
                if (theStudents[studentIndex].booksCount <= 3) {
                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
                    theStudents[studentIndex].booksCount++;
                    return;
                }
                else {
                    System.out.println("Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }
    public void checkInBook(BooksInformation book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
            StudentDetails s = theStudents[studentIndex];
            for (int i = 0; i < s.booksCount; i++) {
                System.out.println(
                        s.borrowedBooks[i].sNo + "\t\t\t"
                                + s.borrowedBooks[i].bookName + "\t\t\t"
                                + s.borrowedBooks[i].authorName);
            }
            System.out.println("Enter Serial Number of Book to be Checked In:");
            int sNo = input.nextInt();
            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                }
            }
            System.out.println("Book of Serial No " + sNo + "not Found");
        }
    }
}
