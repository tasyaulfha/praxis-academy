public class Employee {
    //contoh variabel ini dapat dilihat oleh semua kelas
    public String name;
    //variabel salary hanya terlihat di kelas employee
    private double salary;
    public Employee (String empName){
        name = empName;
        
    }
    //variabel gaji diberi nilai
    public void setSalary(double empSal){
        salary = empSal;
    }
    //metode ini menampilkan detail employee
    public void printEmp(){
        System.out.println("name    :" + name);
        System.out.println("salary  :" + salary);
    }
    public static void main(String[] args) {
        Employee empOne = new Employee("Tasya");
        empOne.setSalary(1000);
        empOne.printEmp();
    }
}
