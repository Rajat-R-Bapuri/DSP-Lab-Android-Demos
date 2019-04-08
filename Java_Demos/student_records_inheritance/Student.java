public class Student{

    // class attributes
    // it is good practice to keep the class attributes as private 
    // and use constructors, getter and setter methods to initialize and update values

    private int student_id;
    private String student_name;

    // constructor without arguments
    public Student(){
        this.student_id = 10;
        this.student_name = "Newton";
    }

    // setter methods
    public void set_student_id(int id){
        this.student_id = id;
    }

    public void set_student_name(String name){
        this.student_name = name;
    }

    // getter methods
    public int get_student_id(){
        return this.student_id;
    }

    public String get_student_name(){
        return this.student_name;
    }

    public void printSudentDetails(){
        System.out.println("Student details --> Id: " + this.get_student_id() + 
        "\t Name: " + this.get_student_name());
    }
}