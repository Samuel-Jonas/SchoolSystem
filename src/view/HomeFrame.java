package view;

import javax.swing.*;

import controller.TeacherController;

import java.awt.*;

public class HomeFrame extends JFrame{
    CardLayout cardLayout;

    public HomeFrame() {
        super("Sistema Estudantil");

        cardLayout = new CardLayout();
        Form form = new Form();
        UserDetails userDetails = new UserDetails();
        TeacherFrame teacherFrame = new TeacherFrame();

        setLayout(cardLayout);

        new TeacherController(teacherFrame);

        add(form, "form");
        add(userDetails, "user details");
        add(teacherFrame, "teacher frame");

        form.viewUsers(e -> cardLayout.show(HomeFrame.this.getContentPane(), "teacher frame"));
        userDetails.backButton(e -> cardLayout.show(HomeFrame.this.getContentPane(), "form"));

        ImageIcon imageIcon = new ImageIcon("src/assets/3314970-middle.png");

        setIconImage(imageIcon.getImage());
        int FRAME_WIDHT = 1200;
        int FRAME_HEIGHT = 700;

        setSize(FRAME_WIDHT, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
