<?php

namespace php\gui\scenebuilder;


use php\gui\UXControl;
use php\gui\UXParent;

class HierarchyPanelController
{
    /**
     * HierarchyPanelController constructor.
     * @param EditorController $controller
     */
    public function __construct(EditorController $controller) {}

    /**
     * @return UXParent
     */
    public function getPanelRoot() : UXParent {}

    /**
     * @return UXControl
     */
    public function getPanelControl() : UXControl {}
}