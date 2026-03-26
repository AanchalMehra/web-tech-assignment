import java.beans.*;

public class PersonConstrained {
    private int age;
    private VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    public PersonConstrained() {} // default constructor

    public int getAge() { return age; }

    public void setAge(int age) throws PropertyVetoException {
        int oldAge = this.age;
        vcs.fireVetoableChange("age", oldAge, age); // can throw exception
        this.age = age;
    }

    // Add/remove listeners
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vcs.addVetoableChangeListener(listener);
    }

    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vcs.removeVetoableChangeListener(listener);
    }
}