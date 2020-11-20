package Kotlin

fun main(args: Array<String>) {
    val cal = Calculator1()
    print("op.plus: ${cal.plus(5, 2)}\n")
    println("op.minus: ${cal.minus(5, 2)}")
    println("op.multiply: ${cal.multiply(5, 2)}")
    println("op.divide: ${cal.divide(5, 2)}")
    println()

    val cal2 = Calculator2()
    println(cal2.plus(1,2,3,4,5))
    println(cal2.minus(10, 1,2,3))
    println(cal2.multiply(1,2,3))
    println(cal2.divide(10, 2,3))

    val cal3 = Calculator3(5)
    print("cal3.plus: ${cal3.plus(2).getNumber()}\n")
    println("cal3.minus: ${cal3.minus(2).getNumber()}")
    println("cal3.multiply: ${cal3.multiply(2).getNumber()}")
    println("cal3.divide: ${cal3.divide(2).getFloatNumber()}")
    println()


    val account = Account("Jin", 19791115, -2000)
    account.checkBalance()
    account.deposit(100000)
    account.checkBalance()
    if (account.withdraw(7000))
        account.checkBalance()
    else
        println("Withdraw Error!")
    println()

    val tv = TV(false, 11)
    tv.turnOn(true)
    tv.changeChannel(6)
}

// 1번 문제: 사칙 연산 수행 할 수 있는 클래스
// 기본 형태(문제점 있음)
class Calculator1() {

    fun plus(left: Int, right: Int): Int {
        return left + right
    }

    fun minus(left: Int, right: Int): Int {
        return left - right
    }

    fun multiply(left: Int, right: Int): Int {
        return left * right
    }

    fun divide(left: Int, right: Int): Float {
        return left.toFloat() / right.toFloat()
    }
}

// 1. 사칙연산 클래스 : 가변 인자를 받을 수 있는 버전(인자의 순서 지켜야 하는 문제점 있음)
class Calculator2() {

    fun plus(vararg numbers: Int): Int {
        var result = 0
        numbers.forEach {
            result += it
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {
        var result = numbers[0]
        for (i in 0 until numbers.size) {
            if (i != 0)
                result -= numbers[i]
        }
        return result
    }

    fun multiply(vararg numbers: Int): Int {
        var res = numbers[0]
        numbers.forEach {
            if ( it != 0)
                res *= it
        }
        return res
    }

    fun divide(vararg numbers: Int): Int {
        var res: Int = numbers[0]
        numbers.forEachIndexed { index, value ->
            if (index != 0 && value != 0) {
                res /= value
            }
        }
        return res
    }


}

// 1. 사칙연산 클래스(바람직함) : 피연산자 순서 얽매이지않고,
// 체이닝 호출 가능해서 여러 인자와 사칙연산 혼합가능한 버전
class Calculator3(private val number: Int, private var floatNum: Float = 0.0f) {

    constructor(floatNum: Float = 0.0F) : this(0, 0.0f) {
        this.floatNum = floatNum
    }

    fun plus(number: Int): Calculator3 {
        return Calculator3(this.number + number)
    }

    fun minus(number: Int): Calculator3 {
        return Calculator3(this.number - number)
    }

    fun multiply(number: Int): Calculator3 {
        return Calculator3(this.number * number)
    }

    fun divide(number: Int): Calculator3 {
        return Calculator3(this.number.toFloat() / number.toFloat())
    }

    fun getNumber() = number
    fun getFloatNumber() = floatNum

}

/* 2번 문제. 은행 계좌 만들기
 - 계좌 생성 기능 (이름, 생년 월일)
 - 잔고 확인 기능
 - 출금/예금 기능
*/
class Account {

    val name: String
    val birth: Int
    var balance: Long

    constructor(name: String, birth: Int, balance: Long = 0L) {
        this.name = name
        this.balance = balance
        if (balance >= 0)
            this.balance = balance
        else
            this.balance = 0
        this.birth = birth
    }

    fun checkBalance() = println("balance: $balance")
    fun deposit(money: Long): Long {
        balance += money
        return balance
    }
    fun withdraw(money: Long): Boolean {
        var res = false
        if (balance >= money) {
            balance -= money
            res = true
        }
        return res
    }
}

/* 3번 문제. TV 클래스
 - on/off 기능
 - 채널 돌리는 기능
 - 초기 채널은 (S, M, K 사 3개)
*/
class TV(var powerOn: Boolean, var channelNum: Int) {

    var channelList: MutableMap<Int, String> = mutableMapOf()

    init {
        channelList.put(11, "MBC")
        channelList.set(9, "KBS1")
        channelList[7] = "KBS2"
        channelList[6] = "SBS"
    }

    constructor(powerOn: Boolean, channelNum: Int,
                channelList: MutableMap<Int, String>) : this(powerOn, channelNum) {
        this.channelList = channelList
    }

    fun turnOn(on: Boolean) {
        powerOn = on
        println("TV Power On: $powerOn, Channel Number : ${this.channelNum}, " +
                "curBroadCasting company: ${channelList[channelNum]}")

    }

    fun changeChannel(channelNum: Int) {
        this.channelNum = channelNum
        channelList[channelNum]
        println("Change to Channel Number : ${this.channelNum}, " +
                "curBroadCasting company: ${channelList[channelNum]}")
    }
}
