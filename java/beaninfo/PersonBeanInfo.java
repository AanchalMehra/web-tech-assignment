import java.beans.*;

public class PersonBeanInfo extends SimpleBeanInfo {

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor nameProp = new PropertyDescriptor("name", Class.forName("beans.Person"));
            PropertyDescriptor ageProp = new PropertyDescriptor("age", Class.forName("beans.Person"));
            return new PropertyDescriptor[]{nameProp, ageProp};
        } catch (IntrospectionException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}