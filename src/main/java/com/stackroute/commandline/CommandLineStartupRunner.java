package com.stackroute.commandline;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineStartupRunner implements CommandLineRunner {
    private TrackRepository trackRepository;
    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track(3, "Emoji of a Wave", "John Mayer" ,"Oh honey, it's just a wave" ));
    }
}
