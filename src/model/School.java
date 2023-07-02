package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import states.TerminatedState;

public class School extends BaseEntity{

	private String name;
	private String address;
	private Map<Long, Teacher> theachMap = new HashMap<Long, Teacher>();
	private Map<Long, Employee> employeeMap = new HashMap<Long, Employee>();
	private Map<Long, Student> studantMap = new HashMap<Long, Student>();

	public School(String name, String address) {
		this.setNome(name);
		this.setEndereco(address);
		this.setCreationDate();
	}

	public void addTeacher(Teacher teacher) {

		Random random = new Random();
		long id = random.nextInt(10000); 

		if (theachMap.get(id) == null) {
			teacher.setId(id);
		} else {
			teacher.setId(random.nextInt(1000));
		}

		theachMap.put(teacher.getId(),teacher);
	}

	public void addEmployee(Employee employee) {

		Random random = new Random();
		long id = random.nextInt(10000); 

		if( employeeMap.get(id) == null) {
			employee.setId(id);
		} else {
			employee.setId(random.nextInt(1000));
		}

		employeeMap.put(employee.getId(),employee);
	}

	public void addEstudante(Student estudante) {
		Random random = new Random();
		long id = random.nextInt(10000); 

		if(studantMap.get(id) == null){
			estudante.setId(id);
		}else{
			estudante.setId(random.nextInt(1000));
		}
		studantMap.put(estudante.getId(),estudante);
	}

	public void delProfessor(long id) {
		Employee professor = theachMap.get(id);
		professor.setState(new TerminatedState());
	}

	public void delFuncionario(long id) {
		Employee funcionario = theachMap.get(id);
		funcionario.setState(new TerminatedState());
	}

	public void delEstudante(long id) {
		studantMap.remove(id);
	}
	
	public void pagarSalario(long id, int tipo) {
		if(tipo == 1){
			Teacher professor = theachMap.get(id);
			professor.status.receberSalario();
		}else{
			Employee funcionario = employeeMap.get(id);
			funcionario.receberSalario();
		}
		
	}
	
	public Object[][] listarProfessores() {
		Object[][] tableData = new Object[theachMap.keySet().size()][6];
		int index = 0;
		for(Teacher prof: theachMap.values()){
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
		Object[][] tableData = new Object[studantMap.keySet().size()][6];
		int index = 0;
		for(Student aluno: studantMap.values()){
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
		Object[][] tableData = new Object[employeeMap.keySet().size()][6];
		int index = 0;
		for(Employee funcionario: employeeMap.values()){
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
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public String getEndereco() {
		return address;
	}

	public void setEndereco(String endereco) {
		this.address = endereco;
	}
	
	public Student getEstudante(long id) {
		return studantMap.get(id);
		
	}
	public Employee getFuncionario(long id) {
		return employeeMap.get(id);
	}
}
