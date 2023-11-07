import LibraryFunctions.BookDetails;
import LibraryFunctions.BooksInformation;
import LibraryFunctions.StudentDetails;
import LibraryFunctions.StudentsInformation;

import java.util.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("********************Welcome to the BVRIT Library!********************");
        System.out.println("                  Select From The Following Options:               ");
        System.out.println("**********************************************************************");

        // Creating object of book class
        BooksInformation ob = new BooksInformation();
        StudentsInformation obStudent = new StudentsInformation();
        int choice;
        int searchChoice;
        do {

            ob.dispMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1: BookDetails b = new BookDetails();
                        ob.addBook(b);
                        break;
                case 2:
                        ob.upgradeBookQty();
                        break;
                case 3:
                    System.out.println(" press 1 to Search with Book Serial No.");
                    System.out.println(" Press 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();
                    switch (searchChoice) {
                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByAuthorName();
                    }
                    break;
                case 4:
                    ob.showAllBooks();
                    break;
                case 5:
                    StudentDetails s = new StudentDetails();
                    obStudent.addStudent(s);
                    break;
                case 6:
                    obStudent.showAllStudents();
                    break;
                case 7:
                    obStudent.checkOutBook(ob);
                    break;
                case 8:
                    obStudent.checkInBook(ob);
                    break;
                default:
                    System.out.println("ENTER BETWEEN 0 TO 8.");
            }

        }
        while (choice != 0);
    }
}


