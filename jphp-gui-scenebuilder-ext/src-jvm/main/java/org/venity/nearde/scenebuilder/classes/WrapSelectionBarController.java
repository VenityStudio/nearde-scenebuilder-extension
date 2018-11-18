package org.venity.nearde.scenebuilder.classes;

import com.oracle.javafx.scenebuilder.kit.editor.EditorController;
import com.oracle.javafx.scenebuilder.kit.selectionbar.SelectionBarController;
import javafx.scene.Parent;
import org.venity.nearde.scenebuilder.SceneBuilderExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("SelectionBarController")
@Reflection.Namespace(SceneBuilderExtension.NS)
public class WrapSelectionBarController extends BaseWrapper<SelectionBarController> {

    public WrapSelectionBarController(Environment env, SelectionBarController wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapSelectionBarController(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(EditorController editorController) {
        __wrappedObject = new SelectionBarController(editorController);
    }

    @Reflection.Signature
    public Parent getPanelRoot() {
        return __wrappedObject.getPanelRoot();
    }
}
