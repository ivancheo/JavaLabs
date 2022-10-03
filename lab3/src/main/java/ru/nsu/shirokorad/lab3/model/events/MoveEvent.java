package ru.nsu.shirokorad.lab3.model.events;

public final class MoveEvent {
    private final EventSource eventSource;

    public MoveEvent(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    public EventSource getEventSource() {
        return eventSource;
    }
}
