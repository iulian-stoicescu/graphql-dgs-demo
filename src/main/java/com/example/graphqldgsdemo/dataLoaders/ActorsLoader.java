package com.example.graphqldgsdemo.dataLoaders;

import com.example.graphqldgsdemo.DgsConstants;
import com.example.graphqldgsdemo.services.ActorsService;
import com.example.graphqldgsdemo.types.Actor;
import com.netflix.graphql.dgs.DgsDataLoader;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.MappedBatchLoaderWithContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Slf4j
@DgsDataLoader(name = DgsConstants.SHOW.Actors)
public class ActorsLoader implements MappedBatchLoaderWithContext<String, List<Actor>> {

    private final ActorsService actorsService;
    @Autowired
    public ActorsLoader(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @Override
    public CompletionStage<Map<String, List<Actor>>> load(Set<String> keys, BatchLoaderEnvironment environment) {
        log.info("inside ActorsLoader");
        return CompletableFuture.supplyAsync(() -> this.actorsService.getActorsByShowIds(new ArrayList<>(keys)));
    }
}
