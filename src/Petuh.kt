open class Petuh(
    currentEnergy: Int,
    currentAge: Int,
    currentWeight: Int,
    name: String,
    maxAge: Int
) : Animal(
    currentEnergy = currentEnergy,
    currentAge = currentAge,
    currentWeight = currentWeight,
    maxAge = maxAge,
    name
) {
    override val isVeryFat: Boolean get() = currentWeight >= 20
    override val isTooOld: Boolean get() = currentAge >= maxAge

    override fun eat() {
        println("Петух $name клюёт зерно")
        currentEnergy += 30
        currentWeight += 5
    }

    override fun say() {
        println("Петух $name кукарекает")
    }

    override fun move() {
        println("$name передвигается")
        currentEnergy -= 70
        currentWeight -= 10
        if (isLowEnergy) {
            println("Петух $name помер от недомогания")
            status = false
        }
    }
}