package Kotlin

fun main() {

    Car("V8 engine", "big")

    val bigCar = Car("V8 engine", "big")
    println(bigCar.body)

    // 우리가 만든 클래스는 자료형이 된다
    val bigCar1: Car = Car("v8 engine", "big")
    val superCar: SuperCar = SuperCar("good engine", "big", "white")
    println(bigCar1.body + ", " + superCar.body)

    val runableCar = RunableCar("simple engine", "body")
    runableCar.ride()
    runableCar.navi("부산")
    runableCar.drive()

    val runableCar2 = RunableCar2("nice engine", "long body")
    println("${runableCar2.engine} , ${runableCar2.body}")
}

// 1.클래스(설명서) 만드는 방법 1 : 방법1이 방법2의 단축 문법임.
class Car(var engine: String, var body: String) {

}
class Car0 constructor(var engine: String, var body: String) {

}

// 2.클래스(설명서) 만드는 방법 2
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

// making class 3 -> extending method No.1 : 방법4의 단축 문법이 방법3.
class Car1(engine: String, body: String) {
    var door: String = ""

    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door
    }
}

// making class 4 -> extending method No.2
class Car2 {
    var engine: String = ""
    var body: String = ""
    var door: String = ""

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class RunableCar(engine: String, body: String) {

    fun ride() {
        println("탑승했다")
    }

    fun drive() {
        println("Running!!!")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정됨")
    }
}

class RunableCar2 {

    var engine: String
    var body: String

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    init { // 초기 세팅시 유용
        println("RunableCar2가 만들어짐.")
    }

    fun ride() {
        println("탑승했다")
    }

    fun drive() {
        println("Running!!!")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정됨")
    }
}