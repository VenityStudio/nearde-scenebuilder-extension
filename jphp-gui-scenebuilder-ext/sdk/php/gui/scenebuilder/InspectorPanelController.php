<?php

namespace php\gui\scenebuilder;


use php\gui\UXParent;

class InspectorPanelController
{
    /**
     * InspectorPanelController constructor.
     * @param EditorController $controller
     */
    public function __construct(EditorController $controller) {}

    /**
     * @var string
     */
    public $searchPattern;

    /**
     * @return UXParent
     */
    public function getPanelRoot() : UXParent {}
}