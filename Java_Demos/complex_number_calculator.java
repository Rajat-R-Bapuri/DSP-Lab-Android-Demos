class complex extends ComplexNumberOperations{ // notice the use of implements keyword

    // attributes of class complex
    private int real, imaginary;

    // constructor of the class complex
    public complex(int r, int i){
        real = r;
        imaginary = i;
    }

    // getter methods
    public int get_real(){
        return this.real;
    }

    public int get_imaginary(){
        return this.imaginary;
    }

    // setter methods
    public void set_real(int r){
        this.real = r;
    }

    public void set_imaginary(int i){
        this.imaginary = i;
    }

    // methods to return complex number in form of string
    public String complex_number_string(){
        return this.real + " + " + this.imaginary + "i";
    }

    // implement the subtract method which was abstract in ComplexNumberOperations
    public complex subtract(complex a, complex b){
        complex c = new complex(0, 0);
        c.set_real(a.get_real() - b.get_real());
        c.set_imaginary(a.get_imaginary() - b.get_imaginary());
        return c;
    }
}

abstract class ComplexNumberOperations implements ComplexCalculator{
        // implementing the interface ComplexCalculator 
        public complex add(complex a, complex b){
            complex c = new complex(0, 0);
            c.set_real(a.get_real() + b.get_real());
            c.set_imaginary(a.get_imaginary() + b.get_imaginary());
            return c;
        }
    
        abstract public complex subtract(complex a, complex b);
}

interface ComplexCalculator{
    
    // method signatures to perform operations on complex numbers
    complex add(complex a, complex b);

    complex subtract(complex a, complex b);

    // interfaces can contain constants
    float pi = 3.14f;
}

public class complex_number_calculator {

    public static void main(String[] args) {
        // create two complex numbers
        complex x = new complex(1, 2);
        complex y = new complex(3, 4);
    
        // perform operations on complex numbers
        complex z = new complex(0, 0);
        z = z.subtract(x, y);
        
        System.out.println("Subtraction of "+ x.complex_number_string() + " and " + 
        y.complex_number_string() + " is " + z.complex_number_string());

        // similarly addition can be performed
    }
}