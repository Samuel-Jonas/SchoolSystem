package PackageGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

//import SchoolSystem.PackageClasses.Professor;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Telas {
    
    //janela
    private JFrame janela;

    //Painéis
	private JPanel JPprofessor;
	private JPanel JPbotoes;

    //Rótulos
	private JLabel JLnomeProf;

    //Campos
	private JTextField txtNomeProf;

    //Botoes
	private JButton btAdicionarProf;
	private JButton btRemoverProf;
	private JButton btListarProf;
    private JButton btSair;
    private JButton btLimpar;

    //private Professor guiprofessor;

    public Telas(){
        //guiprofessor = new Professor();
    }

    //Instancias de componentes
	public void criaComponentes() {
		janela = new JFrame("Gestão de Professores");
		
		JPprofessor = new JPanel();
		JPbotoes = new JPanel();
		
		JLnomeProf = new JLabel("Digite o some do professor");
		
		txtNomeProf = new JTextField(15);
		
		btAdicionarProf = new JButton("Adicionar");
		btRemoverProf = new JButton("Remover");
		btListarProf = new JButton("Listar");
        btSair = new JButton("Sair");
        btLimpar = new JButton("Limpar");		
	}

    //Organiza Componentes
	public void preparaPaineis() {
		JPprofessor.setLayout(new FlowLayout());
		JPprofessor.add(JLnomeProf);
		JPprofessor.add(txtNomeProf);
		
		JPbotoes.setLayout(new FlowLayout());
		JPbotoes.add(btAdicionarProf);
		JPbotoes.add(btRemoverProf);
		JPbotoes.add(btListarProf);
        JPbotoes.add(btSair);
        JPbotoes.add(btLimpar);
		
	}

    //Configura Janela
	public void preparaJanela() {
		
		janela.setLayout(new FlowLayout());
		
		janela.add(JPprofessor);
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
				txtNomeProf.setText("");
				
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
