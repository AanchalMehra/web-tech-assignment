package beans;

import java.beans.*;
import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private int age;

    // Support for bound properties
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    // Support for constrained properties
    private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    public Person() { } // No-arg constructor

    // ===== Name property (bound) =====
    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        pcs.firePropertyChange("name", oldName, name);
    }

    //Age property (bound + constrained)
    public int getAge() {
        return age;
    }

    public void setAge(int age) throws PropertyVetoException {
        int oldAge = this.age;
        vcs.fireVetoableChange("age", oldAge, age);  // Constrained
        this.age = age;
        pcs.firePropertyChange("age", oldAge, age);  // Bound
    }

    // ===== Bound property listeners =====
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    // ===== Constrained property listeners =====
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vcs.addVetoableChangeListener(listener);
    }

    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vcs.removeVetoableChangeListener(listener);
    }
}