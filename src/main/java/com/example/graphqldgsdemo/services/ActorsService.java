package com.example.graphqldgsdemo.services;

import com.example.graphqldgsdemo.types.Actor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActorsService {
    private final Map<String, List<Actor>> actors = Map.ofEntries(
            Map.entry("1", List.of(
                    new Actor("Cillian Murphy", 4),
                    new Actor("Helen McCrory", 2),
                    new Actor("Paul Anderson", 1)
            )),
            Map.entry("2", List.of(
                    new Actor("Jason Bateman", 5),
                    new Actor("Laura Linney", 3),
                    new Actor("Julia Garner", 2)
            )),
            Map.entry("3", List.of(
                    new Actor("Bryan Cranston", 5),
                    new Actor("Aaron Paul", 4),
                    new Actor("Giancarlo Esposito", 3)
            )),
            Map.entry("4", List.of(
                    new Actor("Joel McHale", 4),
                    new Actor("Alison Brie", 3),
                    new Actor("Donald Glover", 5)
            )),
            Map.entry("5", List.of(
                    new Actor("Sarah Chalke", 2),
                    new Actor("David Herman", 1),
                    new Actor("Tom Kenny", 3)
            ))
    );

    public Map<String, List<Actor>> getActorsByShowIds(List<String> ids) {
        return this.actors.entrySet().stream().filter(entry -> ids.contains(entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Set<Actor> getAllActors() {
        return this.actors.values().stream().flatMap(List::stream).collect(Collectors.toSet());
    }
}
