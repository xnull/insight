package bynull.functional.zip;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * https://habrahabr.ru/post/256905/
 * Created by bynull on 01.07.16.
 */
public class FunctionalZip {

    public static void main(String[] args) {
        List<String> requestList = Arrays.asList("request1", "request2");
        List<String> responseList = Arrays.asList("response1", "response2");

        //получаем 2 стрима, берём один элемент из каждого, отдаем остаток стримов дальше.
        //надо использовать функцию, и таким образом количество элементов в стримах будет уменьшаться
        /*BiFunction<Stream<String>, Stream<String>, String> elementGetter = (requests, responses) -> {
            requests.skip(1);
            requests.findFirst();
        };*/

        //Stream.iterate(new Pair<>(request, response), streamStreamPair -> null).ma;

        //Stream.of(new Pair<>(request, response)).


        BiFunction<String, String, Pair<String, String>> reqRespMapper = Pair::new;

        BiFunction<Stream<String>, Stream<String>, Pair<String, String>> extractor =
                (requests, responses) -> {
                    System.out.println("Extractor iteration");
                    return reqRespMapper.apply(requests.findFirst().get(), responses.findFirst().get());
                };

        BiFunction<Stream<String>, Stream<String>, Pair<String, String>> decrement =
                (requests, responses) -> {
                    System.out.println("Decrement iteration");
                    return reqRespMapper.apply(requests.skip(1).findFirst().get(), responses.skip(1).findFirst().get());
                };

        Function<Pair<Stream<String>, Stream<String>>, BiFunction<Stream<String>, Stream<String>, Pair<String, String>>> init =
                input -> decrement;

        Stream<String> response = responseList.stream();
        Stream<String> request = requestList.stream();

        //http://www.programcreek.com/2014/01/create-stream-in-java-8/
        //https://habrahabr.ru/post/256905/

        Stream.of(new Pair<>(new ArrayList<>(requestList), new ArrayList<>(responseList)))
                .flatMap(reqRespPair -> IntStream
                        .range(0, requestList.size())
                        .boxed()
                        .map(idx -> new Pair<>(reqRespPair.key.get(idx), reqRespPair.value.get(idx)))
                );

        Spliterators.

                //indexedReqResp.collect(collectingAndThen(groupingBy(x -> x.key), tt -> null));


                        IntStream.range(0, requestList.size())
                .boxed()
                .map(index -> new Pair<>(index, requestList.get(index)));


        new BiFunction<Queue<String>, Queue<String>, Pair<String, String>>() {
            @Override
            public Pair<String, String> apply(Queue<String> requests, Queue<String> responses) {
                return reqRespMapper.apply(requests.poll(), responses.poll());
            }
        };

        Stream<IndexedPair<String, String>> requestResponseStream = Stream.iterate(
                IndexedPair.get(0, requestList.get(0), responseList.get(0)),
                prev -> new IndexedPair<>(prev.index + 1, requestList.get(prev.index + 1), responseList.get(prev.index + 1))
        ).limit(requestList.size());

        //requestResponseStream.forEach(System.out::println);
    }

    public static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static class IndexedPair<Left, Right> {
        final Integer index;
        final Left left;
        final Right right;

        public static <Left, Right> IndexedPair<Left, Right> get(Integer index, Left left, Right right) {
            return new IndexedPair<>(index, left, right);
        }

        public IndexedPair(Integer index, Left left, Right right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "IndexedPair{index=" + index + ", left=" + left + ", right=" + right + '}';
        }
    }
}

