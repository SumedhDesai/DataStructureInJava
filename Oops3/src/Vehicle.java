
public class Vehicle implements Ineterface {
	
	private String colour;
	
	public void setColour(String colour) {
		this.colour=colour;
	}
	public String getColour() {
		return colour;
	}
	@Override
	public void print() {
		System.out.print(this.colour+" ");
	}

}
