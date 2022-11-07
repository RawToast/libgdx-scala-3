package com.github.rawtoast

import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}

object Main extends App:
    val config = new Lwjgl3ApplicationConfiguration
    new Lwjgl3Application(new MainGame, config)
