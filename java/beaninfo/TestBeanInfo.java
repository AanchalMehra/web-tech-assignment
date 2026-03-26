
import java.beans.*;

public class TestBeanInfo {
    public static void main(String[] args) {
        try {
            BeanInfo info = new PersonBeanInfo();
            PropertyDescriptor[] props = info.getPropertyDescriptors();
            for (PropertyDescriptor pd : props) {
                System.out.println("Property: " + pd.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}