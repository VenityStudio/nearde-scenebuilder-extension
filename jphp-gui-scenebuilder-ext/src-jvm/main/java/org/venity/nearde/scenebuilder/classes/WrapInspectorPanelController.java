package org.venity.nearde.scenebuilder.classes;

import com.oracle.javafx.scenebuilder.kit.editor.EditorController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.inspector.InspectorPanelController;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import org.venity.nearde.scenebuilder.SceneBuilderExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("InspectorPanelController")
@Reflection.Namespace(SceneBuilderExtension.NS)
public class WrapInspectorPanelController extends BaseWrapper<InspectorPanelController> {
    public WrapInspectorPanelController(Environment env, InspectorPanelController wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapInspectorPanelController(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(EditorController editorController) {
        __wrappedObject = new InspectorPanelController(editorController);
    }

    @Reflection.Signature
    public Parent getPanelRoot() {
        return __wrappedObject.getPanelRoot();
    }

    public interface WrappedInterface {
        @Reflection.Property String searchPattern();
    }
}
