<?php

namespace php\gui\scenebuilder;


use php\gui\UXParent;

class SelectionBarController
{
    /**
     * SelectionBarController constructor.
     * @param EditorController $controller
     */
    public function __construct(EditorController $controller) {}

    /**
     * @return UXParent
     */
    public function getPanelRoot() : UXParent {}
}