package polynomialclass;

public class Polynomial {

	int[] coeff;

	public Polynomial() {

		coeff=new int[10];

	}

	public void setCoefficient(int degree, int val) {
		if(degree>coeff.length-1) {
			int[] temp=coeff;
			coeff= new int[degree+1];

			for(int i=0; i<temp.length; i++) {
				coeff[i]=temp[i];
			}

		}

		coeff[degree]=val;

	}

	public void print() {

		for(int i=0; i<coeff.length; i++) {
			if(coeff[i]!=0) {
				System.out.print(coeff[i]+"x"+i+" ");
			}
		}
	}

	public Polynomial add(Polynomial sec) {
		int i;
		int p1=this.coeff.length;
		int p2=sec.coeff.length;
		int len=Math.min(p1, p2);
		
		Polynomial result = new Polynomial();

		for(i=0; i<len; i++) {
			result.setCoefficient(i,this.coeff[i]+sec.coeff[i]);
		}
		while(i<p1){
			result.setCoefficient(i,this.coeff[i]);
			i++;
		}
		while(i<p2) {
			result.setCoefficient(i,sec.coeff[i]);
			i++;
		}
		return result;
	}

	public Polynomial subtract(Polynomial sec) {
		int i;
		int p1=this.coeff.length;
		int p2=sec.coeff.length;
		int len=Math.min(p1, p2);
		
		Polynomial result = new Polynomial();

		for(i=0; i<len; i++) {
			result.setCoefficient(i,this.coeff[i]-sec.coeff[i]);
		}
		while(i<p1){
			result.setCoefficient(i,this.coeff[i]);
			i++;
		}
		while(i<p2) {
			result.setCoefficient(i,-sec.coeff[i]);
			i++;
		}
		return result;
	}

	public Polynomial multiply(Polynomial sec) {

		Polynomial result = new Polynomial();
		for(int i=0; i<this.coeff.length; i++) {
			for(int j=0; j<sec.coeff.length; j++) {
				int setDeg=i+j;
				int ansCoeff=this.coeff[i]*sec.coeff[j];
				int oldCoeff=result.getCoefficient(setDeg);
				result.setCoefficient(setDeg, ansCoeff+oldCoeff);
			}
		}
		return result;
	}

	private int getCoefficient(int degree) {
		if(degree<this.coeff.length) {
		return this.coeff[degree];
		}
		return 0;
	}
}
