class Ilya(
    currentEnergy: Int,
    currentAge: Int,
    currentWeight: Int,
    maxAge: Int,
    id: Int = 0
) : Petuh(
    currentEnergy = 31,
    currentAge = 1,
    currentWeight = 1,
    maxAge = 10,
    name = if (id == 0) "\uD83D\uDC13Илюха" else "\uD83D\uDC13Илюха №$id"
) {
    override val isVeryFat: Boolean get() = currentWeight >= currentEnergy
    override val isTooOld: Boolean get() = currentAge >= maxAge

    override fun say() {
        println("$name орёт ОНА АНГЕЛ\uD83D\uDE07")
    }

    override fun move() {
        println("$name летает\uD83D\uDE80")
        currentEnergy -= 30
        currentWeight -= 2
        if (isLowEnergy) {
            println("$name помер от недомогания\uD83E\uDD40")
            status = false
        }
    }
    override fun eat() {
        println("$name очень мало ест\uD83D\uDE0B")
        currentEnergy += 2
        currentWeight += 1
        if (isVeryFat) {
            println("$name лопнул от переедания\uD83D\uDCA5")
            status = false
        }
    }

    override fun sleep() {
        println("$name очень мало спит. Думает об Алиночке\uD83D\uDE35\u200D\uD83D\uDCAB")
        currentEnergy += 5
    }
}