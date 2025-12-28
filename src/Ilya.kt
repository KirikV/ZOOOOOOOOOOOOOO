class Ilya(
    currentEnergy: Int,
    currentAge: Int,
    currentWeight: Int,
    maxAge: Int,
    id: Int = 0
) : Petuh(
    currentEnergy = 20,
    currentAge = 1,
    currentWeight = 15,
    maxAge = 2,
    name = if (id == 0) "Илюха" else "Илюха №$id"
) {
    override val isVeryFat: Boolean get() = currentWeight >= currentEnergy
    override val isTooOld: Boolean get() = currentAge >= maxAge

    override fun say() {
        println("Петух $name орёт ОНА АНГЕЛ")
    }

    override fun move() {
        println("$name передвигается")
        currentEnergy -= 5
        currentWeight -= 10
        if (isLowEnergy) {
            println("$name помер от недомогания")
            status = false
        }
    }
}