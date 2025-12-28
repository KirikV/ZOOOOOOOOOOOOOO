class Fish(
    currentEnergy: Int,
    currentAge: Int
) : Animal(
    currentEnergy = currentEnergy,
    currentAge = currentAge,
    currentWeight = listOf(1, 3, 5).random(),
    maxAge = 5,
    name = listOf("Розовая Акула", "Голубой осьминог", "Оранжевый карась").random()
) {
    override val isVeryFat: Boolean get() = currentWeight >= 10


    override fun say() {
        println("Рыба $name молчит, ей похуй")
    }

    override fun eat() {
        println("$name глотает планктон")
        currentEnergy += 10
        currentWeight += 2
        if (isVeryFat) {
            println("$name лопнул от переедания")
            status = false
        }
    }
}