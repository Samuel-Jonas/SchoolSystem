package screen.student;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.School;
import screen.HomeScreen;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeStudent {
    //janela
    private JFrame janela;

    //Painéis
	private JPanel JPmenu;

    //Rótulos
    private JLabel JLescolha;

    //Botoes
	private JButton btAddAluno;
    private JButton btRemAluno;
    private JButton btPagarMensalidade;
	private JButton btMostrarAlunos;
    private JButton btVoltar;

    //Instancias de componentes
	public void criaComponentes(){
		janela = new JFrame("MENU ALUNO");
		
		JPmenu = new JPanel();
        JLescolha = new JLabel("Escolha uma opção");

		btAddAluno = new JButton("Adicionar aluno");
        btRemAluno = new JButton("Remover aluno");
		btMostrarAlunos = new JButton("Listar alunos");
        btPagarMensalidade = new JButton("Pagar mensalidade");
        btVoltar = new JButton("Voltar");	
	}

    //Organiza Componentes
	public void preparaPaineis(){
        JPmenu.setLayout(new BoxLayout(JPmenu, BoxLayout.Y_AXIS));
        JPmenu.add(JLescolha);
        JPmenu.add(btAddAluno);
		JPmenu.add(btRemAluno);
		JPmenu.add(btMostrarAlunos);
		JPmenu.add(btPagarMensalidade);
		JPmenu.add(btVoltar);
	}

    //Configura Janela
	public void preparaJanela() {
		
		janela.setLayout(new FlowLayout());
		
		janela.add(JPmenu);
	
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400,200);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

    public void addAluno(School escola){
        AddStudent add = new AddStudent(escola);
		btAddAluno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add.renderizaJanela(janela);
			}
		});
	}

    public void remAluno(School escola){
        RemoveStudent remover = new RemoveStudent(escola);
		btRemAluno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover.renderizaJanela(janela);
			}
		});
	}

	public void mostrarAlunos(School escola){
        ListStudent mostrar = new ListStudent(escola);
		btMostrarAlunos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                mostrar.renderizaJanela(janela);
			}
		});
	}

    public void pagarMensalidade(School escola){
        MonthlyPayment mensalidade = new MonthlyPayment(escola);
		btPagarMensalidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                mensalidade.renderizaJanela(janela);
			}
		});
	}

    public void voltar() {
		btVoltar.addActionListener(new ActionListener() {
			HomeScreen menu = new HomeScreen();
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.renderizaJanela();
				janela.setVisible(false);
			}
		});
	}

    public void renderizaJanela(School escola) {
		criaComponentes();
		preparaPaineis();
		preparaJanela();
        addAluno(escola);
        remAluno(escola);
		mostrarAlunos(escola);
        pagarMensalidade(escola);
		voltar();
	}
}
