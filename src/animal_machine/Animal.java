package animal_machine;

public abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void Barkable() {

    }

    void Runable() {

    }

    void Flyable() {

    }

    void Swimable() {

    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
