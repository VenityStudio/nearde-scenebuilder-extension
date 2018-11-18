package org.venity.nearde.scenebuilder.classes;

import com.oracle.javafx.scenebuilder.kit.editor.EditorController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.library.LibraryPanelController;
import com.oracle.javafx.scenebuilder.kit.preferences.MavenPreferences;
import javafx.scene.Parent;
import javafx.stage.Window;
import org.venity.nearde.scenebuilder.SceneBuilderExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("LibraryPanelController")
@Reflection.Namespace(SceneBuilderExtension.NS)
public class WrapLibraryPanelController extends BaseWrapper<LibraryPanelController> {
    public WrapLibraryPanelController(Environment env, LibraryPanelController wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapLibraryPanelController(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(EditorController controller) {
        __wrappedObject = new LibraryPanelController(controller, new MavenPreferences());
    }

    @Reflection.Signature
    public Parent getPanelRoot() {
        return __wrappedObject.getPanelRoot();
    }

    public interface WrappedInterface {
        @Reflection.Property String searchPattern();
    }
}
