package PackageGUI.Estudantes;

import PackageClasses.Escola;
import PackageClasses.Estudante;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAdd {
    Escola escola;

    //janela
    private JFrame janela;

    //Painéis
    private JPanel JPaddAluno;
    private JPanel JPbotoes;

    //Rótulos
    private JLabel JLnomeAluno;
    private JLabel JLendereçoAluno;
    private JLabel JLidadeAluno;
    private JLabel JLnotaAluno;

    //Campos
	private JTextField txtNomeAluno;
    private JTextField txtEnderecoAluno;
    private JTextField txtIdadeAluno;
    private JTextField txtNotaAluno;

    //Botoes
	private JButton btAdicionar;
    private JButton btVoltar;
    private JButton btLimpar;

    public TelaAdd(Escola escola){
        this.escola = escola;
    }

    //Instancias de componentes
	public void criaComponentes() {
		janela = new JFrame("ADICIONAR ALUNO");
		
		JPaddAluno = new JPanel();
        JPbotoes = new JPanel();

        JLnomeAluno= new JLabel("Digite o nome do aluno: ");
        txtNomeAluno = new JTextField(100);
        JLendereçoAluno = new JLabel("Digite o endereço do aluno: ");
        txtEnderecoAluno = new JTextField(100);
        JLidadeAluno = new JLabel("Digite a idade do aluno: ");
        txtIdadeAluno = new JTextField(3);
        JLnotaAluno = new JLabel("Digite a nota do aluno: ");
        txtNotaAluno = new JTextField(4);

		btAdicionar = new JButton("Adicionar");
        btLimpar = new JButton("Limpar campos");
        btVoltar = new JButton("Voltar");	
	}

    //Organiza Componentes
	public void preparaPaineis(){
        JPaddAluno.setLayout(new BoxLayout(JPaddAluno, BoxLayout.Y_AXIS));
        JPaddAluno.add(JLnomeAluno);
        JPaddAluno.add(txtNomeAluno);
		JPaddAluno.add(JLendereçoAluno);
        JPaddAluno.add(txtEnderecoAluno);
        JPaddAluno.add(JLidadeAluno);
        JPaddAluno.add(txtIdadeAluno);
        JPaddAluno.add(JLnotaAluno);
        JPaddAluno.add(txtNotaAluno);

        JPbotoes.setLayout(new BoxLayout(JPbotoes, BoxLayout.Y_AXIS));
        JPbotoes.add(btAdicionar);
        JPbotoes.add(btLimpar);
		JPbotoes.add(btVoltar);
	}

    //Configura Janela
	public void preparaJanela() {
		
		janela.setLayout(new BorderLayout());
		janela.add(JPaddAluno, BorderLayout.PAGE_START);
        janela.add(JPbotoes, BorderLayout.PAGE_END);
	
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(600,300);
        janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

    public void addAluno(){
		btAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                try{
                    Estudante estudante = new Estudante(txtNomeAluno.getText(), 
                                                    txtEnderecoAluno.getText(), 
                                                    Integer.parseInt(txtIdadeAluno.getText()),
                                                    Float.parseFloat(txtNotaAluno.getText())
                    );
                    escola.addEstudante(estudante);
                    JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso!",
                    "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                }catch(Exception error){
                    JOptionPane.showMessageDialog(null, 
                    "Não foi possivel adicionar o estudante! \nERROR: " + error.getMessage(), "ERROR", 
                    JOptionPane.ERROR_MESSAGE);
                }
                
			}
		});
	}

    public void limparCampos() {
		btLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNomeAluno.setText("");
				txtEnderecoAluno.setText("");
                txtIdadeAluno.setText("");
                txtNotaAluno.setText("");
			}
		});
	}

    public void voltar(JFrame telaAnterior) {
		btVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
                telaAnterior.setVisible(true);
			}
		});
	}

    public void renderizaJanela(JFrame telaAnterior) {
		criaComponentes();
		preparaPaineis();
		preparaJanela();
        addAluno();
        limparCampos();
		voltar(telaAnterior);
	}
}