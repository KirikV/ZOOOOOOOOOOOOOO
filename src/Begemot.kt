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
        println("Бегемот $name ебашит ртом как экскаватор")
        currentEnergy += 30
        currentWeight += 20
    }

    override fun say() {
        println("Бегемот $name рыгает и пукает")
    }

    override fun sleep() {
        println("Бегемот $name спит (во сне пукает и рыгает)")
        currentEnergy += 30
    }

}