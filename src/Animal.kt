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
                println("$name постарел. Его возраст $currentAge")
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
                println("$name сдох от старости")
                status = false
            }

            isVeryFat -> {
                println("$name лопнул от переедания")
                status = false
            }

            isLowEnergy -> {
                println("$name упал без сил и не проснулся")
                status = false
            }
        }
        return status
    }


    open fun sleep() {
        println("$name спит")
        currentEnergy += 30
    }

    open fun eat() {
        println("$name принимает пищу ртом")
        currentEnergy += 20
        currentWeight += 10
        if (isVeryFat) {
            println("$name лопнул от переедания")
            status = false
        }
    }

    open fun move() {
        println("$name передвигается")
        currentEnergy -= 15
        currentWeight -= 5
        if (isLowEnergy) {
            println("$name помер от недомогания")
            status = false
        }
    }

    open fun say() {
        println("$name говорит что-то на своём")
    }
}
