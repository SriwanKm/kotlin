// !LANGUAGE: +NewInference
// FILE: Test2.java

public class Test2<T> {
    public static B foo() { return null; }
}

// FILE: b.kt
class A<T>(x: T)
class B

fun bar(x: Boolean) {
    val y = Test2.foo()

//    val r2 = when (x) {
//        false -> A(B())
//        true -> A(y)
//    } // A<B>
//    <!DEBUG_INFO_EXPRESSION_TYPE("")!>r2<!>

    val r1 = when (x) {
        true -> A(y)
        false -> A(B())
    } // A<B>
    <!DEBUG_INFO_EXPRESSION_TYPE("")!>r1<!>
}