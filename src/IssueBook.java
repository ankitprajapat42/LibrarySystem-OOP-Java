import java.time.LocalDate;

public class IssueBook {
    private Book book;
    private Student student;
    private String date;
    private int returnduration; // in Month


    public IssueBook(Book book, Student student, int returnduration){
        this.book = book;
        this.student = student;
        this.date = LocalDate.now().toString();
        this.returnduration = returnduration;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getReturnduration() {
        return returnduration;
    }

    public void setReturnduration(int returnduration) {
        this.returnduration = returnduration;
    }

    public void showDetails(){
        System.out.println("-----------------------------------");
        System.out.format("Issue Date : %s\n",this.date);
        System.out.format("Return Duration : %d Months\n", this.returnduration);
        System.out.println("Book Detail:-");
        System.out.format("Book Id : %s\n", this.book.getBookId());
        System.out.format("Book Title : %s\n", this.book.getBookTitle());
        System.out.format("Author Name : %s\n", this.book.getAuthorName());
        System.out.println("Student Detail :-");
        System.out.format("Library Id : %s\n", this.student.getLibraryId());
        System.out.format("Student Name : %s\n", this.student.getName());
        System.out.format("Mobil No. : +91-%s\n", this.student.getMobileNo());
        System.out.println("-----------------------------------");

    }


}
