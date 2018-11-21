<?php

namespace ide\settings;


use ide\Ide;
use php\gui\layout\UXHBox;
use php\gui\UXButton;
use php\gui\UXFileChooser;
use php\gui\UXLoader;
use php\gui\UXNode;
use php\gui\UXTextField;
use php\io\Stream;
use php\lib\arr;
use php\lib\fs;

class SceneBuilderSettings extends AbstractSettings
{
    /**
     * @var UXHBox
     */
    private $settingsPane;

    /**
     * @var UXButton
     */
    private $btn;

    /**
     * @var UXTextField
     */
    private $path;

    public function __construct()
    {
        $this->settingsPane = (new UXLoader())->load(Stream::of("res://.data/fxml/_scenebuilder.fxml"));

        // controls
        $this->btn  = $this->settingsPane->children->toArray()[2];
        $this->path = $this->settingsPane->children->toArray()[1];

        $this->btn->on("click", function () {
            $imgChoser = new UXFileChooser();
            $path = $imgChoser->execute();
            if ($path && arr::has([
                "jpg", "png", "jpeg", "bmp"
                ], fs::ext($path))) $this->path->text = $path->getAbsolutePath();
        });

        $this->path->text = Ide::get()->getUserConfigValue("extension.scenebuilder.content.background");
    }

    /**
     * @return string
     */
    public function getName(): string
    {
        return "ide.extension.scenebuilder.settings";
    }

    /**
     * @return string
     */
    public function getIcon16(): string
    {
        return "icons/scenebuilder16.png";
    }

    /**
     * @return UXNode
     */
    public function getNode(): UXNode
    {
        return _($this->settingsPane);
    }

    public function save(): void
    {
        if ((fs::isFile($this->path->text) && arr::has([
                    "jpg", "png", "jpeg", "bmp"
                ], fs::ext($this->path->text)) ) || $this->path->text == null) {
            Ide::get()->setUserConfigValue("extension.scenebuilder.content.background", $this->path->text);
            Ide::toast("Saved ....");
        }
    }

    public function toDefault(): void
    {
        $this->path->text = null;
        $this->save();
    }
}