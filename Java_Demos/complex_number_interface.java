class complex implements ComplexCalculator{ // notice the use of implements keyword

    // attributes of class complex
    private int real, imaginary;

    // constructor of the class complex
    public complex(int r, int i){
        real = r;
        imaginary = i;
    }

    // implementing the interface ComplexCalculator 
    public complex add(complex a){
        complex c = new complex(0, 0);
        c.real = this.real + a.real;
        c.imaginary = this.imaginary + a.imaginary;
        return c;
    }

    public complex subtract(complex a){
        complex c = new complex(0, 0);
        c.real = this.real - a.real;
        c.imaginary = this.imaginary - a.imaginary;
        return c;
    }

    public String complex_number_string(){
        return this.real + " + " + this.imaginary + "i";
    }
}

interface ComplexCalculator{
    
    // method signatures to perform operations on complex numbers
    complex add(complex a);

    complex subtract(complex a);

    // interfaces can contain constants
    float pi = 3.14f;
}

public class complex_number_interface {

    public static void main(String[] args) {
        // create two complex numbers
        complex x = new complex(1, 2);
        complex y = new complex(3, 4);
    
        // perform operations on complex numbers
        complex z = x.add(y);
        
        System.out.println("Addition of "+ x.complex_number_string() + " and " + 
        y.complex_number_string() + " is " + z.complex_number_string());

        // similarly subtraction can be performed
    }
}