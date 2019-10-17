package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Muzix Track Management System.", description = "Operations pertaining to Track in Track Management System")
public class TrackController {
    private ResponseEntity responseEntity;
    @Autowired
    private TrackService trackService;

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    @ApiOperation(value ="Search for tracks using Last.fm API", response = ResponseEntity.class)
    @GetMapping("search")
    public ResponseEntity<?> getSearchResults(@RequestParam("trackName") String trackName){
        try {
            responseEntity = new ResponseEntity<List<Track>>(trackService.searchTrack(trackName), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @ApiOperation(value = "Save a track to database", response = ResponseEntity.class)
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        try{
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        }catch (TrackAlreadyExistsException e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @ApiOperation(value = "Get all user saved tracks from database", response = ResponseEntity.class)
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks(){
        try{
            responseEntity = new ResponseEntity(trackService.getAllTracks(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @ApiOperation(value = "Delete a saved track from the database using the trackId", response = ResponseEntity.class)
    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrackById(@RequestBody int trackId){
        try{
            responseEntity = new ResponseEntity(trackService.deleteTrackById(trackId), HttpStatus.OK);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @ApiOperation(value = "Update a track previously in the database", response = ResponseEntity.class)
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
        try{
            responseEntity = new ResponseEntity(trackService.updateTrack(track), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @ApiOperation(value = "Find a saved track using it's name", response = ResponseEntity.class)
    @GetMapping("findTrack")
    public ResponseEntity<?> findTrackByName(@RequestParam("trackName") String trackName){
        try{
            responseEntity = new ResponseEntity(trackService.findTrackByName(trackName), HttpStatus.OK);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
