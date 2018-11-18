<?php

namespace ide\formats;


use ide\editors\AbstractEditor;
use ide\editors\SceneBuilderEditor;
use php\lib\fs;

class FXMLFormat extends AbstractFormat
{

    /**
     * @param $file
     * @param array $options
     * @return AbstractEditor
     */
    public function createEditor($file, array $options = [])
    {
        return new SceneBuilderEditor($file);
    }

    /**
     * @param $file
     * @return bool
     */
    public function isValid($file)
    {
        return fs::ext($file) == "fxml";
    }

    /**
     * @param $any
     * @return mixed
     */
    public function register($any)
    {
        return null;
    }

    public function getIcon()
    {
        return "icons/fxml16.png";
    }
}