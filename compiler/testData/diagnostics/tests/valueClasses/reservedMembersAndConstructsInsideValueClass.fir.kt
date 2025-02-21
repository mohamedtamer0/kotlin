// !SKIP_JAVAC
// !LANGUAGE: +InlineClasses
// ALLOW_KOTLIN_PACKAGE
// !DIAGNOSTICS: -UNUSED_PARAMETER

package kotlin.jvm

annotation class JvmInline

@JvmInline
value class IC1(val x: Any) {
    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>box<!>() {}
    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>box<!>(x: Any) {}

    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>unbox<!>() {}
    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>unbox<!>(x: Any) {}

    override fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>equals<!>(other: Any?): Boolean = true
    override fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>hashCode<!>(): Int = 0
}

@JvmInline
value class IC2(val x: Any) {
    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>box<!>(x: Any) {}
    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>box<!>(): Any = TODO()

    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>unbox<!>(x: Any) {}
    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>unbox<!>(): Any = TODO()

    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>equals<!>(my: Any, other: Any): Boolean = true
    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>hashCode<!>(a: Any): Int = 0
}

@JvmInline
value class IC3(val x: Any) {
    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>box<!>(x: Any): Any = TODO()
    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>unbox<!>(x: Any): Any = TODO()

    fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>equals<!>(): Boolean = true
}

interface WithBox {
    fun box(): String
}

@JvmInline
value class IC4(val s: String) : WithBox {
    override fun <!RESERVED_MEMBER_INSIDE_VALUE_CLASS!>box<!>(): String = ""
}

@JvmInline
value class IC5(val a: String) {
    constructor(i: Int) : this(i.toString()) <!SECONDARY_CONSTRUCTOR_WITH_BODY_INSIDE_VALUE_CLASS!>{
        TODO("something")
    }<!>
}
