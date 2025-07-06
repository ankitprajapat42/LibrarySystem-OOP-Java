public class Student {
    private String libraryId;
    private String name;
    private String mobileNo;
    private String email;

    public Student(String libraryId, String name, String mobileNo, String email){
        this.libraryId = libraryId.toLowerCase();
        this.name = name.toLowerCase();
        if (!isValidMobile(mobileNo)) {
            throw new IllegalArgumentException("Mobile number must be 10 digits.");
        }

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        this.mobileNo = mobileNo;
        this.email=email.toLowerCase();
    }


    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        if (isValidMobile(mobileNo)) {
            this.mobileNo = mobileNo;
        } else {
            System.out.println("Mobile number must be 10 digits.");
        }
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email.toLowerCase();
        } else {
            System.out.println("Invalid email format.");
        }
    }

    public void showDetails(){
        System.out.println("-----------------------------------");
        System.out.format("Library Id : %s\n", this.libraryId);
        System.out.format("Student Name : %s\n", this.name);
        System.out.format("Mobile No.: +91-%s\n", this.mobileNo);
        System.out.format("Email : %s\n", this.email);
        System.out.println("-----------------------------------");
    }

    // Validation helper methods
    private boolean isValidMobile(String mobile) {
        return mobile != null && mobile.matches("\\d{10}");
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}");
    }


}
