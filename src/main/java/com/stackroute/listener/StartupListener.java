package com.stackroute.listener;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    private TrackRepository trackRepository;
    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        trackRepository.save(new Track(1, "Edge of Desire", "John Mayer", "From Battle Studies"));
        trackRepository.save(new Track(2, "Hello", "Adele", "Hellofromtheothersideeee"));
    }
}
