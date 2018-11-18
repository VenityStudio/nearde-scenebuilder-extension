<?php

namespace php\gui\scenebuilder;

use php\io\File;

class SceneBuilder
{
    /**
     * SceneBuilder constructor.
     * @param File $fxmlFile
     */
    public function __construct(File $fxmlFile)
    {

    }

    /**
     * @return ContentPanelController
     */
    public function getContentPanelController() : ContentPanelController {}

    /**
     * @return EditorController
     */
    public function getEditorController() : EditorController {}

    /**
     * @return HierarchyPanelController
     */
    public function getHierarchyPanelController() : HierarchyPanelController {}

    /**
     * @return InspectorPanelController
     */
    public function getInspectorPanelController() : InspectorPanelController {}

    /**
     * @return LibraryPanelController
     */
    public function getLibraryPanelController() : LibraryPanelController {}

    /**
     * @return SelectionBarController
     */
    public function getSelectionBarController() : SelectionBarController {}
}