import kotlinx.coroutines.delay

open class Animal(
    var currentEnergy: Int,
    var currentAge: Int,
    var currentWeight: Int,
    val maxAge: Int = 5,
    val name: String
) {
    open var status: Boolean = true
    open val isTooOld: Boolean get() = currentAge >= maxAge
    open val isVeryFat: Boolean get() = currentWeight >= 100
    open val isLowEnergy: Boolean get() = currentEnergy <= 1

    open suspend fun lifecycle() {
        while (status) {
            val zizn = listOf(::eat, ::sleep, ::move, ::say)
            var allActionIsCompleted = true

            for (action in zizn) {
                action()
                if (!chekStatus()) {
                    allActionIsCompleted = false
                    break
                }
                delay(3000)
            }

            if (allActionIsCompleted && status) {
                delay(1000)
                currentAge += 1
                println("$name постарел⏳")
                if (!chekStatus()) break
            } else {
                break
            }
        }
    }

    open fun chekStatus(): Boolean {
        if (!status) return false

        when {
            isTooOld -> {
                println("$name сдох от старости⏳")
                status = false
            }

            isVeryFat -> {
                println("$name лопнул от переедания\uD83D\uDCA5")
                status = false
            }

            isLowEnergy -> {
                println("$name сдох от недомогания\uD83E\uDD40")
                status = false
            }
        }
        return status
    }


    open fun sleep() {
        println("$name спит\uD83D\uDE34")
        currentEnergy += 30
    }

    open fun eat() {
        println("$name принимает пищу ртом\uD83D\uDE0B")
        currentEnergy += 20
        currentWeight += 10
        if (isVeryFat) {
            println("$name лопнул от переедания\uD83D\uDCA5")
            status = false
        }
    }

    open fun move() {
        println("$name бегает\uD83D\uDC3E")
        currentEnergy -= 15
        currentWeight -= 5
        if (isLowEnergy) {
            println("$name помер от недомогания\uD83E\uDD40")
            status = false
        }
    }

    open fun say() {
        println("$name говорит что-то на своём\uD83D\uDDEF\uFE0F")
    }
}
