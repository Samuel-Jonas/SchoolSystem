package screen.student;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.School;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListStudent {
	School escola;
    //janela
    private JFrame janela;

    //Painéis
    private JPanel JPlista;

    //Tabela
    private JTable JTalunos;

    //Barra de rolagem
    private JScrollPane JSbarraRolagem;

    //Rótulos
    private JLabel JLalunos;

    //Botoes
    private JButton btVoltar;

	public ListStudent(School escola){
		this.escola = escola;
	}

    //Instancias de componentes
	public void criaComponentes() {
		janela = new JFrame("LISTA DOS ALUNOS");
		
		JPlista = new JPanel();
        
        String[] columnNames = {"ID", "Nome", "Idade", "Endereço", "Nota", "Mensalidade"};
        Object[][] estudantes = escola.listarEstudantes();

        JTalunos = new JTable(estudantes, columnNames);
        JTalunos.getColumnModel().getColumn(1).setPreferredWidth(200);
        JTalunos.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTalunos.setPreferredScrollableViewportSize(new Dimension(800,500));
        JTalunos.setFillsViewportHeight(true);
        JSbarraRolagem = new JScrollPane(JTalunos);

        JLalunos = new JLabel("Lista de alunos");

        btVoltar = new JButton("Voltar");	
	}

    //Organiza Componentes
	public void preparaPaineis(){
        JPlista.setLayout(new BoxLayout(JPlista, BoxLayout.Y_AXIS));
        JPlista.add(JLalunos);
        JPlista.add(JTalunos.getTableHeader());
        JPlista.add(JTalunos);
        JPlista.add(JSbarraRolagem);
        JPlista.add(btVoltar);
	}

    //Configura Janela
	public void preparaJanela() {
		
		janela.setLayout(new FlowLayout());
		
		janela.add(JPlista);
	
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(800,300);
        janela.setLocationRelativeTo(null);
		janela.setVisible(true);
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
		voltar(telaAnterior);
	}
}
