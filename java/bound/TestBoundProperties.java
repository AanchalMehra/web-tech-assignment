package bound;

import beans.Person;
import java.beans.*;

public class TestBoundProperties {
    public static void main(String[] args) {
        Person person = new Person();

        // Listener for bound properties
        PropertyChangeListener listener = evt -> {
            System.out.println("Property Changed: " + evt.getPropertyName());
            System.out.println("Old Value: " + evt.getOldValue());
            System.out.println("New Value: " + evt.getNewValue());
        };

        // Register listener
        person.addPropertyChangeListener(listener);

        try {
            // Change properties
            person.setName("Alice");
            person.setName("Bob");

            person.setAge(30);   // Must handle PropertyVetoException
            person.setAge(35);   // Must handle PropertyVetoException
        } catch (PropertyVetoException e) {
            System.out.println("Vetoed: " + e.getMessage());
        }
    }
}