package com.example.graphqldgsdemo.services;

import com.example.graphqldgsdemo.types.Show;
import com.example.graphqldgsdemo.types.ShowType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowsService {

    private final List<Show> shows = List.of(
            new Show("1", "Peaky Blinders", 2016, null, ShowType.CRIME),
            new Show("2", "Ozark", 2017, null, ShowType.DRAMA),
            new Show("3", "Breaking Bad", 2016, null, ShowType.ADVENTURE),
            new Show("4", "Community", 2019, null, ShowType.MYSTERY),
            new Show("5", "Paradise P.D.", 2013, null, ShowType.FANTASY)
    );

    public List<Show> getShows() {
        return this.shows;
    }
}
