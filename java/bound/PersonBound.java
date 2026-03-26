import java.beans.*;

public class PersonBound {
    private String name;
    private int age;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public PersonBound() {}

    public String getName() {  //getter for name
         return name; 
        }

    public void setName(String name) { //setter for name
        String oldName = this.name;
        this.name = name;
        pcs.firePropertyChange("name", oldName, name);
    }

    public int getAge() { 
        return age;  //getter for age
     }

    public void setAge(int age) { //setter for age
        int oldAge = this.age;
        this.age = age;
        pcs.firePropertyChange("age", oldAge, age);
    }

    // Methods to add/remove listeners
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}