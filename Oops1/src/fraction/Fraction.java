package fraction;

public class Fraction {

	int denominator;
	int numerator;

	public Fraction (int numerator, int denominator) {
		if(denominator==0) {
			return;
		}
		this.numerator=numerator;
		this.denominator=denominator;
		this.simplify();

	}

	private void simplify() {

		int gcd=1;
		int small= Math.min(numerator, denominator);

		for(int i=2; i<=small; i++) {
			if(numerator%i==0 && denominator%i==0) {
				gcd=i;
			}
		}
		numerator=numerator/gcd;
		denominator=denominator/gcd;
	}

	public void setNumerator(int numerator) {

		this.numerator=numerator;
		simplify();

	}
	public void setDenominator(int denominator) {
		if(denominator==0) {
			return;
		}
		this.denominator=denominator;
		simplify();

	}


	public void print() {

		System.out.println(numerator+"/"+denominator);

	}

	public void increment() {

		numerator=numerator+denominator;
		simplify();

	}

	public void add(Fraction f2) {

		this.numerator=this.numerator*f2.denominator+this.denominator*f2.numerator;
		this.denominator=this.denominator*f2.denominator;
		simplify();
	}
	public Fraction addAndReturn(Fraction f2) {

		int newnumerator=this.numerator*f2.denominator+this.denominator*f2.numerator;
		int newdenominator=this.denominator*f2.denominator;
		Fraction f3= new Fraction(newnumerator, newdenominator);
		return f3;
	}
	

	public static Fraction add(Fraction f1, Fraction f2) {
		
		int newnumerator=f1.numerator*f2.denominator+f1.denominator*f2.numerator;
		int newdenominator=f1.denominator*f2.denominator;
		Fraction f3= new Fraction(newnumerator, newdenominator);
		return f3;
	}

}


