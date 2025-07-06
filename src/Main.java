    import java.util.Scanner;

    public class Main {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            Library library = new Library("Shayam Library", "9413812543", "Ankit prajapat");
            boolean system = true;
            while (system){
                System.out.println("============= Library Management System =============");
                library.dashboard();
                System.out.println("Press 1 for Add New Book\nPress 2 for Remove Book\nPress 3 for Add Student\nPress 4 for Remove Student\nPress 5 for Issue Book\nPress 6 for Return Book\nPress 7 for Show All Books\nPress 8 for Search Book\nPress 9 for Search Student  \nPress 10 Show Library Details\nPress 11Show Issue Books List\nPress 12 for Show All Students List\nPress 13 for Update Student Detail\nPress 14 for Update Book Detail\nPress 0 For Exit");
                String choice = scanner.next();
                scanner.nextLine();
                switch (choice){
                    case "1":
                        System.out.println("------------- Add New Book ------------- ");
                        System.out.print("Enter the BookId : ");
                        String bookId = scanner.nextLine();
                        System.out.print("Enter the Book Title : ");
                        String bookTitle = scanner.nextLine();
                        System.out.print("Enter the Author Name : ");
                        String authorName = scanner.nextLine();
                        Book book = new Book(bookId, bookTitle, authorName);
                        library.addNewBook(book);
                        break;

                    case "2":
                        System.out.println("--------------- Remove Book --------------- ");
                        System.out.print("Enter the BookId : ");
                        bookId = scanner.nextLine();
                        library.removeBook(bookId);
                        break;

                    case "3":
                        System.out.println("------------- Add New Student ------------- ");
                        System.out.print("Enter the Library Id : ");
                        String libraryId = scanner.nextLine();
                        System.out.print("Enter the Student Name : ");
                        String name = scanner.nextLine();
                        System.out.print("Enter the Mobile No.: ");
                        String mobileNo = scanner.nextLine();
                        System.out.print("Enter the Email.: ");
                        String email = scanner.nextLine();
                        Student student = new Student(libraryId, name, mobileNo, email);
                        library.addStudent(student);
                        break;

                    case "4":
                        System.out.println("--------------- Remove Student --------------- ");
                        System.out.print("Enter the Library Id : ");
                        libraryId = scanner.nextLine();
                        library.removeStudent(libraryId);
                        break;

                    case "5":
                        System.out.println("--------------- Issue Book --------------- ");
                        System.out.print("Enter the BookId : ");
                        bookId = scanner.nextLine();
                        System.out.print("Enter the LibraryId : ");
                        libraryId = scanner.nextLine();
                        System.out.print("Enter the Return Duration : ");
                        int returnDuration = scanner.nextInt();
                        scanner.nextLine();
                        library.issueBook(bookId, libraryId,returnDuration);
                        break;

                    case "6":
                        System.out.println("--------------- Return Book --------------- ");
                        System.out.print("Enter the BookId : ");
                        bookId = scanner.nextLine();
                        System.out.print("Enter the LibraryId : ");
                        libraryId = scanner.nextLine();
                        library.returnBook(bookId, libraryId);
                        break;

                    case "7":
                        System.out.println("---------------  Show All Books --------------- ");
                        library.showAllBook();
                        break;

                    case "8":
                        System.out.println("--------------- Search Book --------------- ");
                        System.out.print("Enter the BookId/Author Name : ");
                        String bookId_or_authorName = scanner.nextLine();
                        library.searchBook(bookId_or_authorName);
                        break;

                    case "9":
                        System.out.println("--------------- Search Student --------------- ");
                        System.out.print("Enter the Library ID : ");
                        libraryId = scanner.nextLine();
                        library.searchStudent(libraryId);
                        break;

                    case "10":
                        System.out.println("--------------- Show Library Details --------------- ");
                        library.showDetails();
                        break;

                    case "11":
                        System.out.println("--------------- All Issued BooKs Details --------------- ");
                        library.showAllIssuedBook();
                        break;
                    case "12":
                        System.out.println("--------------- All Students Details --------------- ");
                        library.showAllStudent();
                        break;

                    case "13":
                        System.out.println("--------------- Update Student Detail --------------- ");
                        boolean updateStudent = true;
                        while (updateStudent) {
                            System.out.println("Press 1 for Update Mobile No\nPress 2 for Update Email\nPress 0 for Exit");
                            choice = scanner.next();
                            scanner.nextLine();
                            switch (choice){
                                case "1":
                                    System.out.println("----------- Update Mobile No -----------");
                                    System.out.println("Enter the Student Library Id : ");
                                    libraryId = scanner.nextLine();
                                    System.out.println("Enter the Mobile No.: ");
                                    mobileNo = scanner.nextLine();
                                    library.updateStudentMobileNo(libraryId, mobileNo);
                                    break;
                                case "2":
                                    System.out.println("------------- Update Email ------------");
                                    System.out.println("Enter the Student Library Id : ");
                                    libraryId = scanner.nextLine();
                                    System.out.println("Enter the Email : ");
                                    email = scanner.nextLine();
                                    library.updateStudentEmail(libraryId, email);
                                    break;
                                case "0":
                                    updateStudent = false;
                                    break;
                                default:
                                    System.out.println("You Choose Invalid Option");
                            }
                        }
                        break;

                    case "14":
                        System.out.println("--------------- Update Book Detail --------------- ");
                        boolean updateBook = true;
                        while (updateBook){
                            System.out.println("Press 1 for Update Book Title\nPress 2 for Update Book Author Name\nPress 0 for Exit");
                            choice = scanner.next();
                            scanner.nextLine();
                            switch (choice){
                                case "1":
                                    System.out.println("------------- Update Title ------------");
                                    System.out.println("Enter the BookId : ");
                                    bookId = scanner.nextLine();
                                    System.out.println("Enter the Book Title : ");
                                    bookTitle = scanner.nextLine();
                                    library.updateBookTitle(bookId, bookTitle);
                                    break;
                                case "2":
                                    System.out.println("------------- Update Author ------------");
                                    System.out.println("Enter the BookId : ");
                                    bookId = scanner.nextLine();
                                    System.out.println("Enter the Book Author Name : ");
                                    String bookAuthorName = scanner.nextLine();
                                    library.updateBookAuthorName(bookId, bookAuthorName);
                                    break;
                                case "0":
                                    updateBook = false;
                                    break;
                                default:
                                    System.out.println("You Choose Invalid Option");

                            }
                        }

                        break;

                    case "0":
                        System.out.println("------------- Application Close -------------");
                        system=false;
                        break;
                    default:
                        System.out.println("You choose Incorrect Option");
                }

            }
        }

    }
