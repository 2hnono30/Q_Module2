package animal_machine;

public abstract class Machine {
private String color;
private String name;
void Runable(){};
void Flyable(){};

    @Override
    public String toString() {
        return "Machine{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
