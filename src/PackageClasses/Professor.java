package PackageClasses;

public class Professor extends Funcionario {
	
	private String formacao;
	private int id;
	
	public Professor(String nome, int idade, double salario, String formacao, String endereco) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

