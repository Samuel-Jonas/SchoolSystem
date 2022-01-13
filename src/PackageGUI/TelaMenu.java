package PackageGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PackageClasses.Escola;
import PackageGUI.Estudantes.TelaAluno;

import javax.swing.JLabel;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenu {
	//Escola
	Escola escola;

    //janela
    private JFrame janela;

    //Painéis
	private JPanel JPmenu;

    //Rótulos
    private JLabel JLescolha;

    //Botoes
	private JButton btProfessor;
    private JButton btFuncionario;
    private JButton btAluno;
    private JButton btSair;

    //Instancias de componentes
	public void criaComponentes() {
		escola = new Escola("UFC", "RUSSAS");
		janela = new JFrame("MENU GERAL");
		
		JPmenu = new JPanel();
		
        JLescolha = new JLabel("Escolha uma opção");

		btProfessor = new JButton("Gerenciar professor");
        btFuncionario = new JButton("Gerenciar funcionario");
        btAluno = new JButton("Gerenciar aluno");
        btSair = new JButton("Sair");	
	}

    //Organiza Componentes
	public void preparaPaineis(){
        JPmenu.setLayout(new BoxLayout(JPmenu, BoxLayout.Y_AXIS));
        JPmenu.add(JLescolha);
        JPmenu.add(btProfessor);
		JPmenu.add(btFuncionario);
		JPmenu.add(btAluno);
		JPmenu.add(btSair);
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

    public void escolhaProfessor(){
        TelaProfessor tela = new TelaProfessor();
		btProfessor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.renderizaJanela();
                janela.setVisible(false);
			}
		});
	}

    public void escolhaFuncionario(){
        Telas tela = new Telas();
		btFuncionario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.renderizaJanela();
                janela.setVisible(false);
			}
		});
	}

    public void escolhaAluno(Escola escola){
        TelaAluno telaAluno = new TelaAluno();
		btAluno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                telaAluno.renderizaJanela(escola);
				janela.setVisible(false);
			}
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

	public void renderizaJanela() {
		criaComponentes();
		preparaPaineis();
		preparaJanela();
        escolhaProfessor();
        escolhaFuncionario();
        escolhaAluno(escola);
		sair();
	}

	
    public void renderizaJanela(Escola escola) {
		criaComponentes();
		preparaPaineis();
		preparaJanela();
        escolhaProfessor();
        escolhaFuncionario();
        escolhaAluno(escola);
		sair();
	}
}
