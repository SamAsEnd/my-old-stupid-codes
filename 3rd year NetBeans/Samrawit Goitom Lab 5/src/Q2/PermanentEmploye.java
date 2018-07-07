package Q2;


//   cannot inherit from final class Employe
//   Solution
//   ========
//  remove the final from Employee

// abstract & final can't combined
public class PermanentEmploye extends Employee{

    @Override
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
}
