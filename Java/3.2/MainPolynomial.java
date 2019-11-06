import java.util.Arrays;

class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = getDegree(); i >= 0; i--) {
            output += coeffs[i];
            if (i == 1)
                output += "x + ";
            else if (i == 0)
                output += "";
            else
                output += "x^" + i + " + ";
        }
        return output;
    }

    public double evaluate(double x) {
        double y = 0;
        for (int i = getDegree(); i >= 0; i--)
            y += coeffs[i] * Math.pow(x, i);
        return y;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] pol;
        if (this.getDegree() >= right.getDegree()) {
            pol = this.coeffs;
            for (int i = this.getDegree() - right.getDegree(), j = 0; j <= right.getDegree(); i++, j++)
                pol[i] += right.coeffs[j];
        }
        else {
            pol = right.coeffs;
            for (int i = right.getDegree() - this.getDegree(), j = 0 ; j <= this.getDegree(); i++, j++)
                pol[i] += this.coeffs[j];
        }
        return new MyPolynomial(pol);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] pol;
        if (this.getDegree() >= right.getDegree()) {
            pol = this.coeffs;
            for (int i = this.getDegree() - right.getDegree(), j = 0 ; j <= right.getDegree(); i++, j++)
                pol[i] *= right.coeffs[j];
        }
        else {
            pol = right.coeffs;
            for (int i = right.getDegree() - this.getDegree(), j = 0 ; j <= this.getDegree(); i++, j++)
                pol[i] *= this.coeffs[j];
        }
        return new MyPolynomial(pol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }
}

public class MainPolynomial {
    public static void main(String[] args) {
        MyPolynomial polynomial1 = new MyPolynomial(4,8,6,3,2);
        MyPolynomial polynomial2 = new MyPolynomial(10,2,4);
        System.out.println(polynomial1);
        System.out.println(polynomial2);
        System.out.println("Degree: 1 - " + polynomial1.getDegree() + ", 2 - " + polynomial2.getDegree()); // 4
        MyPolynomial polynomial3 = polynomial1.add(polynomial2);
        System.out.println(polynomial3);
        MyPolynomial polynomial4 = polynomial1.multiply(polynomial2);
        System.out.println(polynomial4);

        System.out.println();
        System.out.println("hashcode polynomial1 --> " + polynomial1.hashCode());
        System.out.println("hashcode polynomial2 --> " + polynomial2.hashCode());
        System.out.println(polynomial1.equals(polynomial2));
    }
}
