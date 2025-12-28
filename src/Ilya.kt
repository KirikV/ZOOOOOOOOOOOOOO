class Ilya(
    currentEnergy: Int,
    currentAge: Int,
    currentWeight: Int,
    maxAge: Int,
    id: Int = 0
) : Petuh(
    currentEnergy = 10,
    currentAge = 1,
    currentWeight = 10,
    maxAge = 5,
    name = if (id == 0) "\uD83D\uDC13Илюха" else "\uD83D\uDC13Илюха №$id"
) {
    override val isVeryFat: Boolean get() = currentWeight >= currentEnergy
    override val isTooOld: Boolean get() = currentAge >= maxAge

    override fun say() {
        println("$name орёт ОНА АНГЕЛ\uD83D\uDE07")
    }

    override fun move() {
        println("$name летает\uD83D\uDE80")
        currentEnergy -= 5
        currentWeight -= 10
        if (isLowEnergy) {
            println("$name помер от недомогания\uD83E\uDD40")
            status = false
        }
    }
}