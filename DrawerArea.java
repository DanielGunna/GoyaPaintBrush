import javax.swing.JComponent;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class DrawerArea extends JComponent {

    private static final long serialVersionUID = 666L;
    private Image _canvasImage;
    private Graphics2D _graphicEngine;
    private int _cursorCurrentX;
    private int _cursorCurrentY;
    private int _cursorPreviousX;
    private int _cursorPreviousY;

    public DrawerArea() {
        setDoubleBuffered(false);
        addOnMousePressedEvent();
        addOnMouseDraggedEvent();
    }


    private void addOnMousePressedEvent() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                _cursorPreviousX = e.getX();
                _cursorCurrentY = e.getY();
            }
        });
    }

    private void addOnMouseDraggedEvent(){
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                drawOnMouseDragged(e);
            }
        });
    }

    private void drawOnMouseDragged(MouseEvent event) {
        if (_graphicEngine != null) {
            _cursorCurrentX = event.getX();
            _cursorCurrentY = event.getY();
            _graphicEngine.drawLine(_cursorPreviousX, _cursorPreviousY, _cursorCurrentX, _cursorCurrentY);
            repaint();
            _cursorPreviousX = _cursorCurrentX;
            _cursorPreviousY = _cursorCurrentY;
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        checkIfImageCreated();
        graphics.drawImage(_canvasImage, 0, 0, null);
    }

    private void checkIfImageCreated() {
        if (_canvasImage == null) {
            _canvasImage = createImage(getSize().width, getSize().height);
            _graphicEngine = (Graphics2D) _canvasImage.getGraphics();
            _graphicEngine.setPaint(Color.BLACK);
            _graphicEngine.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clearDrawerArea();
        }
    }

    public void clearDrawerArea() {
        _graphicEngine.setPaint(Color.WHITE);
        _graphicEngine.fillRect(0, 0, getSize().width, getSize().height);
        _graphicEngine.setPaint(Color.black);
        repaint();
    }

}