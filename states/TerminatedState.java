package states;

public class TerminatedState implements EmployeeState {

	public double totalGanho = 0;
	public double salario = 0;

    @Override
    public void receberSalario() {
    }

    @Override
    public double verSalario() {
        return 0.0;
    }

    @Override
    public void definirSalario(double salario) {
    }

    @Override
    public double verTotalGanho() {
        return 0.0;
    }
}
