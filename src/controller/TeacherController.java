package controller;

import java.awt.Component;

import javax.swing.JOptionPane;

import database.repository.TeacherDAO;
import model.Teacher;
import view.TeacherPanel;

public class TeacherController {

    private TeacherDAO teacherDAO;

    private TeacherPanel panel;

    public TeacherController(TeacherPanel teacherFrame) {

        panel = teacherFrame;

        panel.submitTeacher(e -> {

            String graduation = this.panel.getTeacherGraduationField();
            double salary = Double.parseDouble(this.panel.getTeacherSalaryField());
            String name = this.panel.getTeacherNameField();
            int age = Integer.parseInt(this.panel.getTeacherAgeField());
            String address = this.panel.getTeacherAddressField();

            if (graduation.isEmpty()) {
                JOptionPane.showMessageDialog((Component) teacherFrame.getWindow(), "Insira o campo formação", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (this.panel.getTeacherSalaryField().isEmpty()) {
                JOptionPane.showMessageDialog((Component) teacherFrame.getWindow(), "Insira o campo salário", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (name.isEmpty()) {
                JOptionPane.showMessageDialog((Component) teacherFrame.getWindow(), "Insira o campo nome", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (this.panel.getTeacherAgeField().isEmpty()) {
                JOptionPane.showMessageDialog((Component) teacherFrame.getWindow(), "Insira o campo idade", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (address.isEmpty()) {
                JOptionPane.showMessageDialog((Component) teacherFrame.getWindow(), "Insira o campo endereço", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.teacherDAO.inserir(new Teacher(graduation, age, salary, name, address));
            this.panel.reset();
        });
    }
}
