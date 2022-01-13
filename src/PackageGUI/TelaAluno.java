package PackageGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaAluno {
    
    //janela
    private JFrame janela;

    //Painéis
	private JPanel JPaluno;
	private JPanel JPbotoes;

    //Rótulos
	private JLabel JLnomeAluno;

    //Campos
	private JTextField txtNomeAluno;

    //Botoes
	private JButton btAdicionarAluno;
	private JButton btRemoverAluno;
	private JButton btListarAlunos;
    private JButton btSair;
    private JButton btLimpar;

    //Instancias de componentes
	public void criaComponentes() {
		janela = new JFrame("Gestão de Alunos");
		
		JPaluno = new JPanel();
		JPbotoes = new JPanel();
		
		JLnomeAluno = new JLabel("Digite o nome do aluno");
		
		txtNomeAluno = new JTextField(15);
		
		btAdicionarAluno = new JButton("Adicionar");
		btRemoverAluno = new JButton("Remover");
		btListarAlunos = new JButton("Listar");
        btListarAlunos = new JButton("Pagar mensalidade");
        btSair = new JButton("Sair");
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

    public void renderizaJanela() {
		criaComponentes();
		preparaPaineis();
		preparaJanela();
		sair();
		limparCampos();
	}
}
