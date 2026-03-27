package bound;

import java.beans.*;

public class PropertyListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property Changed: " + evt.getPropertyName());
        System.out.println("Old Value: " + evt.getOldValue());
        System.out.println("New Value: " + evt.getNewValue());
    }
}