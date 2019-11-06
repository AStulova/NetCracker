class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName()  {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary * 12;
    }

    public int raiseSalary(int percent) {
        this.salary += salary * ((double) percent / 100);
        return salary;
    }

    @Override
    public String toString() {
        return "Employee[id=" + id +
                ", name=" + firstName + " " + lastName +
                ", salary=" + salary + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Employee)) return false;
        Employee employee = (Employee) obj;
        return employee.id == id && employee.salary == salary
                && employee.firstName.equals(firstName) && employee.lastName.equals(lastName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + salary;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}

public class MainEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Mike", "Jayson", 500);
        System.out.println(employee.toString());
        System.out.println(employee.getName() + " get a new salary " + employee.raiseSalary(5) + " dollars");
        Employee employee1 = employee;
        System.out.println(employee.hashCode());
        System.out.println(employee1.hashCode());
        System.out.println(employee.equals(employee1));
    }
}
