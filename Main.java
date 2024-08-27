import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSal();

    @Override
    public String toString(){
        return "Employee[name=" + name+", id="+id+", salary="+calculateSal()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSal(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id, int hoursWorked,double hourlyRate ){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;

    }

    @Override
    public double calculateSal(){
        return hourlyRate * hoursWorked;
    }

}
class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);

    }

    public void removeEmployee(int id){
        Employee empToRemove =null;
        for (Employee e:employeeList){
            if(e.getId()==id){
                empToRemove=e;
                break;
            }
        }

        if(empToRemove  != null){
            employeeList.remove(empToRemove);
        }
    }


    public void displayEmp(){
        for(Employee e:employeeList){
            System.out.println(e);
        }
    }
}

public class Main {

    public static void main(String[] args){
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("nikita",101,80000);
        PartTimeEmployee emp2=new PartTimeEmployee("gaura",102,12,3000);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("display initial details");
        payrollSystem.displayEmp();
        System.out.println("removing employees");
        payrollSystem.removeEmployee(102);
        System.out.println("display rest of details");
        payrollSystem.displayEmp();


    }
}
