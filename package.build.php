<?php

use packager\Event;

function task_build(Event $e)
{
    Tasks::runExternal('./jphp-gui-scenebuilder-ext', 'publish', [], 'yes');
    Tasks::runExternal('./nearde-extension', 'build', [], ...$e->flags());
}