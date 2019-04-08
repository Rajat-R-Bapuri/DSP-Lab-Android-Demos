public class Student{

    // class attributes
    // it is good practice to keep the class attributes as private 
    // and use constructors, getter and setter methods to initialize and update values

    private int student_id;
    private String student_name;

    //  there can be multiple constructors in a class
    // if no constructor is written, the compiler automatically provides a no argument default constructor 
    // which initializes the attributes to default values
    // but it is good practice to have your own constructor

    // constructors are called when the Student class object is created
    public Student(){
        this.student_id = 0;
        this.student_name = null;
    }

    // constructor with arguments
    public Student(int id, String name){
        this.student_id = id;
        this.student_name = name;
    }

    // constructor with single argument
    public Student(int id){
        this.student_id = id;
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
}