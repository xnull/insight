package bynull.functional.stream;

import bynull.functional.Common.Tuple2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Useful tips and tricks for using streams: how to do some actions using streams in java 8
 * Created by bynull on 04.07.16.
 */
public class StreamTips {

    /**
     * How to go through a collection with index using streams
     */
    public Stream<Tuple2<Integer, String>> withIndex(List<String> list) {
        return Stream.of(list).flatMap(collection ->
                IntStream.range(0, collection.size())
                        .boxed()
                        .map(index -> Tuple2.of(index, collection.get(index)))
        );
    }

    public Stream<Tuple2<Integer, String>> withIndex(Stream<String> input) {
        AtomicInteger index = new AtomicInteger();
        return input.map(value -> Tuple2.of(index.getAndIncrement(), value));
    }

    public static <T> Stream<T> makeCollectionVisibilityStreamPrivate(List<T> list) {
        return Stream.of(new ArrayList<>(list)).flatMap(collection -> {
            System.out.println("Now we are enable to get access or change the collection without affecting original collection");
            return collection.stream();
        });
    }
}
