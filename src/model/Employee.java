package model;

import states.ActiveState;
import states.EmployeeState;

public class Employee extends Person {

	public EmployeeState status;
	private String profissao;
	
	public Employee(double salario, String nome, int idade, String profissao, String endereco) {
		super(nome, idade, endereco);
		status.definirSalario(salario);
		setProfissao(profissao);
		setCreationDate();
		setState(new ActiveState());
	}

	public void setProfissao(String profissao){
		this.profissao = profissao;
	}
	
	public void receberSalario() {
		this.status.receberSalario();
	}

	public String getProfissao() {
		return profissao;
	}
	public double getSalario() {
		return status.verSalario();
	}
	public double getTotalGanho() {
		return status.verTotalGanho();
	}

	public void setSalario(double salario) {
		this.status.definirSalario(salario);
	}

	public void setState(EmployeeState state) {
        this.status = state;
    }
}
