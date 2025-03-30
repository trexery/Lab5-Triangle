package ee.ut.cs.swt.triangle;
public class Triangle {
	private int side1;

	private int side2;

	private int side3;

	private static final String P_EQUILATERAL = "equilateral";

	private static final String P_ISOSCELES = "isossceles";

	private static final String P_RIGHTANGLED = "right-angled";

	private static final String P_SCALENE = "scalene";

	private static final String P_IMPOSSIBLE = "impossible";

	public Triangle(int s1, int s2, int s3) {
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
	}

	public Triangle setSideLengths(int s1, int s2, int s3) {
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
		return this;
	}

	public String getSideLengths() {
		return String.valueOf(this.side1) + "," + this.side2 + "," + this.side3;
	}

	public int getPerimeter() {
		return this.side1 + this.side2 + this.side3;
	}

	public double getArea() {
		if (!isImpossible())
			return Math.sqrt((getPerimeter() /
					2 * (
					getPerimeter() / 2 - this.side1) * (
					getPerimeter() / 2 - this.side2) * (
					getPerimeter() / 2 - this.side3)));
		return -1.0D;
	}

	public String classify() {
		if (isImpossible())
			return "impossible";
		if (this.side1 == this.side2) {
			if (this.side2 == this.side3)
				return "equilateral";
			return "isossceles";
		}
		if (isRightAngled())
			return "right-angled";
		return "scalene";
	}

	public boolean isIsosceles() {
		if (this.side1 == this.side2 || this.side2 == this.side3 || this.side1 == this.side3)
			return true;
		return false;
	}

	public boolean isEquilateral() {
		if (this.side1 == this.side3)
			return true;
		return false;
	}

	public boolean isRightAngled() {
		int[] sides = {this.side1, this.side2, this.side3};
		return (sides[2] ==
				Math.sqrt((sides[0] * sides[0] + sides[1] * sides[1])));
	}

	public boolean isScalene() {
		if (this.side1 != this.side2 && this.side1 != this.side3 && this.side2 != this.side3)
			return true;
		return false;
	}

	public boolean isImpossible() {
		if (this.side1 <= 0 || this.side2 <= 0 || this.side3 <= 0)
			return true;
		return false;

	}
}