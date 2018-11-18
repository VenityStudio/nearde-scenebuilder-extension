<?php

namespace ide;


use ide\formats\FXMLFormat;

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
        return "Venity Group";
    }

    /**
     * @return string
     */
    public function getVersion(): string
    {
        return "1.0.0";
    }

    /**
     * @return string
     */
    public function getIcon32(): string
    {
        return "SceneBuilderLogo.png";
    }

    /**
     * @throws \Exception
     */
    public function onRegister()
    {
        Ide::get()->registerFormat(new FXMLFormat());
    }

    public function onIdeStart()
    {

    }

    public function onIdeShutdown()
    {

    }
}