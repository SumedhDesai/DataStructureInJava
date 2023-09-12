
public class Student implements Ineterface {
	int roll;

	public Student(int roll) {
		this.roll = roll;
	}

	@Override
	public void print() {
		System.out.print(this.roll+" ");
	}
}
