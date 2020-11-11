package Kotlin


fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1,2,3,4,5,6,7,8,9);

    //반복하는 방법1
    for (item in a) {
        if (item == 5)
            println("item is 5")
        else
            println("item is not 5")
    }
    println()

    // 반복하는 방법2
    for ((idx, item) in a.withIndex()) {
        println("index: " + idx + " value: " + item)
    }
}