import java.util.List;

public class Main {
    public static final String x = "welcome";


    public static void main(String[] args) {
        Freelancer freelancer = new Freelancer();
        Employee employee = new Employee();
        System.out.println(freelancer.display());
        System.out.println(employee.display());
        System.out.println(x);
        x = "hello";
    }
}
