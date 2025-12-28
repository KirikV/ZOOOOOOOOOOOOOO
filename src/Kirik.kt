class Kirik() : Petuh(
    currentEnergy = 50,
    currentAge = 1,
    currentWeight = 10,
    maxAge = 3,
    name = "Киря"
) {
    override val isVeryFat: Boolean get() = currentWeight >= 50
    override val isTooOld: Boolean get() = currentAge >= maxAge

    override fun say() {
        println("Петух $name орёт СМОТРИ ОКОШКИ")
    }
}