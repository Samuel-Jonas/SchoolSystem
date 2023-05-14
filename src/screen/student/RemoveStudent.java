package screen.student;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.School;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveStudent {
	School escola;
    //janela
    private JFrame janela;

    //Painéis
    private JPanel JPremover;

    //Rótulos
    private JLabel JLidAluno;

    //Campos
	private JTextField txtidAluno;

    //Botoes
	private JButton btRemover;
    private JButton btVoltar;

	public RemoveStudent(School escola){
		this.escola = escola;
	}

    //Instancias de componentes
	public void criaComponentes() {
		janela = new JFrame("REMOVER ALUNO");
		
		JPremover = new JPanel();

        JLidAluno= new JLabel("Digite o ID do aluno: ");
        txtidAluno = new JTextField(5);

		btRemover = new JButton("Remover");
        btVoltar = new JButton("Voltar");	
	}

    //Organiza Componentes
	public void preparaPaineis(){
        JPremover.setLayout(new BoxLayout(JPremover, BoxLayout.Y_AXIS));
        JPremover.add(JLidAluno);
        JPremover.add(txtidAluno);
		JPremover.add(btRemover);
		JPremover.add(btVoltar);
	}

    //Configura Janela
	public void preparaJanela() {
		
		janela.setLayout(new FlowLayout());
		
		janela.add(JPremover);
	
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400,200);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

    public void remAluno(){
		btRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "OK", "CANCELAR"};
    			int op = JOptionPane.showOptionDialog(null, "Tem certesa que deseja remover o aluno?", "AVISO",
        		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
            	null, options, options[0]);
				if(op == 0){
					try{
						escola.delEstudante(Integer.parseInt(txtidAluno.getText()));
						JOptionPane.showMessageDialog(null, "Estudante removido com sucesso!",
						"SUCESSO", JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception error){
						JOptionPane.showMessageDialog(null, 
						"Não foi possivel remover o estudante! \nERROR: " + error.getMessage(), "ERROR", 
						JOptionPane.ERROR_MESSAGE);
					}
				}
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
        remAluno();
		voltar(telaAnterior);
	}
}
