public class mainClass extends Student{ // use extends keyword to inherit from a class
    public static void main(String[] args){

        // create a object of mainClass 
        mainClass sc = new mainClass();

        // all the methods are inherited to the subclass which can be called using the subclass object
        sc.printSudentDetails();

        // call the superclass methods using subclass object
        sc.set_student_name("Issac");

        sc.printSudentDetails();

        int id = sc.get_student_id();

        // play around with this code by writing more lines and adding more methods
    }
}