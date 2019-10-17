package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service
@Profile({"dev", "prod"})
@PropertySource("classpath:application.properties")
public class TrackServiceImpl implements TrackService{
    @Value("${api.key}")
    private String apiKey;
    @Value("${lastfm.suffix}")
    private String urlSuffix;

    @Autowired
    private Environment environment;

    private TrackRepository trackRepository;
    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        try{
            Track savedTrack = trackRepository.save(track);
            return savedTrack;
        }catch(Exception e){
            throw new TrackAlreadyExistsException("Track already exists");
        }
    }

    @Override
    public Track deleteTrackById(int trackId) throws TrackNotFoundException{
        Optional<Track > track = trackRepository.findById(trackId);
        if (track.isPresent()){
            trackRepository.deleteById(trackId);
            return track.get();
        }else{
            throw new TrackNotFoundException("Cannot find track");
        }
    }

    @Override
    public Track updateTrack(Track track) {
        Optional<Track> savedTrack = trackRepository.findById(track.getTrackId());
        if(savedTrack.isPresent()){
            Track updatedTrack = savedTrack.get();
            updatedTrack.setTrackComments(track.getTrackComments());
            trackRepository.save(updatedTrack);
            return updatedTrack;
        }else{
            return null;
        }
    }

    @Override
    public List<Track> findTrackByName(String trackName) throws TrackNotFoundException {
        return trackRepository.findTrackByName(trackName);
    }
}
