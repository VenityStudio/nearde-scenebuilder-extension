package org.venity.nearde.scenebuilder.classes;

import com.oracle.javafx.scenebuilder.kit.editor.EditorController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.content.ContentPanelController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.hierarchy.AbstractHierarchyPanelController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.hierarchy.HierarchyPanelController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.hierarchy.treeview.HierarchyTreeViewController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.inspector.InspectorPanelController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.library.LibraryPanelController;
import com.oracle.javafx.scenebuilder.kit.preferences.MavenPreferences;
import com.oracle.javafx.scenebuilder.kit.selectionbar.SelectionBarController;
import javafx.scene.Parent;
import org.venity.nearde.scenebuilder.SceneBuilderExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

@Reflection.Name("SceneBuilder")
@Reflection.Namespace(SceneBuilderExtension.NS)
public class SceneBuilder extends BaseObject {

    private final EditorController editorController
            = new EditorController();
    private final AbstractHierarchyPanelController hiearchyPanelController
            = new HierarchyTreeViewController(editorController);
    private final ContentPanelController contentPanelController
            = new ContentPanelController(editorController);
    private final InspectorPanelController inspectorPanelController
            = new InspectorPanelController(editorController);
    private final LibraryPanelController libraryPanelController
            = new LibraryPanelController(editorController, new MavenPreferences());
    private final SelectionBarController selectionBarController
            = new SelectionBarController(editorController);

    public SceneBuilder(Environment env) {
        super(env);
    }

    protected SceneBuilder(ClassEntity entity) {
        super(entity);
    }

    public SceneBuilder(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(File fxmlFile) throws IOException {
        String fxmlText = readContentFromFile(fxmlFile);
        URL fxmlLocation = fxmlFile.toURI().toURL();
        editorController.setFxmlTextAndLocation(fxmlText, fxmlLocation);
    }

    @Reflection.Signature
    public EditorController getEditorController() {
        return editorController;
    }

    @Reflection.Signature
    public ContentPanelController getContentPanelController() {
        return contentPanelController;
    }

    @Reflection.Signature
    public AbstractHierarchyPanelController getHierarchyPanelController() {
        return hiearchyPanelController;
    }

    @Reflection.Signature
    public InspectorPanelController getInspectorPanelController() {
        return inspectorPanelController;
    }

    @Reflection.Signature
    public LibraryPanelController getLibraryPanelController() {
        return libraryPanelController;
    }

    @Reflection.Signature
    public SelectionBarController getSelectionBarController() {
        return selectionBarController;
    }

    private String readContentFromFile(File file) throws IOException {
        final byte[] buffer;

        buffer = new byte[(int)file.length()];
        try (DataInputStream is = new DataInputStream(new FileInputStream(file))) {
            is.readFully(buffer);
        }

        return new String(buffer, Charset.forName("UTF-8"));
    }
}
