package com.example.soundtracks.models;
import com.example.soundtracks.generated.types.Artist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MappedArtist extends Artist {

    @JsonSetter("followers")
    public void mapFollowers(JsonNode followersNode) {
        this.setFollowers(followersNode.get("total").asInt());
    }

}