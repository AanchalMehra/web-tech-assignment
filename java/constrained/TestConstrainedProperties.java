package constrained;

import beans.Person;
import java.beans.*;

public class TestConstrainedProperties {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            AgeListener listener = new AgeListener();

            person.addVetoableChangeListener(listener);

            person.setAge(25); // Allowed
            System.out.println("Age set to: " + person.getAge());

            person.setAge(15); // Should be vetoed

        } catch (PropertyVetoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}