package states;

public class ActiveState implements EmployeeState {

	public double totalGanho = 0;
	public double salario = 0;

    @Override
    public double verSalario() {
        return salario;
    }

    @Override
    public void receberSalario() {
        totalGanho += salario;
    }

    @Override
    public void definirSalario(double salario) {
       this.salario = salario;
    }

    @Override
    public double verTotalGanho() {
       return totalGanho;
    }
}