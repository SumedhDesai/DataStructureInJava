package complexnumber;

public class ComplexNumbers {
	
	int real;
	int imaginary;
	
	public ComplexNumbers(int real, int imaginary) {
		
		this.real=real;
		this.imaginary=imaginary;
		
	}
	
	public void print() {
		
		System.out.println(real+" "+"+"+" "+"i"+imaginary);
		
	}
	
	public void plus(ComplexNumbers c2) {
		
		this.real=this.real+c2.real;
		this.imaginary=this.imaginary+c2.imaginary;
		
	}
	
	public void multiply(ComplexNumbers c2) {
		
		int newreal=(this.real*c2.real)-(this.imaginary*c2.imaginary);
		int newimaginary=(this.real*c2.imaginary)+(this.imaginary*c2.real);
		
		this.real=newreal;
		this.imaginary=newimaginary;
	}

}
