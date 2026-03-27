package beaninfo;
import java.beans.*;
import beans.Person;

public class PersonBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor nameDescriptor = new PropertyDescriptor("name", Person.class);
            nameDescriptor.setDisplayName("Person's Name");

            PropertyDescriptor ageDescriptor = new PropertyDescriptor("age", Person.class);
            ageDescriptor.setDisplayName("Person's Age");

            return new PropertyDescriptor[]{nameDescriptor, ageDescriptor};
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        try {
            MethodDescriptor getNameDescriptor = new MethodDescriptor(Person.class.getMethod("getName"));
            MethodDescriptor setNameDescriptor = new MethodDescriptor(Person.class.getMethod("setName", String.class));
            return new MethodDescriptor[]{getNameDescriptor, setNameDescriptor};
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}