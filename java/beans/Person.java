import java.io.Serializable;
//public class and implementing serializable
public class Person implements Serializable {
    private String name;
    private int age;
    // Default constructor
    public Person() {
    }
    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}