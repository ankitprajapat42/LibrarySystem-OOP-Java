import java.util.ArrayList;


public class Library {
    private String name;
    private String mobileNo;
    private String address;
    private String ownerName;
    private ArrayList<Book> booksList;
    private ArrayList<Student> studentList;
    private ArrayList<IssueBook> issueBooksList;

    public Library(String name, String mobileNo, String ownerName){
        this.name = name;
        this.mobileNo = mobileNo;
        this.ownerName = ownerName;
        this.booksList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.issueBooksList = new ArrayList<>();
        this.address = "";

    }


    public void addNewBook(Book book){
        if (book!=null){
            booksList.add(book);
            System.out.println("Book Add Successfully.");
        }
    }

    public Book removeBook(String bookId){
        if(booksList.isEmpty()){
            System.out.println("No Books Are Available");
            return null;
        }

        for (Book book: booksList){
            if (bookId.equals(book.getBookId())){
                booksList.remove(book);
                System.out.println("Book Remove Successfully.");
                return book;
            }
        }
        return null;
    }

    public void addStudent(Student student){
        if(student!=null) {
            studentList.add(student);
        }
    }

    public Student removeStudent(String libraryId){
        if(studentList.isEmpty()){
            System.out.println("No Students Are Registered");
            return null;
        }

        for (Student student : studentList) {
            if (libraryId.equals(student.getLibraryId())) {
                studentList.remove(student);
                System.out.format("Student: %s Remove Successfully.", student.getName());
                return student;
            }

        }
        return null;
    }

    public void showAllBook(){
        if (booksList.isEmpty()){
            System.out.println("No Books Are Available");
        }else {
            for (Book book : booksList) {
                book.showDetails();
            }
        }
    }

    public Book searchBook(String bookId_or_authorName){
        if (booksList.isEmpty()){
            System.out.println("No Book Are Available");
            return null;
        }

        for (Book book:booksList){
            if (bookId_or_authorName.toLowerCase().equals(book.getBookId()) || bookId_or_authorName.toLowerCase().equals(book.getAuthorName())){
                return book;
            }
        }
        return null;
    }

    public Student searchStudent(String libraryId){
        if (studentList.isEmpty()){
            System.out.println("No Student Are Register");
            return null;
        }

        for (Student student: studentList){
            if (libraryId.toLowerCase().equals(student.getLibraryId())){
                return student;
            }
        }
        return null;

    }

    public void issueBook(String bookId, String libraryId, int returnDuration){
        Book book = searchBook(bookId);
        if(book!=null){
            Student student = searchStudent(libraryId);
            if(student != null){
                IssueBook issueBook = new IssueBook(book, student, returnDuration);
                issueBooksList.add(issueBook); // add Record
                book.setAvailable(false); // Update Status
                System.out.format("Book (Id: %s) is Successfully Issued Student (Id: %s)\n", book.getBookId(), student.getLibraryId());

            }else {
                System.out.println("Library Id is Invalid");
            }
        }else {
            System.out.println("Book Id is Invalid");

        }
    }

    public boolean returnBook(String bookId, String libraryId){
        if (issueBooksList.isEmpty()){
            System.out.println("No Book has been Issued");
            return false;
        }

        for (IssueBook issueBook:issueBooksList){
            if (bookId.equals(issueBook.getBook().getBookId()) && libraryId.equals(issueBook.getStudent().getLibraryId())){
                issueBook.getBook().setAvailable(true);
                issueBooksList.remove(issueBook);
                System.out.println("Book Return Successfully");
                return true;
            }
        }
        System.out.println("No matching issue record found.");
        return false;
    }


    public int getTotalNumberOfIssuedBook(){
        return issueBooksList.size();
    }

    public int getTotalNumberOfBooks(){
        return booksList.size();
    }

    public int getTotalNumberOfStudent(){
        return studentList.size();
    }

    public void showDetails(){
        System.out.println("------------------------------------------");
        System.out.format("Library Name : %s\n", this.name);
        System.out.format("Owner Name : %s\n", this.ownerName);
        System.out.format("Mobile No.: +91-%s\n", this.mobileNo);
        System.out.format("address : %s\n", this.address);
        System.out.println("------------------------------------------");

    }

    public void dashboard(){
        System.out.println("--------------------------------------------");
        System.out.println("----------------- Dashboard ----------------");
        System.out.format("Total No. of Student : %d\n", getTotalNumberOfStudent());
        System.out.format("Total No. of Book : %d\n", getTotalNumberOfBooks());
        System.out.format("Total No. of Issue Book : %d\n", getTotalNumberOfIssuedBook());
        System.out.println("--------------------------------------------");

    }


    public void showAllStudent(){
        if (studentList.isEmpty()){
            System.out.println("No Students Are Available");
        }else {
            for (Student student: studentList) {
                student.showDetails();
            }
        }
    }

    public void showAllIssuedBook(){
        if (issueBooksList.isEmpty()){
            System.out.println("No Issued Books Are Available");
        }else {
            for (IssueBook issueBook: issueBooksList) {
                issueBook.showDetails();
            }
        }
    }

    public boolean updateBookTitle(String bookId, String bookTitle){
        if (booksList.isEmpty()){
            System.out.println("No Book are Available");
            return false;
        }
        Book book = searchBook(bookId);
        if(book!=null){
            book.setBookTitle(bookTitle);
            System.out.println("Update Book Title Successfully");
            return true;
        }
        return false;
    }

    public boolean updateBookAuthorName(String bookId, String bookAuthorName){
        if (booksList.isEmpty()){
            System.out.println("No Book are Available");
            return false;
        }
        Book book = searchBook(bookId);
        if(book!=null){
            book.setAuthorName(bookAuthorName);
            System.out.println("Update Book Author Name Successfully");
            return true;
        }
        return false;
    }

    public boolean updateStudentMobileNo(String libraryId, String mobileNo){
        if (studentList.isEmpty()){
            System.out.println("No Student Are Available");
            return false;
        }

        Student student = searchStudent(libraryId);
        if (student!=null){
            student.setMobileNo(mobileNo);
            System.out.println("Update Student Mobile No. Successfully");
            return true;
        }
        return false;
    }


    public boolean updateStudentEmail(String libraryId, String email){
        if (studentList.isEmpty()){
            System.out.println("No Student Are Available");
            return false;
        }

        Student student = searchStudent(libraryId);
        if (student!=null){
            student.setEmail(email);
            System.out.println("Update Student Email Successfully");
            return true;
        }
        return false;
    }



}
