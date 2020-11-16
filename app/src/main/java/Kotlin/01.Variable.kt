package com.clarkgable1.myapplicationf1.Kotlin

// 01. Variable -> 변수
var num = 10
var hello = " hello"
var point = 3.4

val fix = 20


fun main(args: Array<String>) {
    println(num)
    println(hello)
    println(point)
    println(fix)

    num = 100
    hello = "Good Bye"
    point = 10.4
//    fix = 500

    println()
    println(num)
    println(hello)
    println(point)
    println(fix)


    println(plusShort(10, 25))
    println(plusMany(100))


    val a: Int? = null
    val b: Int = 10
    val c: Int = 100

    if ( a == null) {
        println("a is null")
    } else {
        println("a is not null")
    }

    if (b+c == 110) {
        println("b + c == 110")
    } else {
        println("b plus c is not 110")
    }

    val num: Int? = 100
    val num2 = num ?: 10
    println()
    println(num2)

}

fun plus(first: Int, second: Int): Int {
    return first + second
}

fun plusShort(first: Int, second: Int) = first + second

//가변인자 함수
fun plusMany(vararg numbers: Int) {
    for (number in numbers) {
        println(number)
    }
}