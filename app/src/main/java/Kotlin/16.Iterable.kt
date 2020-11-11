package Kotlin

/*
20 ~ 22강 반복문 강의 코드 추가

val a = mutableListOf<Int>(1,2,3,4,5,6,7,8,9)

[21강 반복문-1 내용]
for (item in a)
for ( (idx, item) in a.withIndex ) // index와 item 같이 얻어오는 enhanced for loop 문

[ 21강 반복문-2 내용 ]
 forEach, forEach에서 Lamda(람다) 사용, forEachIndexed 과 아래 내용 추가

 <//인덱스만 할당해서 순회하는 방법>
 for (idx in 0 until a.size) // until 은 언틸 다음에 온 마지막 수를 포함하지 않는다.
 for ( i in 0 .. a.size) {// 0 ~9 까지 반복, until 과 다름. ..은 마지막까지 포함 함.

 <for in 반복문에서 step n 만큼 인덱스 건너띄게 하는 방법>
 for (idx in 0 until a.size step(2)) { // 0 2 4 6 8

 <for in 반복문에서 인덱스 내림차순으로 반복하는 방법>
 for (idx in a.size - 1 downTo(0)) { // 8 ~ 0

 for (idx in a.size -1 downTo(0) step (2) ) {// 8 6 4 2 0
 */
fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1,2,3,4,5,6,7,8,9)

    //반복하는 방법1 - enhanced for loop 문
    for (item in a) {
        if (item == 5)
            println("item is 5")
        else
            println("item is not 5")
    }
    println()

    // 반복하는 방법2 - index와 item 같이 얻어오는 enhanced for loop 문
    for ((idx, item) in a.withIndex()) {
        println("index: " + idx + " value: " + item)
    }
    println()

    // 반복하는 방법3
    a.forEach {
        println(it)
    }
    println()

    // 반복하는 방법4 - lamda 사용한 foreach 반복문
    a.forEach { item ->
        println(item)
    }
    println()

    //5 lamda 사용한 foreach 반복문
    a.forEachIndexed { idx, item ->
        println("index: " + idx + ", value : " + item)
    }
    println()

    //6. 인덱스만 할당해서 순회하는 방법
    for (i in 0 until a.size) { // until 은 언틸 다음에 온 마지막 수를 포함하지 않는다.
        //a.size == 9이다. 그러므로 반복문은 0 ~ 8 까지만 돈다.
        print("index: " + i + ", a.get(idx) : " + a.get(i) +"\n")
    }
    println()

    //7. for in 반복문에서 step n 만큼 인덱스 건너띄게 하는 방법
    for (idx in 0 until a.size step(2)) { // 0 2 4 6 8
        print(" " + a.get(idx))
    }
    println('\n')

    //8. for in 반복문에서 인덱스 내림차순으로 반복하는 방법
    for (idx in a.size - 1 downTo(0)) { // 8 ~ 0
        print(" " + idx)
    }
    println('\n')

    //9. for in 반복문에서 인덱스 내림차순으로 반복하는 방법
    for (idx in a.size -1 downTo(0) step (2) ) {// 8 6 4 2 0
        print(" " + idx)
    }
    println('\n')

    //10
    for ( i in 0 .. a.size) {// 0 ~9 까지 반복, until 과 다름. ..은 마지막까지 포함 함.
        print(" " + i)
    }
    println('\n')

    //11. while loop
    var b = 0
    val c = 4
    while (b < c) {
        b++
        print("b")
    }
    println()

    b = 0
    do {
        print("Hello")
        b++
    } while (b < c)
}