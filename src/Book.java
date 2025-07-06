public class Book {
    private String bookId;
    private String bookTitle;
    private String authorName;
    private boolean isAvailable; //  True --> Available && False --> Not Available



    public Book(String bookId, String bookTitle, String authorName){
        this.bookId = bookId.toLowerCase();
        this.bookTitle = bookTitle.toLowerCase();
        this.authorName = authorName.toLowerCase();
        this.isAvailable = true;
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void showDetails(){
        System.out.println("-------------------------------");
        System.out.format("Book Id : %s\n", this.bookId);
        System.out.format("Book Title : %s\n", this.bookTitle);
        System.out.format("Author Name : %s\n", this.getAuthorName());
        System.out.format("Status : %s\n", this.isAvailable ? "Available" : "Not Available");
        System.out.println("-------------------------------");
    }


}
