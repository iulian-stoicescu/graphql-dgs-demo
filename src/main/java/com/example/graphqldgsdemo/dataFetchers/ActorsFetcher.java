package com.example.graphqldgsdemo.dataFetchers;

import com.example.graphqldgsdemo.DgsConstants;
import com.example.graphqldgsdemo.dataLoaders.ActorsLoader;
import com.example.graphqldgsdemo.types.Actor;
import com.example.graphqldgsdemo.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@DgsComponent
public class ActorsFetcher {

    // actors field is expensive, so we created a separate fetcher for it
    @DgsData(parentType = DgsConstants.SHOW.TYPE_NAME, field = DgsConstants.SHOW.Actors)
    public CompletableFuture<List<Actor>> actors(DgsDataFetchingEnvironment dfe) {
        log.info("inside ActorsFetcher");
        DataLoader<String, List<Actor>> dataLoader = dfe.getDataLoader(ActorsLoader.class);
        Show show = dfe.getSource();
        return dataLoader.load(show.getId());
    }
}
