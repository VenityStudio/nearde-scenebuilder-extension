<?php

namespace ide\editors;

use ide\Ide;
use php\gui\layout\UXHBox;
use php\gui\layout\UXVBox;
use php\gui\scenebuilder\SceneBuilder;
use php\gui\UXButton;
use php\gui\UXImage;
use php\gui\UXNode;
use php\gui\UXSplitPane;
use php\io\File;
use php\io\Stream;
use php\lib\fs;
use php\lib\str;

class SceneBuilderEditor extends AbstractEditor
{
    /**
     * @var SceneBuilder
     */
    private $editor;

    public function __construct(string $file)
    {
        parent::__construct($file);

        $this->editor = new SceneBuilder(new File($file));
    }

    public function load()
    {

    }

    public function save()
    {
        Stream::putContents($this->file, $this->editor->getEditorController()->fxmlText);
    }

    /**
     * @return UXNode
     * @throws \Exception
     */
    public function makeUi()
    {
        $panel = $this->editor->getContentPanelController();

        $box = new UXVBox();
        $box->add($topbox = new UXHBox([
            $undo = new UXButton(),
            $redo = new UXButton(),
            $this->editor->getSelectionBarController()->getPanelRoot()
        ]));
        $box->add($mainSplit = new UXSplitPane([
            $split = new UXSplitPane([
                $this->editor->getLibraryPanelController()->getPanelRoot(),
                $this->editor->getHierarchyPanelController()->getPanelRoot()
            ]),
            $panel->getPanelRoot(),
            $this->editor->getInspectorPanelController()->getPanelRoot()
        ]));

        if (fs::isFile(Ide::get()->getUserConfigValue("extension.scenebuilder.content.background")))
            $panel->workspaceBackground = new UXImage(Ide::get()->getUserConfigValue("extension.scenebuilder.content.background"));

        $split->orientation = "VERTICAL";
        $topbox->spacing = $topbox->padding = 8;

        $undo->graphic = Ide::getImage("icons/undo16.png");
        $redo->graphic = Ide::getImage("icons/redo16.png");

        $undo->on("click", function () { $this->editor->getEditorController()->undo(); });
        $redo->on("click", function () { $this->editor->getEditorController()->redo(); });

        $mainSplit->dividerPositions = str::split(Ide::get()->getUserConfigValue("extension.scenebuilder.split.center"), ";");
        $split->dividerPositions     = str::split(Ide::get()->getUserConfigValue("extension.scenebuilder.split.left"), ";");

        $fun = function () use ($undo, $redo) {
            $this->save();

            $undo->enabled = $this->editor->getEditorController()->canUndo();
            $redo->enabled = $this->editor->getEditorController()->canRedo();
        };

        $fun();

        $box->on("mouseDown", $fun);
        $box->on("mouseUp", function () use ($mainSplit, $split) {
            Ide::get()->setUserConfigValue("extension.scenebuilder.split.center", str::join($mainSplit->dividerPositions, ";"));
            Ide::get()->setUserConfigValue("extension.scenebuilder.split.left", str::join($split->dividerPositions, ";"));
        });

        return $box;
    }
}