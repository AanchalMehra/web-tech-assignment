package beaninfo;
import java.beans.*;
import beans.Person; 

public class TestBeanInfo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);

        System.out.println("=== Properties ===");
        for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
            System.out.println("Property: " + pd.getDisplayName());
        }

        System.out.println("\n=== Methods ===");
        for (MethodDescriptor md : beanInfo.getMethodDescriptors()) {
            System.out.println("Method: " + md.getName());
        }
    }
}