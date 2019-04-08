public class mainClass{
    public static void main(String[] args){
        Student s1 = new Student(); // use new keyword to create an object of class Student
        Student s2 = new Student(10, "Some Name");
        Student s3 = new Student(11);

        // manipulate the default values using the setter methods of the class
        s1.set_student_id(12);
        s1.set_student_name("Some Name 2");

        // access the attributes using the getter methods
        System.out.println("Student 1 details --> Id: " + s1.get_student_id() + 
        "\t Name: " + s1.get_student_name());

        // play around with this code by writing more lines and adding more methods
    }
}