package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int trackId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("artist")
    private String artist;
    private String trackComments;
}
