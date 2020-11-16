package Kotlin

fun main() {

    Car("V8 engine", "big")

    val bigCar = Car("V8 engine", "big")
    // 우리가 만든 클래스는 자료형이 된다
    val bigCar1: Car = Car("v8 engine", "big")
    val superCar: SuperCar = SuperCar("good engine", "big", "white")
}

// 클래스(설명서) 만드는 방법(1)
class Car(var engine: String, var body: String) {

}

// 클래스(설명서) 만드는 방법 2
class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}