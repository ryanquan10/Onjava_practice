package annotations;

public @interface TestAnnotation {
    String value()default"abc";
}
