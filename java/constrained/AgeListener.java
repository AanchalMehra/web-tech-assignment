package constrained;

import java.beans.*;

public class AgeListener implements VetoableChangeListener {
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        int newAge = (int) evt.getNewValue();
        if (newAge < 18) {
            System.out.println("Vetoed: Age cannot be less than 18!");
            throw new PropertyVetoException("Invalid Age!", evt);
        }
    }
}
