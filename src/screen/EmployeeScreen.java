package screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeScreen {
	//janela
	private JFrame janela;

	//PainÃ©is
	private JPanel JPfunc;
	private JPanel JPbotoes;
	//RÃ³tulos
	private JLabel JLnomeFunc;

	//Botoes
	private JButton btAdicionarFuncionario;
	private JButton btRemoverFuncionario;
	private JButton btListarFuncionarios;
	private JButton btPagarSalario;
	private JButton btSair;
	private JButton btLimpar;
	private JButton btVoltar;

	// Text field
	private JTextField nomeFunc;
	//private JTextField idadeFunc;

	//Instancias de componentes
	public void criaComponentes() {
		janela = new JFrame("Gestão de Funcionarios");

		JPfunc = new JPanel();
		JPbotoes = new JPanel();

		JLnomeFunc = new JLabel("Digite o nome do funcionário");

		nomeFunc = new JTextField(15);

		btAdicionarFuncionario = new JButton("Adicionar");
		btRemoverFuncionario = new JButton("Remover");
		btListarFuncionarios = new JButton("Listar");
		btPagarSalario = new JButton("Pagar mensalidade");
		btSair = new JButton("Sair");
		btLimpar = new JButton("Limpar");
		btVoltar = new JButton("Voltar");
	}

	//Organiza Componentes
	public void preparaPaineis(){
		JPfunc.setLayout(new FlowLayout());
		JPfunc.add(JLnomeFunc);
		JPfunc.add(nomeFunc);

		JPbotoes.setLayout(new FlowLayout());
		JPbotoes.add(btAdicionarFuncionario);
		JPbotoes.add(btRemoverFuncionario);
		JPbotoes.add(btListarFuncionarios);
		JPbotoes.add(btPagarSalario);
		JPbotoes.add(btSair);
		JPbotoes.add(btLimpar);
		JPbotoes.add(btVoltar);
	}

	//Configura Janela
	public void preparaJanela() {

		janela.setLayout(new FlowLayout());

		janela.add(JPfunc);
		janela.add(JPbotoes);

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setSize(700,200);
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
				nomeFunc.setText("");
				
			}
		});
	}
	
	public void voltarMenu() {
		HomeScreen menu = new HomeScreen();
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.renderizaJanela();
				janela.setVisible(false);
			}
		});
	}

	public void renderizaJanela() {
		criaComponentes();
		preparaPaineis();
		preparaJanela();
		sair();
		limparCampos();
		voltarMenu();
	}
}
