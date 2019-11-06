import java.util.Objects;

import static java.lang.Math.*;

class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        setReal(real);
        setImag(imag);
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }

    public boolean isReal() {
        return real != 0;
    }

    public boolean isImaginary() {
        return  imag != 0;
    }

    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag;
    }

    public boolean equals(MyComplex another) {
        return real == another.getReal() && imag == another.getImag();
    }

    public double magnitude() {
        return sqrt(pow(real, 2) + pow(imag, 2));
    }

    public double argument() {
        if (real > 0)
            return atan(imag / real);
        else if (real < 0 && imag > 0)
            return atan(imag / real) + PI;
        else
            return atan(imag / real) - PI;
    }

    public MyComplex add(MyComplex right) {
        real += right.getReal();
        imag += right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(real + right.getReal(), imag + right.getImag());
    }

    public MyComplex subtract(MyComplex right) {
        real -= right.getReal();
        imag -= right.getImag();
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(real - right.getReal(), imag - right.getImag());
    }

    public MyComplex multiply(MyComplex right) {
        real = real * right.getReal() - imag * right.getImag();
        imag = real * right.getImag() - imag * right.getReal();
        return this;
    }

    public MyComplex divide(MyComplex right) {
        real = (real * right.getReal() + imag * right.getImag())
                / (pow(right.getReal(), 2) + pow(right.getImag(), 2));
        imag = (imag * right.getReal() + real * right.getImag())
                / (pow(right.getReal(), 2) + pow(right.getImag(), 2));
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return Double.compare(myComplex.real, real) == 0 &&
                Double.compare(myComplex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)(Double.doubleToLongBits(real) ^ (Double.doubleToLongBits(real) >>> 32));
        result = 31 * result + (int)(Double.doubleToLongBits(imag) ^ (Double.doubleToLongBits(imag) >>> 32));
        return result;
    }
}

public class MainComplex {
    public static void main(String[] args) {
        MyComplex complex1 = new MyComplex(2, 3.7);
        MyComplex complex2 = new MyComplex(3, 4.8);
        System.out.println(complex1.equals(2, 3.7));
        System.out.println(complex2.equals(complex1));
        System.out.println("magnitude = " + complex1.magnitude() + " and argument = "+ complex1.argument());
        System.out.println(complex2.add(complex1));
        MyComplex complex3 = complex2.addNew(complex2);
        System.out.println(complex3.toString());
        System.out.println(complex2.subtract(complex1));
        System.out.println(complex1.multiply(complex2));
        System.out.println(complex2.divide(complex3));

        System.out.println();
        System.out.println("hashcode complex1 --> " + complex1.hashCode());
        System.out.println("hashcode complex2 --> " + complex2.hashCode());
        System.out.println("hashcode complex3 --> " + complex3.hashCode());
        System.out.println(complex1.equals(complex2));
        System.out.println(complex3.equals(complex2));
    }
}