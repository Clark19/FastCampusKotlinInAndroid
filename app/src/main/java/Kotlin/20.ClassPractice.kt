package Kotlin

fun main(args: Array<String>) {
    val cal = Calculator1()
    print("op.plus: ${cal.plus(5, 2)}\n")
    println("op.minus: ${cal.minus(5, 2)}")
    println("op.multiply: ${cal.multiply(5, 2)}")
    println("op.divide: ${cal.divide(5, 2)}")
    println()

    val cal2 = Calculator2()
    println(cal2.plus(1, 2, 3, 4, 5))
    println(cal2.minus(10, 1, 2, 3))
    println(cal2.multiply(1, 2, 3))
    println(cal2.divide(10, 2, 3))

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

    val tv = TV(false)
    tv.turnOn(true)
    tv.changeChannel(6)

    val tv2 = TV(false, 11,
            mutableMapOf(6 to "SBS", 7 to "KBS2", 9 to "KBS1", 11 to "MBC"))
    tv2.turnOn(on = false)
    tv2.changeChannel(9)
    tv2.turnOn(on = true)
    tv2.changeChannel(7)

    for (i in 0 until 10) {
        tv2.channelUp()
        tv2.printCurChannel()
    }
    println()
    for (i in 0..10) {
        tv2.channelDown()
        tv2.printCurChannel()
    }
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

class Account3(initialBalance: Int) {

    val balance: Int = if (initialBalance >= 0) initialBalance else 0

    fun checkBalance(): Int {
        return balance
    }
}



/* 3번 문제. TV 클래스
 - on/off 기능
 - 채널 돌리는 기능
 - 초기 채널은 (S, M, K 사 3개)
*/
class TV(private var powerOn: Boolean) {

    private var channels: MutableMap<Int, String> = mutableMapOf()
    private var channelNum = 0
        set(value) {
            field = value
//            println(value)
        }
    init {
        channels[6] = "SBS"
        channels[7] = "KBS2"
        channels.set(9, "KBS1")
        channels.put(11, "MBC")
    }

    constructor(powerOn: Boolean, channelNum: Int,
                channelList: MutableMap<Int, String>) : this(powerOn) {
        this.channelNum = channelNum
        this.channels = channelList
    }

    fun turnOn(on: Boolean) {
        powerOn = on
        println("TV Power On: $powerOn, Channel Number : ${this.channelNum}, " +
                "curBroadCasting company: ${channels[channelNum]}")

    }

    fun changeChannel(channelNum: Int) {
        this.channelNum = channelNum
        channels[channelNum]
        println("Change to Channel Number : ${this.channelNum}, " +
                "curBroadCasting company: ${channels[channelNum]}")
    }

    fun channelUp() {
        val channelList = channels.keys.toList()
        channelList.toList().forEachIndexed { index, channel ->
            if (channelNum == channel) {
                if (channelList.size == index+1)
                    channelNum = channelList[0]
                else
                    channelNum = channelList[index + 1]
                return
            }
        }
    }

    fun channelDown() {
        val channelList = channels.keys.toList()
        channelList.toList().forEachIndexed { index, channel ->
            if (channelNum == channel) {
                if (0 == index)
                    channelNum = channelList[channelList.size-1]
                else
                    channelNum = channelList[index - 1]
                return
            }
        }
    }

    fun printCurChannel() {
        println("chNo.: ${channelNum}(${channels.get(channelNum)})")
    }
}
