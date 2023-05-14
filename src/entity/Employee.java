package entity;

public class Employee extends Person {
	
	private double salario;
	private double totalGanho = 0;
	private String profissao;
	
	public Employee(double salario, String nome, int idade, String profissao, String endereco) {
		super(nome, idade, endereco);
		this.salario = salario;
		setProfissao(profissao);
	}

	public void setProfissao(String profissao){
		this.profissao = profissao;
	}
	
	public void receberSalario() {
		this.totalGanho += salario;
	}

	public String getProfissao() {
		return profissao;
	}
	public double getSalario() {
		return salario;
	}
	public double getTotalGanho() {
		return totalGanho;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
