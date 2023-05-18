package entity;

public class Teacher extends Employee {
	
	private String formacao;
	
	public Teacher(String nome, int idade, double salario, String formacao, String endereco) {
		super(salario, nome, idade, formacao, endereco);
		this.formacao = formacao;
	}
	
	@Override
	public void setProfissao(String formacao){
		super.setProfissao("Professor de " + formacao);
	}
	
	public String getFormacao() {
		return formacao;
	}
	
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public long getId() {
		return super.getId();
	}

	public void setId(long id) {
		super.setId(id);
	}

}

