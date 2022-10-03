package ru.nsu.shirokorad.lab3.model.events;

import ru.nsu.shirokorad.lab3.model.DownData;
import ru.nsu.shirokorad.lab3.model.ViewData;

public interface InputEventListener {

    DownData onDownEvent(MoveEvent event);

    ViewData onLeftEvent(MoveEvent event);

    ViewData onRightEvent(MoveEvent event);

    ViewData onRotateEvent(MoveEvent event);

}
