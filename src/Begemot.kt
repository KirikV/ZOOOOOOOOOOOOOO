open class Begemot(
    currentEnergy: Int,
    currentAge: Int,
    currentWeight: Int,
    name: String
) : Animal(
    currentEnergy = currentEnergy,
    currentAge = currentAge,
    currentWeight = currentWeight,
    maxAge = 3,
    name
) {
    override val isVeryFat: Boolean get() = currentWeight >= 150

    override fun eat() {
        println("$name ебашит хавку как экскаватор\uD83C\uDFD7\uFE0F")
        currentEnergy += 30
        currentWeight += 20
        if (isVeryFat) {
            println("$name лопнул от переедания\uD83D\uDCA5")
            status = false
        }
    }

    override fun say() {
        println("$name рыгает и пукает\uD83E\uDD22")
    }

    override fun sleep() {
        println("$name спит (во сне пукает и рыгает)\uD83D\uDE34\uD83E\uDD22")
        currentEnergy += 30
    }

}