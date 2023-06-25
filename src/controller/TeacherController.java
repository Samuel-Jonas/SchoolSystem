package controller;

import javax.swing.JOptionPane;

import database.repository.TeacherDAO;
import model.Teacher;
import view.TeacherFrame;

public class TeacherController {

    private TeacherFrame teacherFrame;
    private TeacherDAO teacherDAO;

    public TeacherController(TeacherFrame teacherFrame) {
        this.teacherFrame = teacherFrame;

        this.teacherFrame.submitTeacher(e -> {

            String graduation = this.teacherFrame.getTeacherGraduationField();
            double salary = Double.parseDouble(this.teacherFrame.getTeacherSalaryField());
            String name = this.teacherFrame.getTeacherNameField();
            int age = Integer.parseInt(this.teacherFrame.getTeacherAgeField());
            String address = this.teacherFrame.getTeacherAddressField();

            if (graduation.isEmpty()) {
                JOptionPane.showMessageDialog(this.teacherFrame, "Insira o campo formação", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (this.teacherFrame.getTeacherSalaryField().isEmpty()) {
                JOptionPane.showMessageDialog(this.teacherFrame, "Insira o campo salário", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this.teacherFrame, "Insira o campo nome", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (this.teacherFrame.getTeacherAgeField().isEmpty()) {
                JOptionPane.showMessageDialog(this.teacherFrame, "Insira o campo idade", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (address.isEmpty()) {
                JOptionPane.showMessageDialog(this.teacherFrame, "Insira o campo endereço", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.teacherDAO.inserir(new Teacher(graduation, age, salary, name, address));
            this.teacherFrame.reset();
        });
    }
}
