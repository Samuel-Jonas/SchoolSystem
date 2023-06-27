package view;

import java.awt.CardLayout;

import javax.swing.*;

import components.frames.Frame;
import controller.TeacherController;
import factories.GUIFactory;

public class HomeFrame {
    CardLayout cardLayout;

    private Frame frame;

    public HomeFrame(GUIFactory factory) {
        frame = factory.createFrame("Sistema estudantil");

        cardLayout = new CardLayout();
        Form form = new Form();
        UserDetails userDetails = new UserDetails();
        TeacherPanel teacherFrame = new TeacherPanel();

        frame.setLayout();

        new TeacherController(teacherFrame);

        frame.addComponentsAndConstraints(form, "form");
        frame.addComponentsAndConstraints(userDetails, "user details");
        frame.addComponentsAndConstraints(teacherFrame, "teacher frame");

        form.viewUsers(e -> cardLayout.show(frame.getContentPane(), "teacher frame"));
        userDetails.backButton(e -> cardLayout.show(frame.getContentPane(), "form"));

        ImageIcon imageIcon = new ImageIcon("src/assets/3314970-middle.png");

        frame.setIconImage(imageIcon.getImage());
        int FRAME_WIDHT = 1200;
        int FRAME_HEIGHT = 700;

        frame.setSize(FRAME_WIDHT, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
