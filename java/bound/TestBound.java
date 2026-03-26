import java.beans.*;

public class TestBound {
    public static void main(String[] args) {
        PersonBound p = new PersonBound();

        // Add listener 
        p.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt.getPropertyName() + " changed from " +
                                   evt.getOldValue() + " to " + evt.getNewValue());
            }
        });

        p.setName("Alice");
        p.setAge(25);
        p.setName("Bob");
        p.setAge(30);
    }
}