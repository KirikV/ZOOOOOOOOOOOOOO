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
        println("$name клюёт зерно\uD83D\uDE0B")
        currentEnergy += 30
        currentWeight += 5
    }

    override fun say() {
        println("$name кукарекает☀\uFE0F\uD83D\uDCE2")
    }

    override fun move() {
        println("$name летает\uD83D\uDE80")
        currentEnergy -= 70
        currentWeight -= 10
        if (isLowEnergy) {
            println("$name помер от недомогания\uD83E\uDD40")
            status = false
        }
    }
}