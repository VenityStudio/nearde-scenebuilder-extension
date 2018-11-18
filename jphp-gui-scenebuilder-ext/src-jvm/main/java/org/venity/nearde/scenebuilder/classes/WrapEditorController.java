package org.venity.nearde.scenebuilder.classes;

import com.oracle.javafx.scenebuilder.kit.editor.EditorController;
import com.oracle.javafx.scenebuilder.kit.fxom.FXOMDocument;
import org.venity.nearde.scenebuilder.SceneBuilderExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Reflection.Name("EditorController")
@Reflection.Namespace(SceneBuilderExtension.NS)
public class WrapEditorController extends BaseWrapper<EditorController> {
    public WrapEditorController(Environment env, EditorController wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapEditorController(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct() {
        __wrappedObject = new EditorController();
    }

    @Reflection.Setter
    public void setFxmlText(String fxmlText) throws IOException {
        __wrappedObject.setFxmlText(fxmlText, true);
    }

    @Reflection.Signature
    public void loadFromFile(File file) throws IOException {
        URL fxmlURL = file.toURI().toURL();
        String fxmlText = FXOMDocument.readContentFromURL(fxmlURL);
        __wrappedObject.setFxmlTextAndLocation(fxmlText, fxmlURL, false);
    }

    @Reflection.Getter
    public String getFxmlText() {
        return __wrappedObject.getFxmlText();
    }

    interface WrappedInterface {
        @Reflection.Property double defaultRootContainerHeight();

        boolean canGetFxmlText();

        boolean canUndo();
        String getUndoDescription();
        void undo();

        boolean canRedo();
        String getRedoDescription();
        void redo();

        void clearUndoRedo();

        boolean is3D();
        boolean isNode();
        boolean isSelectionNode();
    }
}
