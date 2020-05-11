package forms;

import java.util.Objects;

public class Triangle extends Form {
    private float height;
    private float base;

    public Triangle() {
        super();
        this.height = 0;
        this.base = 0;
    }

    public Triangle(String color, float height, float base) {
        super(color);
        this.height = height;
        this.base = base;
    }

    public void printTriangleDimensions(){

        System.out.println("inaltimea: " + this.height);
        System.out.println("baza: " + this.base);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Float.compare(triangle.height, height) == 0 &&
                Float.compare(triangle.base, base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, base);
    }

    @Override
    public float getArea() {
        return this.height * this.base / 2;
    }

    @Override
    public String toString() {
        return "Triunghi: " + super.toString() + " " + getArea() + "\n";
    }
}
