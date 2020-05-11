package forms;

public class Circle extends Form {
    private float radius;

    public Circle() {
        super();
        this.radius = 0f;
    }

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }


    public void printCircleDimensions(){
        System.out.println("raza: " + this.radius);
    }

    @Override
    public float getArea() {
        return 3.14f * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return "Cerc: " + super.toString() + " " + getArea() + "\n";
    }
}
