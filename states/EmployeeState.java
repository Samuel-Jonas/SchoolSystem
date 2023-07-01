package states;

public interface EmployeeState {
	public double totalGanho = 0;
	public double salario = 0;
    void receberSalario();
    void definirSalario(double salario);
    double verSalario();
    double verTotalGanho();
}