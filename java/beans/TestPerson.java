package beans;

import java.beans.PropertyVetoException;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        
        try {
            person.setName("Alice");     // Bound property
            person.setAge(21);           // Constrained property
        } catch (PropertyVetoException e) {
            System.out.println("Age change vetoed: " + e.getMessage());
        }

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}