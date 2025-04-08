
package com.driver;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("spotify")
public class SpotifyController {

    //Autowire will not work in this case, no need to change this and add autowire
    SpotifyService spotifyService = new SpotifyService();

    @PostMapping("/add-user")
    public String createUser(@RequestParam(name = "name") String name, @RequestParam(name = "mobile") String mobile){
        spotifyService.createUser(name, mobile);
        return "Success";
    }

    @PostMapping("/add-artist")
    public String createArtist(@RequestParam(name = "name") String name){
        spotifyService.createArtist(name);
        return "Success";
    }

    @PostMapping("/add-album")
    public String createAlbum(@RequestParam(name = "title") String title, @RequestParam(name = "artistName") String artistName){
        spotifyService.createAlbum(title, artistName);
        return "Success";
    }

    @PostMapping("/add-song")
    public String createSong(@RequestParam("title") String title,
                             @RequestParam("albumName") String albumName,
                             @RequestParam("length") int length) throws Exception{
        spotifyService.createSong(title, albumName, length);
        return "Success";
    }

    @PostMapping("/add-playlist-on-length")
    public String createPlaylistOnLength(@RequestParam("mobile") String mobile,
                                         @RequestParam("title") String title,
                                         @RequestParam("length") int length) throws Exception{
        spotifyService.createPlaylistOnLength(mobile, title, length);
        return "Success";
    }

    @PostMapping("/add-playlist-on-name")
    public String createPlaylistOnName(@RequestParam("mobile") String mobile,
                                       @RequestParam("title") String title,
                                       @RequestParam("songTitles") List<String> songTitles) throws Exception{
        spotifyService.createPlaylistOnName(mobile, title, songTitles);
        return "Success";
    }

    @PutMapping("/find-playlist")
    public Playlist findPlaylist(@RequestParam("mobile") String mobile,
                                 @RequestParam("playlistTitle") String playlistTitle) throws Exception{
        return spotifyService.findPlaylist(mobile, playlistTitle);
    }

    @PutMapping("/like-song")
    public Song likeSong(@RequestParam("mobile") String mobile,
                         @RequestParam("songTitle") String songTitle) throws Exception{
        return spotifyService.likeSong(mobile, songTitle);
    }

    @GetMapping("/popular-artist")
    public String mostPopularArtist(){
        return spotifyService.mostPopularArtist();
    }

    @GetMapping("/popular-song")
    public String mostPopularSong(){
        return spotifyService.mostPopularSong();
    }

}
