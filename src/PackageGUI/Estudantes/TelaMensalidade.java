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

public class TelaMensalidade {
	Escola escola;
	Estudante estudante;

    //janela
    private JFrame janela;

    //Painéis
    private JPanel JPmensalidade;
	private JPanel JPbotoes;

    //Rótulos
    private JLabel JLidAluno;
    private JLabel JLvalor;

    //Campos
	private JTextField txtidAluno;
    private JTextField txtValor;

    //Botoes
	private JButton btPagar;
	private JButton btLimpar;
    private JButton btVoltar;

	public TelaMensalidade(Escola escola){
		this.escola = escola;
	}

    //Instancias de componentes
	public void criaComponentes() {
		janela = new JFrame("MENSALIDADE");
		
		JPmensalidade = new JPanel();
		JPbotoes = new JPanel();

        JLidAluno= new JLabel("Digite o ID do aluno: ");
        txtidAluno = new JTextField(5);
        JLvalor = new JLabel("Digite o valor que deseja pagar: (MENSALIDADE CUSTA 200)");
        txtValor = new JTextField(5);
		
		btPagar = new JButton("Pagar mensalidade");
		btLimpar = new JButton("Limpar campos");
        btVoltar = new JButton("Voltar");	
	}

    //Organiza Componentes
	public void preparaPaineis(){
        JPmensalidade.setLayout(new BoxLayout(JPmensalidade, BoxLayout.Y_AXIS));
        JPmensalidade.add(JLidAluno);
        JPmensalidade.add(txtidAluno);
		JPmensalidade.add(JLvalor);
        JPmensalidade.add(txtValor);

		JPbotoes.setLayout(new BoxLayout(JPbotoes, BoxLayout.Y_AXIS));
		JPbotoes.add(btPagar);
		JPbotoes.add(btLimpar);
		JPbotoes.add(btVoltar);
	}

    //Configura Janela
	public void preparaJanela() {
		
		janela.setLayout(new BorderLayout());
		janela.add(JPmensalidade, BorderLayout.PAGE_START);
        janela.add(JPbotoes,BorderLayout.PAGE_END);
	
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400,200);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

    public void pagar(){
		btPagar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
                    estudante = escola.getEstudante(Integer.parseInt(txtidAluno.getText()));
					if(estudante.pagarMensalidade(Integer.parseInt(txtValor.getText())) == 1){
						JOptionPane.showMessageDialog(null, "Mensalidade paga com sucesso!",
                    	"SUCESSO", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, 
                    	"Não foi possivel pagar a mensalidade! \nERROR: Valor insuficiente", "ERROR", 
                    	JOptionPane.ERROR_MESSAGE);
					}
                }catch(Exception error){
                    JOptionPane.showMessageDialog(null, 
                    "Não foi possivel pagar a mensalidade! \nERROR: " + error.getMessage(), "ERROR", 
                    JOptionPane.ERROR_MESSAGE);
                }
			}
		});
	}

	public void limparCampos() {
		btLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtidAluno.setText("");
				txtValor.setText("");
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
        pagar();
		limparCampos();
		voltar(telaAnterior);
	}
}
