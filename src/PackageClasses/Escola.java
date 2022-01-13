package PackageClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Escola {

	private String nome;
	private String endereco;
	private Map<Integer, Professor> professores = new HashMap<Integer, Professor>();
	private Map<Integer, Funcionario> funcionarios = new HashMap<Integer, Funcionario>();
	private Map<Integer, Estudante> estudantes = new HashMap<Integer, Estudante>();

	public Escola(String nome, String endereco) {
		this.setNome(nome);
		this.setEndereco(endereco);
	}

	public void addProfessor(Professor professor) {
		Random gerador = new Random();
		int id = gerador.nextInt(10000); 
		if(professores.get(id) == null){
			professor.setId(id);
		}else{
			professor.setId(gerador.nextInt(1000));
		}
		professores.put(professor.getId(),professor);
	}
	public void addFuncionario(Funcionario funcionario) {
		Random gerador = new Random();
		int id = gerador.nextInt(10000); 
		if(funcionarios.get(id) == null){
			funcionario.setId(id);
		}else{
			funcionario.setId(gerador.nextInt(1000));
		}
		funcionarios.put(funcionario.getId(),funcionario);
	}
	public void addEstudante(Estudante estudante) {
		Random gerador = new Random();
		int id = gerador.nextInt(10000); 
		if(estudantes.get(id) == null){
			estudante.setId(id);
		}else{
			estudante.setId(gerador.nextInt(1000));
		}
		estudantes.put(estudante.getId(),estudante);
	}

	public void delProfessor(int id) {
		professores.remove(id);
	}
	public void delFuncionario(int id) {
		funcionarios.remove(id);
	}
	public void delEstudante(int id) {
		estudantes.remove(id);
	}
	
	public void pagarSalario(int id, int tipo) {
		if(tipo == 1){
			Professor professor = professores.get(id);
			professor.receberSalario();
		}else{
			Funcionario funcionario = funcionarios.get(id);
			funcionario.receberSalario();
		}
		
	}
	
	public Object[][] listarProfessores() {
		Object[][] tableData = new Object[professores.keySet().size()][6];
		int index = 0;
		for(Professor prof: professores.values()){
			tableData[index][0] = String.valueOf(prof.getId());
			tableData[index][1] = prof.getNome();
			tableData[index][2] = String.valueOf(prof.getIdade());
			tableData[index][3] = prof.getEndereco();
			tableData[index][4] = String.valueOf(prof.getSalario());
			tableData[index][5] = prof.getFormacao();
			index++;
		}

		return tableData;
	}

	public Object[][] listarEstudantes() {
		Object[][] tableData = new Object[estudantes.keySet().size()][6];
		int index = 0;
		for(Estudante aluno: estudantes.values()){
			tableData[index][0] = String.valueOf(aluno.getId());
			tableData[index][1] = aluno.getNome();
			tableData[index][2] = String.valueOf(aluno.getIdade());
			tableData[index][3] = aluno.getEndereco();
			tableData[index][4] = String.valueOf(aluno.getNota());
			tableData[index][5] = aluno.getMensalidade();
			index++;
		}
		return tableData;
	}
	
	public Object[][] listarFuncionarios() {
		Object[][] tableData = new Object[funcionarios.keySet().size()][6];
		int index = 0;
		for(Funcionario funcionario: funcionarios.values()){
			tableData[index][0] = String.valueOf(funcionario.getId());
			tableData[index][1] = funcionario.getNome();
			tableData[index][2] = String.valueOf(funcionario.getIdade());
			tableData[index][3] = funcionario.getEndereco();
			tableData[index][4] = String.valueOf(funcionario.getSalario());
			tableData[index][5] = funcionario.getProfissao();
			index++;
		}
		return tableData;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Estudante getEstudante(int id) {
		return estudantes.get(id);
		
	}
	public Funcionario getFuncionario(int id) {
		return funcionarios.get(id);
	}
}
