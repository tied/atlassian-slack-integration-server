package com.atlassian.plugins.slack.util;

import com.atlassian.event.api.EventPublisher;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RequiredArgsConstructor
public class AutoSubscribingEventListener {
    protected final EventPublisher eventPublisher;

    @PostConstruct
    public void enable() {
        eventPublisher.register(this);
    }

    @PreDestroy
    public void disable() {
        eventPublisher.unregister(this);
    }
}
