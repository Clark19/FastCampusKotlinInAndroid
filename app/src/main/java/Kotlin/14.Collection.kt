package com.clarkgable1.myapplicationf1.Kotlin

//14. Collection
// -> list, set, map

fun main(args: Array<String>) {

//  Immutable Collection : 처음 만든 후 바꿀수 없음.
//  변경 불가 : 추가, 변경, 삭제  [[

    // List -> 중복 허용
    val numberList = listOf<Int>(1, 2, 3, 3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    // Set
    // -> 중복을 허용하지 않음.
    // -> 순서가 없다!!
    val numberSet = setOf<Int>(1,2,3,3,3)
    println(numberSet)
    numberSet.forEach {
        println(it)
    }

    // Map -> Key, Value 방식을 관리
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println(numberMap.get("one"))
//    ]] End of Immutable Collection



//    Mutable Collection (변경가능) [[

    val mNumberList = mutableListOf<Int>(1,2,3)
    mNumberList.add(3, 4)
    println()
    println(mNumberList)

    val mNumberSet = mutableSetOf<Int>(1,2,3,4,4,4)
    mNumberSet.add(10)
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    mNumberMap.put("two", 2)
    println(mNumberMap)


//    End of Mutable Collection

}