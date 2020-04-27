package typeinfo;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class DynmicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public DynmicSupplier(Class<T> type) {
         this.type=type;
    }

    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch (InstantiationException |IllegalAccessException e) {
          throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynmicSupplier<>(CountedInteger.class)).skip(10).limit(5)
                .forEach(System.out::println);
    }
}

class CountedInteger{
        private static long counter;
        private final long id = counter++;

        public String toString(){return Long.toString(id); };

}