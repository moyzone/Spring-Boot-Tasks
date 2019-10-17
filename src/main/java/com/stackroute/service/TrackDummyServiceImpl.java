package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dummy")
public class TrackDummyServiceImpl implements TrackService {
    @Override
    public List<Track> searchTrack(String trackName) throws ParseException {
        return null;
    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public Track deleteTrackById(int trackId) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track updateTrack(Track track) {
        return null;
    }

    @Override
    public List<Track> findTrackByName(String trackName) throws TrackNotFoundException {
        return null;
    }
}
