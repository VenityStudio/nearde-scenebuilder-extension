<?php

namespace ide;

use ide\formats\FXMLFormat;
use ide\settings\SceneBuilderSettings;

class SceneBuilderExtension extends AbstractExtension
{

    /**
     * @return string
     */
    public function getName(): string
    {
        return "Gluon Scene Builder";
    }

    /**
     * @return string
     */
    public function getAuthor(): string
    {
        return "Gluon & Venity Group";
    }

    /**
     * @return string
     */
    public function getVersion(): string
    {
        return "1.1.0";
    }

    /**
     * @return string
     */
    public function getIcon32(): string
    {
        return "icons/scenebuilder32.png";
    }

    /**
     * @throws \Exception
     */
    public function onRegister()
    {
        Ide::get()->registerFormat(new FXMLFormat());
        Ide::get()->getSettingsContainer()->register(new SceneBuilderSettings());

        Ide::get()->getLocalizer()->load("ru", "res://.data/langs/ru/scenebuilder.ini");
        Ide::get()->getLocalizer()->load("en", "res://.data/langs/en/scenebuilder.ini");
    }

    public function onIdeStart()
    {

    }

    public function onIdeShutdown()
    {

    }
}