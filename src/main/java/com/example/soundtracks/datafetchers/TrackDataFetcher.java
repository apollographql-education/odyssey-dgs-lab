package com.example.soundtracks.datafetchers;

import com.example.soundtracks.datasources.SpotifyClient;
import com.example.soundtracks.models.MappedTrack;
import com.example.soundtracks.models.MappedArtist;
import com.netflix.graphql.dgs.*;


@DgsComponent
public class TrackDataFetcher {
    private final SpotifyClient spotifyClient;

    public TrackDataFetcher(SpotifyClient spotifyClient) {
        this.spotifyClient = spotifyClient;
    }

    @DgsData(parentType="Track", field="artist")
    public MappedArtist getArtist(DgsDataFetchingEnvironment dfe) {
        MappedTrack track = dfe.getSource();
        String artistId = track.getArtistId();
        return spotifyClient.artistRequest(artistId);
    }

}