package screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

import database.repository.TeacherDAO;
import entity.Teacher;
import start.Program;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class TeacherScreen {

	//tabelas
	public JTable tabelaProf;
	public DefaultTableModel modelTableProf;
	private String []colunas = {"id", "nome", "idade", "salario", "endereco", "formacao"};
    
    //janela
    private JFrame janelaProf;

    //Painéis
	private JPanel JPprofessor;
	private JPanel JPbotoes;
	private JScrollPane tabelaProfessor;

    //Rótulos
	private JLabel JLnomeProf;
	private JLabel JLIdaProf;
	private JLabel JLSalarioProf;
	private JLabel JLendeProf;
	private JLabel JLFormProf;

    //Campos
	private JTextField txtNomeProf;
	private JTextField txtIdadeProf;
	private JTextField txtsalarioProf;
	private JTextField txtEndeProf;
	private JTextField txtFormProf;
	

    //Botoes
	private JButton btAdicionarProf;
	private JButton btAtualizarProf;
    private JButton btSair;
    private JButton btLimpar;
	private JButton btDeletar;

    //private Professor guiprofessor;
	private static Teacher PROFESSOR_SELECIONADO;

	private List <Teacher> ListaProf;

    public TeacherScreen(){
        //guiprofessor = new Professor();
		TeacherDAO profDAO = new TeacherDAO();
		ListaProf = new ArrayList<Teacher>(profDAO.listar());
		modelTableProf = new DefaultTableModel();
		tabelaProf = new JTable(modelTableProf);

		for(String coluna : colunas){
			modelTableProf.addColumn(coluna);
		}

    }

    //Instancias de componentes
	public void criaComponentes() {
		janelaProf = new JFrame("Gestão de Professores");
		
		JPprofessor = new JPanel();
		JPbotoes = new JPanel();
		tabelaProfessor = new JScrollPane(tabelaProf);
		
		JLnomeProf = new JLabel("Nome");
		txtNomeProf = new JTextField(15);
		JLIdaProf = new JLabel("Idade");
		txtIdadeProf = new JTextField(15);
		JLSalarioProf = new JLabel("Salário");
		txtsalarioProf = new JTextField(15);
		JLendeProf = new JLabel("Endereço");
		txtEndeProf = new JTextField(15);
		JLFormProf = new JLabel("Formação");
		txtFormProf = new JTextField(15);
		
		btAdicionarProf = new JButton("Adicionar");
		addprofessor();
		btAtualizarProf = new JButton("Atualizar");
		
		btAtualizarProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//quando clicar no botao atualizar
				if(PROFESSOR_SELECIONADO == null) {
					return;
				}else{
					PROFESSOR_SELECIONADO.setNome(txtNomeProf.getText());
					PROFESSOR_SELECIONADO.setIdade(Integer.parseInt(txtIdadeProf.getText()));
					PROFESSOR_SELECIONADO.setSalario(Double.parseDouble(txtsalarioProf.getText()));
					PROFESSOR_SELECIONADO.setEndereco(txtEndeProf.getText());
					PROFESSOR_SELECIONADO.setFormacao(txtFormProf.getText());
					new TeacherDAO().atualizar(PROFESSOR_SELECIONADO);
				
					ListaProf = new ArrayList<>(new TeacherDAO().listar());
					listarProfessores(modelTableProf);
				}
			}
		});

        btSair = new JButton("Voltar");
		sair();
        btLimpar = new JButton("Limpar");
		limparCampos();	
		btDeletar = new JButton("Deletar");	
		btDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = tabelaProf.getSelectedRow(); 
				int valorColuna = (int) tabelaProf.getValueAt(linha, 0);
				
				new TeacherDAO().remover(valorColuna);
				
				ListaProf = new ArrayList<>(new TeacherDAO().listar());
				listarProfessores(modelTableProf);
			}
		});

		//configuraçao do update
		tabelaProf.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tabelaProf.getSelectedRow();
				int colunaId = (int) tabelaProf.getValueAt(linha, 0);
				PROFESSOR_SELECIONADO = ListaProf.stream().filter(id -> id.getId() == colunaId).findFirst().get();

				//carregar os dados nos campos
				txtNomeProf.setText(PROFESSOR_SELECIONADO.getNome());
				txtIdadeProf.setText(String.valueOf(PROFESSOR_SELECIONADO.getIdade()));
				txtsalarioProf.setText(String.valueOf(PROFESSOR_SELECIONADO.getSalario()));
				txtEndeProf.setText(PROFESSOR_SELECIONADO.getEndereco());
				txtFormProf.setText(PROFESSOR_SELECIONADO.getFormacao());
			}
		});
	}

    //Organiza Componentes
	public void preparaPaineis() {

		JPprofessor.setLayout(new GridLayout(6, 1));
		JPprofessor.add(JLnomeProf);
		JPprofessor.add(txtNomeProf);
		JPprofessor.add(JLIdaProf);
		JPprofessor.add(txtIdadeProf);
		JPprofessor.add(JLSalarioProf);
		JPprofessor.add(txtsalarioProf);
		JPprofessor.add(JLendeProf);
		JPprofessor.add(txtEndeProf);
		JPprofessor.add(JLFormProf);
		JPprofessor.add(txtFormProf);
		
		JPbotoes.setLayout(new FlowLayout());
		JPbotoes.add(btAdicionarProf);
		JPbotoes.add(btDeletar);
		JPbotoes.add(btAtualizarProf); 
        JPbotoes.add(btSair);
        JPbotoes.add(btLimpar);
		
	}

    //Configura Janela
	public void preparaJanela() {
		
		janelaProf.setLayout(new BorderLayout());

		janelaProf.add(JPprofessor, BorderLayout.PAGE_START);
		janelaProf.add(JPbotoes, BorderLayout.PAGE_END);
		janelaProf.add(tabelaProfessor, BorderLayout.CENTER);
		listarProfessores(modelTableProf);

		janelaProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaProf.setSize(512,512);
		janelaProf.setLocationRelativeTo(null);
		janelaProf.setVisible(true);
	}

	public void listarProfessores(DefaultTableModel modeloTabela){
		modeloTabela.setNumRows(0);
		ListaProf.forEach(professor -> {
			long id = professor.getId();
			String nome = professor.getNome();
			int idade = professor.getIdade();
			Double salario = professor.getSalario();
			String endereco = professor.getEndereco();
			String formacao = professor.getFormacao();

			modeloTabela.addRow(new Object []{
				id, nome, idade, salario, endereco, formacao
			});
		});
	}

    public void sair() {
		btSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				//Abre o menu denovo
				Program.window.renderizaJanela();
				//esconde a janela atual
				janelaProf.setVisible(false);
				
			}
		});
	}

    public void limparCampos() {
		btLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNomeProf.setText("");
				txtEndeProf.setText("");
				txtFormProf.setText("");
				txtIdadeProf.setText("");
				txtsalarioProf.setText("");
			}
		});
	}

	public void addprofessor() {
		btAdicionarProf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//Criar um objeto (entidade) professor com os dados entrados no JTExtField, o primeiro parametro e um exemplo!
				Teacher pf = new Teacher(txtNomeProf.getText(), Integer.parseInt(txtIdadeProf.getText()),
				Double.parseDouble(txtsalarioProf.getText()), txtFormProf.getText(), txtEndeProf.getText());
				//Quando cirada a classe DAO com o CRUD, basta chamar e executar o inserir passando o objeto pf que e professor.
				TeacherDAO pdao = new TeacherDAO();
				pdao.inserir(pf);
				ListaProf = new ArrayList<>(pdao.listar());
				listarProfessores(modelTableProf);
			}
		});
	}

    public void renderizaJanela() {
		criaComponentes();
		preparaJanela();
		preparaPaineis();
		sair();
		limparCampos();
	}
}
