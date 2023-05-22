package screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.repository.StudentDAO;
import entity.Payment;
import entity.Student;

import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class StudentScreen {

	//tabelas
	public JTable studentTable;
	public DefaultTableModel studenTableModel;
	private String []colunas = {"id", "nome", "idade", "nota", "endereco", "Mensalidade"};
    
    //janela
    private JFrame janela;

    //Painéis
	private JPanel JPaluno;
	private JPanel JPbotoes;
	private JScrollPane studentScrollPane;

    //Rótulos
	private JLabel JLnomeAluno;
	private JLabel ageJl;
	private JLabel gradeJl;
	private JLabel addressJl;
	private JLabel paymentJs;

    //Campos
	private JTextField txtNomeAluno;
	private JTextField txtAge;
	private JTextField txtsGrade;
	private JTextField txtAddress;
	private JTextField txtPayment;

    //Botoes
	private JButton btAdicionarAluno;
	private JButton btUpdate;
	private JButton btRemoverAluno;
	private JButton btListarAlunos;
    private JButton btSair;
    private JButton btLimpar;

	private static Student STUDENT_MARK;

	private List<Student> studentList;

    public StudentScreen(){
        //guiprofessor = new Professor();
		StudentDAO studentDAO = new StudentDAO();
		studentList = new ArrayList<Student>(studentDAO.GetStudentList());
		studenTableModel = new DefaultTableModel();
		studentTable = new JTable(studenTableModel);

		for(String coluna : colunas){
			studenTableModel.addColumn(coluna);
		}
    }

    //Instancias de componentes
	public void criaComponentes() {
		janela = new JFrame("Gestão de Alunos");
		
		JPaluno = new JPanel();
		JPbotoes = new JPanel();
		studentScrollPane = new JScrollPane(studentTable);
		
		JLnomeAluno = new JLabel("Nome");
		txtNomeAluno = new JTextField(15);

		ageJl = new JLabel("Idade");
		txtAge = new JTextField(15);

		gradeJl = new JLabel("Nota");
		txtsGrade = new JTextField(15);
		
		addressJl = new JLabel("Endereço");
		txtAddress = new JTextField(15);

		paymentJs = new JLabel("Pagamento");
		txtPayment= new JTextField(15);
		
		btAdicionarAluno = new JButton("Adicionar");

		btUpdate = new JButton("Atualizar");
		AddStudent();

		btUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (STUDENT_MARK == null)
					return;
				else {
					STUDENT_MARK.setNome(txtNomeAluno.getText());
					STUDENT_MARK.setIdade(Integer.parseInt(txtAge.getText()));
					STUDENT_MARK.setEndereco(txtAddress.getText());
					STUDENT_MARK.setNota(Float.parseFloat(txtsGrade.getText()));
					STUDENT_MARK.setMensalidade(txtPayment.getText());
					new StudentDAO().Update(STUDENT_MARK);
	
					studentList = new ArrayList<>(new StudentDAO().GetStudentList());
					StudentShowList(studenTableModel);
				}
			}
		});

		btSair = new JButton("Voltar");
        btLimpar = new JButton("Limpar");	
	}

    //Organiza Componentes
	public void preparaPaineis() {
		JPaluno.setLayout(new FlowLayout());
		JPaluno.add(JLnomeAluno);
		JPaluno.add(txtNomeAluno);
		
		JPbotoes.setLayout(new FlowLayout());
		JPbotoes.add(btAdicionarAluno);
		JPbotoes.add(btRemoverAluno);
		JPbotoes.add(btListarAlunos);
        JPbotoes.add(btSair);
        JPbotoes.add(btLimpar);
		
	}

    //Configura Janela
	public void preparaJanela() {
		
		janela.setLayout(new FlowLayout());
		
		janela.add(JPaluno);
		janela.add(JPbotoes);
	
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setSize(400,200);
		janela.setVisible(true);
	}

	public void StudentShowList(DefaultTableModel model) {
		model.setNumRows(0);

		studentList.forEach(student -> {
			long id = student.getId();
			String name = student.getNome();
			int age = student.getIdade();
			float grade = student.getNota();
			String address = student.getEndereco();
			String payment = student.getMensalidade();

			model.addRow(new Object []{
				id, name, age, grade, address, payment
			});
		});
	}

    public void sair() {
		btSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}

    public void limparCampos() {
		btLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNomeAluno.setText("");
				
			}
		});
	}

	public void AddStudent () {
		btAdicionarAluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student student = new Student(txtNomeAluno.getText(), txtAddress.getText(), Integer.parseInt(txtAge.getText()),
				Float.parseFloat(txtsGrade.getText()));

				StudentDAO studentDAO = new StudentDAO();
				studentDAO.Save(student);
				studentList = new ArrayList<>(studentDAO.GetStudentList());
				StudentShowList(studenTableModel);
			}
		});
	}

    public void renderizaJanela() {
		criaComponentes();
		preparaPaineis();
		preparaJanela();
		sair();
		limparCampos();
	}
}
