package org.venity.nearde.scenebuilder;

import com.oracle.javafx.scenebuilder.app.DocumentWindowController;
import com.oracle.javafx.scenebuilder.app.SceneBuilderApp;
import com.oracle.javafx.scenebuilder.kit.editor.EditorController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.content.ContentPanelController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.hierarchy.AbstractHierarchyPanelController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.hierarchy.HierarchyPanelController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.inspector.InspectorPanelController;
import com.oracle.javafx.scenebuilder.kit.editor.panel.library.LibraryPanelController;
import com.oracle.javafx.scenebuilder.kit.selectionbar.SelectionBarController;
import org.venity.nearde.scenebuilder.classes.*;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class SceneBuilderExtension extends Extension {
    public static final String NS = "php\\gui\\scenebuilder";
    
    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }
    
    @Override
    public void onRegister(CompileScope scope) {
        registerWrapperClass(scope, EditorController.class, WrapEditorController.class);
        registerWrapperClass(scope, ContentPanelController.class, WrapContentPanelController.class);
        registerWrapperClass(scope, LibraryPanelController.class, WrapLibraryPanelController.class);
        registerWrapperClass(scope, AbstractHierarchyPanelController.class, WrapHierarchyPanelController.class);
        registerWrapperClass(scope, InspectorPanelController.class, WrapInspectorPanelController.class);
        registerWrapperClass(scope, SelectionBarController.class, WrapSelectionBarController.class);

        registerClass(scope, SceneBuilder.class);
    }
}