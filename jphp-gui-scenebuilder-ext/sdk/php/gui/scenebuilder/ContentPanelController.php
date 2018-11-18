<?php

namespace php\gui\scenebuilder;


use php\gui\paint\UXColor;
use php\gui\UXImage;
use php\gui\UXParent;

class ContentPanelController
{
    /**
     * ContentPanelController constructor.
     * @param EditorController $controller
     */
    public function __construct(EditorController $controller) {}

    /**
     * @var bool
     */
    public $outlinesVisible;

    /**
     * @var bool
     */
    public $guidesVisible;

    /**
     * @var bool
     */
    public $autoResize3DContent;

    /**
     * @var UXColor
     */
    public $pringColor;

    /**
     * @var UXColor
     */
    public $guidesColor;

    /**
     * @var float
     */
    public $scaling;

    /**
     * @var UXImage
     */
    public $workspaceBackground;

    public function scrollToSelection() : void {}

    /**
     * @param bool $applyCSS
     */
    public function layoutContent(bool $applyCSS) : void {}

    public function beginInteraction() : void {}

    public function endInteraction() : void {}

    /**
     * @return UXParent
     */
    public function getPanelRoot() : UXParent {}
}