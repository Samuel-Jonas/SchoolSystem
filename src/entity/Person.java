package entity;

public class Person {
	
	private String nome;
	private int idade;
	private int id;
	private String endereco;
	
	public Person(String nome, int idade, String endereco) {
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
