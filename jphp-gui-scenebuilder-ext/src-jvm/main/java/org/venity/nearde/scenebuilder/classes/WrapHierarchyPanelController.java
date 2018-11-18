package org.venity.nearde.scenebuilder.classes;

import com.oracle.javafx.scenebuilder.kit.editor.EditorController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.hierarchy.AbstractHierarchyPanelController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.hierarchy.HierarchyPanelController;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.stage.Window;
import org.venity.nearde.scenebuilder.SceneBuilderExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("HierarchyPanelController")
@Reflection.Namespace(SceneBuilderExtension.NS)
public class WrapHierarchyPanelController extends BaseWrapper<AbstractHierarchyPanelController> {
    public WrapHierarchyPanelController(Environment env, AbstractHierarchyPanelController wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapHierarchyPanelController(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(EditorController editorController) {
        __wrappedObject = new HierarchyPanelController(editorController);
    }

    @Reflection.Signature
    public Parent getPanelRoot() {
        return __wrappedObject.getPanelRoot();
    }
}
