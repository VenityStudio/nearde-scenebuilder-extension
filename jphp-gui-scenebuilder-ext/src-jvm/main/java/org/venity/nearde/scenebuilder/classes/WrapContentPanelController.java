package org.venity.nearde.scenebuilder.classes;

import com.oracle.javafx.scenebuilder.kit.editor.EditorController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.content.ContentPanelController;
import com.oracle.javafx.scenebuilder.kit.fxom.FXOMDocument;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import org.venity.nearde.scenebuilder.SceneBuilderExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.io.IOException;

@Reflection.Name("ContentPanelController")
@Reflection.Namespace(SceneBuilderExtension.NS)
public class WrapContentPanelController extends BaseWrapper<ContentPanelController> {
    public WrapContentPanelController(Environment env, ContentPanelController wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapContentPanelController(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(EditorController controller) throws IOException {
        System.out.println(controller.getFxomDocument());
        __wrappedObject = new ContentPanelController(controller);
    }

    @Reflection.Signature
    public Parent getPanelRoot() {
        return __wrappedObject.getPanelRoot();
    }

    interface WrappedInterface {
        @Reflection.Property boolean outlinesVisible();
        @Reflection.Property boolean guidesVisible();
        @Reflection.Property boolean autoResize3DContent();

        @Reflection.Property double scaling();

        @Reflection.Property Image workspaceBackground();

        @Reflection.Signature void scrollToSelection();
        @Reflection.Signature void layoutContent(boolean applyCSS);
        @Reflection.Signature void beginInteraction();
        @Reflection.Signature void endInteraction();
    }
}
