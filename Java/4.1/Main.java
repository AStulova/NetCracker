public class Main {

    public static void main(String[] args) {
        Student student = new Student("Joey Tribbiani", "2691  Watson Lane", "IST", 4, 1575.75);
        Staff staff = new Staff("Monica Geller", "678  Mount Street", "Asheville School", 1100);
        Person person = new Person("Chandler Bing", "3765  Bartlett Avenue");
        System.out.println(student);
        System.out.println(staff);
        System.out.println(person);
    }
}
