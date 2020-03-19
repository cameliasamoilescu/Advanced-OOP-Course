package asociere;

public class Profesor {
    private int id;
    private String nume;

    public Profesor(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }


    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }


    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }
}
