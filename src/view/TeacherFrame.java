package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entity.Teacher;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class TeacherFrame {
    
	public JTable tabelaProf;
	public DefaultTableModel modelTableProf;
	private String []column = {"id", "nome", "idade", "salario", "endereco", "formacao", "data de criação"};
    
    private JFrame window;

	private JPanel panelTeacher;
	private JPanel panelButton;
	private JScrollPane tableTeacher;

	private JLabel teacherNameLabel;
	private JLabel teacherAgeLabel;
	private JLabel teacherSalaryLabel;
	private JLabel teacherAddressLabel;
	private JLabel teacherGraduationLabel;

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

	private static Teacher PROFESSOR_SELECIONADO;

	private List <Teacher> ListaProf;

    public TeacherFrame() {

    }
}
