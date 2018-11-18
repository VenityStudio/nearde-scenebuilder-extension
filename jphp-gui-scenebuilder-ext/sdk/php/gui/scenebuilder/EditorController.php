<?php

namespace php\gui\scenebuilder;

use php\gui\UXForm;
use php\net\URL;
use php\io\File;

class EditorController
{
    /**
     * @var float
     */
    public $defaultRootContainerHeight;

    /**
     * @var URL
     */
    public $fxmlLocation;

    /**
     * @var string
     */
    public $fxmlText;

    /**
     * @var UXForm
     */
    public $ownerWindow;

    /**
     * @return bool
     */
    public function canGetFxmlText() : bool {}

    /**
     * @return bool
     */
    public function canUndo() : bool {}

    /**
     * @return string
     */
    public function getUndoDescription() : string {}

    public function undo() : void {}

    /**
     * @return bool
     */
    public function canRedo() : bool {}

    /**
     * @return string
     */
    public function getRedoDescription() : string {}

    public function redo() : void {}

    public function clearUndoRedo() : void {}

    /**
     * @return bool
     */
    public function is3D() : bool {}

    /**
     * @return bool
     */
    public function isNode() : bool {}

    /**
     * @return bool
     */
    public function isSelectionNode() : bool {}

    public function loadFromFile(File $fxmlFile) : void {}
}