import java.beans.*;
public class TestConstrained {
    public static void main(String[] args) {
        PersonConstrained p = new PersonConstrained();

        // Add veto listener to ensure age >= 18
        p.addVetoableChangeListener(evt -> {
            int newAge = (int) evt.getNewValue();
            if (newAge < 18) {
                throw new PropertyVetoException("Age must be at least 18!", evt);
            }
        });

        try {
            p.setAge(20); // works
            System.out.println("Age set to 20");
            p.setAge(16); // vetoed
        } catch (PropertyVetoException e) {
            System.out.println("Failed to set age: " + e.getMessage());
        }
    }
}
