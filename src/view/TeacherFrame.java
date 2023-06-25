package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import database.repository.TeacherDAO;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionListener;

public class TeacherFrame extends JPanel{
    
	private JPanel panelTeacher;
	private JPanel panelButton;
	private JFrame windowTeacher;

	private JTextField teacherNameField;
	private JTextField teacherAgeField;
	private JTextField teacherSalaryField;
	private JTextField teacherAddressField;
	private JTextField teacherGraduationField;
	
	private JButton teacherAddButton;
	private JButton teacherUpdateButton;
    private JButton teacherExitButton;
    private JButton teacherCleanButton;
	private JButton teacherDeleteButton;

	DefaultTableModel tableModel;
	JTable table;
	private String []columns = {"id", "nome", "idade", "salario", "endereco", "formacao", "data de criação"};

	private List<Teacher> listTeacher;

    public TeacherFrame() {

		TeacherDAO teacherDAO = new TeacherDAO();
		listTeacher = new ArrayList<Teacher>(teacherDAO.listar());
		panelTeacher = new JPanel();
		panelButton= new JPanel();
		windowTeacher = new JFrame();

		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);

		for (String column : columns) {
			tableModel.addColumn(column);
		}

		JLabel teacherNameLabel = new JLabel("Nome");
		JLabel teacherAgeLabel = new JLabel("Idade");
		JLabel teacherSalaryLabel = new JLabel("Salário");
		JLabel teacherAddressLabel = new JLabel("Endereço");
		JLabel teacherGraduationLabel = new JLabel("Formação");

		teacherNameField = new JTextField(25);
		teacherAgeField = new JTextField(25);
		teacherSalaryField = new JTextField(25);
		teacherAddressField = new JTextField(25);
		teacherGraduationField = new JTextField(25);

		teacherAddButton = new JButton("adicionar", null);
		teacherAddButton.setPreferredSize(new Dimension(278, 40));

		teacherUpdateButton = new JButton("Atualizar", null);
		teacherUpdateButton.setPreferredSize(new Dimension(278, 40));

		teacherExitButton = new JButton("Sair", null);
		teacherExitButton.setPreferredSize(new Dimension(278, 40));

		teacherCleanButton = new JButton("Limpar", null);
		teacherCleanButton.setPreferredSize(new Dimension(278, 40));

		teacherDeleteButton = new JButton("Remover", null);
		teacherDeleteButton.setPreferredSize(new Dimension(278, 40));

		panelTeacher.setLayout(new GridLayout(6, 1));
		panelTeacher.add(teacherNameLabel);
		panelTeacher.add(teacherNameField);

		panelTeacher.add(teacherAgeLabel);
		panelTeacher.add(teacherAgeField);

		panelTeacher.add(teacherSalaryLabel);
		panelTeacher.add(teacherSalaryField);

		panelTeacher.add(teacherAddressLabel);
		panelTeacher.add(teacherAddressField);

		panelTeacher.add(teacherGraduationLabel);
		panelTeacher.add(teacherGraduationField);

		panelButton.setLayout(new FlowLayout());
		panelButton.add(teacherAddButton);
		panelButton.add(teacherUpdateButton);
		panelButton.add(teacherExitButton);
		panelButton.add(teacherCleanButton);
		panelButton.add(teacherDeleteButton);

		int FRAME_WIDHT = 1200;
        int FRAME_HEIGHT = 700;
		
		windowTeacher.setLayout(new BorderLayout());

		windowTeacher.add(panelTeacher, BorderLayout.PAGE_START);
		windowTeacher.add(panelButton, BorderLayout.PAGE_END);
		windowTeacher.add(table, BorderLayout.CENTER);
		showAll(tableModel);

		windowTeacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowTeacher.setSize(FRAME_WIDHT, FRAME_HEIGHT);
		windowTeacher.setLocationRelativeTo(null);
		windowTeacher.setVisible(true);
    }

	public String getTeacherNameField() {
		return teacherNameField.getText();
	}

	public String getTeacherAgeField() {
		return teacherAgeField.getText();
	}

	public String getTeacherSalaryField() {
		return teacherSalaryField.getText();
	}

	public String getTeacherAddressField() {
		return teacherAddressField.getText();
	}

	public String getTeacherGraduationField() {
		return teacherGraduationField.getText();
	}

	public void submitTeacher(ActionListener actionListener) {
		teacherAddButton.addActionListener(actionListener);
		listTeacher = new ArrayList<Teacher>(new TeacherDAO().listar());
		showAll(tableModel);
	}

	public void updateTeacher(ActionListener actionListener) {
		teacherUpdateButton.addActionListener(actionListener);
	}

	public void exitTeacher(ActionListener actionListener) {
		teacherExitButton.addActionListener(actionListener);
	}

	public void deleteTeacher(ActionListener actionListener) {
		teacherDeleteButton.addActionListener(actionListener);
		listTeacher = new ArrayList<Teacher>(new TeacherDAO().listar());
		showAll(tableModel);
	}

	public void reset() {
		teacherNameField.setText("");
		teacherAgeField.setText("");
		teacherSalaryField.setText("");
		teacherAddressField.setText("");
		teacherGraduationField.setText("");
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
}
