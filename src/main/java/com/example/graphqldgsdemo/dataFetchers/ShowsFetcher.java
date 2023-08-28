package com.example.graphqldgsdemo.dataFetchers;

import com.example.graphqldgsdemo.DgsConstants;
import com.example.graphqldgsdemo.services.ShowsService;
import com.example.graphqldgsdemo.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsFetcher {

    private final ShowsService showsService;
    @Autowired
    public ShowsFetcher(ShowsService showsService) {
        this.showsService = showsService;
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Shows)
    public List<Show> shows(@InputArgument String titleFilter) {
        if (titleFilter == null) {
            return this.showsService.getShows();
        }

        return this.showsService.getShows().stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }
}
