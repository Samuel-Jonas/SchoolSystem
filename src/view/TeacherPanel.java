package view;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import database.repository.TeacherDAO;
import factories.GUIFactory;
import model.Teacher;
import components.buttons.Button;
import components.panels.Panel;
import components.tables.Table;
import components.frames.Frame;
import components.text.TextField;
import components.labels.Label;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionListener;

public class TeacherPanel extends Component {
    
	private Panel panelTeacher;
	private Panel panelButton;
	private Frame windowTeacher;

	private TextField teacherNameField;
	private TextField teacherAgeField;
	private TextField teacherSalaryField;
	private TextField teacherAddressField;
	private TextField teacherGraduationField;
	
	private Button teacherAddButton;
	private Button teacherUpdateButton;
    private Button teacherExitButton;
    private Button teacherCleanButton;
	private Button teacherDeleteButton;

	DefaultTableModel tableModel;
	Table table;
	private String []columns = {"id", "nome", "idade", "salario", "endereco", "formacao", "data de criação"};

	private List<Teacher> listTeacher;

    public TeacherPanel(GUIFactory factory) {

		TeacherDAO teacherDAO = new TeacherDAO();
		listTeacher = new ArrayList<Teacher>(teacherDAO.listar());
		panelTeacher = factory.createPanel();
		panelButton = factory.createPanel();
		windowTeacher = factory.createFrame("Professores");

		tableModel = new DefaultTableModel();
		table = factory.createTable(tableModel);

		for (String column : columns) {
			tableModel.addColumn(column);
		}

		Label teacherNameLabel = factory.createLabel("Nome");
		Label teacherAgeLabel = factory.createLabel("Idade");
		Label teacherSalaryLabel = factory.createLabel("Salário");
		Label teacherAddressLabel = factory.createLabel("Endereço");
		Label teacherGraduationLabel = factory.createLabel("Formação");

		teacherNameField = factory.createTextField(25);
		teacherAgeField = factory.createTextField(25);
		teacherSalaryField = factory.createTextField(25);
		teacherAddressField = factory.createTextField(25);
		teacherGraduationField = factory.createTextField(25);

		teacherAddButton = factory.createButton("Adicionar");
		teacherAddButton.setNewPreferredSize(new Dimension(278, 40));

		teacherUpdateButton = factory.createButton("Atualizar");
		teacherUpdateButton.setNewPreferredSize(new Dimension(278, 40));

		teacherExitButton = factory.createButton("Sair");
		teacherExitButton.setNewPreferredSize(new Dimension(278, 40));

		teacherCleanButton = factory.createButton("Limpar");
		teacherCleanButton.setNewPreferredSize(new Dimension(278, 40));

		teacherDeleteButton = factory.createButton("Remover");
		teacherDeleteButton.setNewPreferredSize(new Dimension(278, 40));

		panelTeacher.setNewLayout(new GridLayout(6, 1));
		panelTeacher.addComponent(teacherNameLabel);
		panelTeacher.addComponent(teacherNameField);

		panelTeacher.addComponent(teacherAgeLabel);
		panelTeacher.addComponent(teacherAgeField);

		panelTeacher.addComponent(teacherSalaryLabel);
		panelTeacher.addComponent(teacherSalaryField);

		panelTeacher.addComponent(teacherAddressLabel);
		panelTeacher.addComponent(teacherAddressField);

		panelTeacher.addComponent(teacherGraduationLabel);
		panelTeacher.addComponent(teacherGraduationField);

		panelButton.setNewLayout(new FlowLayout());
		panelButton.addComponent(teacherAddButton);
		panelButton.addComponent(teacherUpdateButton);
		panelButton.addComponent(teacherExitButton);
		panelButton.addComponent(teacherCleanButton);
		panelButton.addComponent(teacherDeleteButton);

		int FRAME_WIDHT = 1200;
        int FRAME_HEIGHT = 700;
		
		windowTeacher.setNewLayout(new BorderLayout());

		windowTeacher.addComponentsAndConstraints(panelTeacher, BorderLayout.PAGE_START);
		windowTeacher.addComponentsAndConstraints(panelButton, BorderLayout.PAGE_END);
		windowTeacher.addComponentsAndConstraints(table, BorderLayout.CENTER);
		showAll(tableModel);

		windowTeacher.setNewDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowTeacher.setNewSize(FRAME_WIDHT, FRAME_HEIGHT);
		windowTeacher.setNewLocationRelativeTo(null);
		windowTeacher.setNewVisible(true);
    }

	public String getTeacherNameField() {
		return teacherNameField.getNewText();
	}

	public String getTeacherAgeField() {
		return teacherAgeField.getNewText();
	}

	public String getTeacherSalaryField() {
		return teacherSalaryField.getNewText();
	}

	public String getTeacherAddressField() {
		return teacherAddressField.getNewText();
	}

	public String getTeacherGraduationField() {
		return teacherGraduationField.getNewText();
	}

	public void submitTeacher(ActionListener actionListener) {
		teacherAddButton.addNewActionListener(actionListener);
		listTeacher = new ArrayList<Teacher>(new TeacherDAO().listar());
		showAll(tableModel);
	}

	public void updateTeacher(ActionListener actionListener) {
		teacherUpdateButton.addNewActionListener(actionListener);
	}

	public void exitTeacher(ActionListener actionListener) {
		teacherExitButton.addNewActionListener(actionListener);
	}

	public void deleteTeacher(ActionListener actionListener) {
		teacherDeleteButton.addNewActionListener(actionListener);
		listTeacher = new ArrayList<Teacher>(new TeacherDAO().listar());
		showAll(tableModel);
	}

	public void render() {
		setVisible(true);
	}

	public void reset() {
		teacherNameField.setNewText("");
		teacherAgeField.setNewText("");
		teacherSalaryField.setNewText("");
		teacherAddressField.setNewText("");
		teacherGraduationField.setNewText("");
	}

	public void showAll(DefaultTableModel tableModel){
		tableModel.setNumRows(0);
		listTeacher.forEach(professor -> {
			long id = professor.getId();
			String nome = professor.getNome();
			int idade = professor.getIdade();
			Double salario = professor.getSalario();
			String endereco = professor.getEndereco();
			String formacao = professor.getFormacao();
			String date = professor.getCreationDate();

			tableModel.addRow(new Object []{
				id, nome, idade, salario, endereco, formacao, date
			});
		});
	}

	public Frame getWindow() {
		return windowTeacher;
	}
}
