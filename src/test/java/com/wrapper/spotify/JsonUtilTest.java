package com.wrapper.spotify;

import com.wrapper.spotify.objects.Album;
import com.wrapper.spotify.objects.Artist;
import com.wrapper.spotify.objects.Track;
import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.assertEquals;

public class JsonUtilTest {

  @Test
  public void shouldCreateArtist() throws Exception {
    String json = TestUtil.readTestData("artist.json");
    Artist artist = JsonUtil.createArtist(json);
    assertEquals("https://api.spotify.com/v1/artists/2BTZIqw0ntH9MvilQ3ewNY", artist.getHref());
  }

  @Test
  public void shouldCreateSeveralArtists() throws Exception {
    String json = TestUtil.readTestData("artists.json");
    Artist[] artists = JsonUtil.createArtists(json);
    assertEquals(2, artists.size());
  }

  @Test
  public void shouldCreateAlbum() throws Exception {
    String json = TestUtil.readTestData("album.json");
    Album album = JsonUtil.createAlbum(json);
    assertEquals("https://api.spotify.com/v1/albums/4pox3k0CGuwwAknR9GtcoX", album.getHref());
  }

  @Test
  public void shouldCreateSeveralAlbums() throws Exception {
    String json = TestUtil.readTestData("albums.json");
    Album[] albums = JsonUtil.createAlbums(json);
    assertEquals(1, albums.size());
  }

  @Test
  public void shouldCreateTrack() throws Exception {
    String json = TestUtil.readTestData("track.json");
    Track track = JsonUtil.createTrack(json);
    assertEquals("0eGsygTp906u18L0Oimnem", track.getId());
  }

  @Test
  public void shouldCreateSeveralTracks() throws Exception {
    String json = TestUtil.readTestData("tracks.json");
    Track[] tracks = JsonUtil.createTracks(json);
    assertEquals(2, tracks.size());
  }

  @Test
  public void shouldCreateProperUri() throws Exception {
    String user = "ta_!#¤%=?+☃3";
    String userUri = UrlUtil.escapeUsername(user);
    URI uri = new URI("ta_%21%23%C2%A4%25%3D%3F%2B%E2%98%833");
    assertEquals(userUri, uri.toString());
  }

}
