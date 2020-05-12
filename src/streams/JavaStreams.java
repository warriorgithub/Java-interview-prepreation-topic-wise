package streams;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class JavaStreams {
    private static void intStream(){
        IntStream.range(1,10).forEach(System.out::print);
    }
    private static void skipIntegers(){
        IntStream.range(1,10).skip(5).forEach(x->System.out.println(x));
    }
    private static void sumInteger(){
        System.out.println(IntStream.range(1,5).sum())   ;
    }

    private static void streamSorted(){
        Stream.of("Name","Address").sorted().findFirst().ifPresent(System.out::print);
        System.out.println();
    }
    private static void streamFilter(){
        String arr[] ={"name","address","url","nick"};
        Arrays.stream(arr).filter(x-> x.startsWith("n")).sorted().forEach(x-> System.out.println(x));
    }
    public static void main(String args[]){
        //intStream();
        //skipIntegers();
        sumInteger();
        streamSorted();
        streamFilter();
    }
}
