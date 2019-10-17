package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import org.json.simple.parser.ParseException;
import org.springframework.data.jpa.repository.Query;

import java.io.IOException;
import java.util.List;

public interface TrackService {
    public List<Track> searchTrack(String trackName) throws ParseException;

    public List<Track> getAllTracks();

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public Track deleteTrackById(int trackId) throws TrackNotFoundException;

    public Track updateTrack(Track track);

    public List<Track> findTrackByName(String trackName) throws TrackNotFoundException;
}
