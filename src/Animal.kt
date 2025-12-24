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
            for (action in zizn) {
                action();
                if (!chekStatus()) return
                delay(3000)
            }
        }
    }

    open fun chekStatus(): Boolean {
        when {
            isTooOld -> {
                status = false
                println("$name сдох от старости")
            }

            isVeryFat -> {
                status = false
                println("$name сдох от ожирения")
            }

            isLowEnergy -> {
                status = false
                println("$name сдох от недомогания")
            }
        }
        return status
    }

    open fun sleep() {
        println("$name спит")
        currentEnergy += 30
        println("Текущая энергия = $currentEnergy")
    }

    open fun eat() {
        println("$name принимает пищу ртом")
        currentEnergy += 30
        currentWeight += 60
        println("Текущая энергия = $currentEnergy")
        println("Текущий вес = $currentWeight")
    }

    open fun move() {
        println("$name передвигается")
        currentEnergy -= 50
        currentWeight -= 10
        println("Текущая энергия = $currentEnergy")
        println("Текущий вес = $currentWeight")
    }

    open fun say(){
        println("$name говорит что-то на своём")
    }
}
