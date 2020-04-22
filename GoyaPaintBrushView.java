import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GoyaPaintBrushView implements ActionListener {

    JButton clearBtn;
    DrawerArea drawerArea;
    JFrame guiFrame;
    Container guiContent;
  

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearBtn) {
            drawerArea.clearDrawerArea();
        }
    }

    public static void main(String[] args) {
        new GoyaPaintBrushView().showScreen();
    }

    private void createGuiComponents(){
        guiFrame = new JFrame(Constants.FRAME_TITLE);
        guiContent = guiFrame.getContentPane();
        guiContent.setLayout(new BorderLayout());
    }

    private void configureGuiControls(){
        clearBtn = new JButton(Constants.CLEAR_BTN_LABEL);
        JPanel guiControls = new JPanel();
        clearBtn.addActionListener(this);
        guiControls.add(clearBtn);
        guiContent.add(guiControls, BorderLayout.NORTH);
    }

    private void configureFrameVisibilityOptions(){
        guiFrame.setSize(Constants.FRAME_WIDHT, Constants.FRAME_HEIGHT);
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setVisible(true);
    }

    private void addDrawerArea(){
        drawerArea = new DrawerArea();
        guiContent.add(drawerArea, BorderLayout.CENTER);
    }

    public void showScreen() {
        createGuiComponents();
        configureGuiControls();
        addDrawerArea();
        configureFrameVisibilityOptions();
    }

}