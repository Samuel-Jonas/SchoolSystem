package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import components.buttons.Button;
import components.frames.Frame;
import components.panels.Panel;
import controller.TeacherController;
import factories.GUIFactory;

public class HomeFrame {

    private Frame frame;

    public HomeFrame(GUIFactory factory) {
        frame = factory.createFrame("Sistema estudantil");

        //cardLayout = new CardLayout();
        //Form form = new Form();
        //UserDetails userDetails = new UserDetails();


        Button teacherButton = factory.createButton("Professores");
        teacherButton.setSize();

        teacherButton.addNewActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                TeacherPanel teacherFrame = new TeacherPanel(factory);
                new TeacherController(teacherFrame);
                 
                frame.setNewVisible(false);
            }
        });

        Panel menuPanel = factory.createPanel();

        menuPanel.setNewLayout(new FlowLayout());
        menuPanel.addComponent(teacherButton);

        //frame.addComponentsAndConstraints(form, "form");
        //frame.addComponentsAndConstraints(userDetails, "user details");
        //frame.addComponent(teacherFrame);
        frame.addComponent(menuPanel);

        //form.viewUsers(e -> cardLayout.show(frame.getNewContentPane(), "teacher frame"));
        //userDetails.backButton(e -> cardLayout.show(frame.getNewContentPane(), "form"));

        ImageIcon imageIcon = new ImageIcon("src/assets/3314970-middle.png");

        frame.setNewIconImage(imageIcon.getImage());
        int FRAME_WIDHT = 1200;
        int FRAME_HEIGHT = 700;

        frame.setNewSize(FRAME_WIDHT, FRAME_HEIGHT);
        frame.setNewDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setNewVisible(true);

    }
}
