package Kotlin

fun main(args: Array<String>) {
    // private 키워드 때문에 외부에서 더 이상 사용 불가
//    testAccess.tese()
//    println(testAccess.name)
//    testAcces.name = "아무개 투"
//    println(testAcces.name)

    val reward: Reward = Reward()
    reward.rewardAmount = 2000

    var runningCar: RunningCar = RunningCar()
    runningCar.runFast()
//    runningCar.run()
}


class Reward() {
    var rewardAmount: Int = 1000
}


class TestAccess {
    private var name: String = "홍길동"

    constructor(name: String) {
        this.name = name
    }

    fun changeName(newName: String) {
        this.name = newName
    }

    private fun test() {
        println("Test")
    }
}


class RunningCar() {

    fun runFast() {
        run()
    }

    private fun run() {

    }
}