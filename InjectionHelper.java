
import java.awt.Image;

import javax.swing.JComponent;

public class InjectionHelper {

    private static Image _sImageInstance;
    private static JComponent _sComponent;

    public static DrawerArea injectDraweArea() {
        return new DrawerArea(injectDrawerEngine());
    }

    public static Image injectImage(JComponent component) {
        if (_sImageInstance == null || component != _sComponent) {
            component.createImage(component.getSize().width, component.getSize().height);
            _sComponent = component;
        }
        return _sImageInstance;
    }

    public static DrawerEngine injectDrawerEngine() {
        return new DrawerEngineImpl(injectImage(_sComponent));
    }

}