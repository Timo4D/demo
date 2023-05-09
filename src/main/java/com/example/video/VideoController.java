package com.example.video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    // Hard-coded list of videos (normally from db!)
    // Just for explanation of the concept
    private List<Video> videolist = new ArrayList<Video>(Arrays.asList(
            new Video("Edge of Tomorrow", "16", "In Zeitschleife gefangen bis Aliens vernichtet", "SciFi"),
            new Video("Security", "18", "Marine rettet Mädchen in Kaufhaus", "Action")));

    @RequestMapping("/videos")
    public List<Video> getVideoList() {
        return videolist;
    }

    @RequestMapping("/videos/{title}")
    public Video getVideo(@PathVariable String title) {
        for (Video v : videolist) {
            if (v.getTitle().equals(title))
                return v;
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/videos")
    public void addVideo(@RequestBody Video video) {
        videolist.add(video);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/videos/{title}")
    public void updateVideo(@PathVariable String title, @RequestBody Video video) {
        for (int i = 0; i < videolist.size(); i++) {
            Video v = videolist.get(i);
            if (v.getTitle().equals(title)) {
                videolist.set(i, video);
                return;
            }
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/videos/{title}")
    public void deleteVideo(@PathVariable String title) {
        for (int i = 0; i < videolist.size(); i++) {
            Video v = videolist.get(i);
            if (v.getTitle().equals(title)) {
                videolist.remove(i);
                return;
            }
        }
    }

}
