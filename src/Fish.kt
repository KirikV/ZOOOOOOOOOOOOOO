class Fish(
    currentEnergy: Int,
    currentAge: Int
) : Animal(
    currentEnergy = currentEnergy,
    currentAge = currentAge,
    currentWeight = listOf(1, 3, 5).random(),
    maxAge = 5,
    name = listOf("\uD83E\uDD88Розовая Акула", "\uD83D\uDC19Голубой осьминог", "\uD83D\uDC20Оранжевый карась").random()
) {
    override val isVeryFat: Boolean get() = currentWeight >= 10

    override fun say() {
        println("$name молчит, ему похуй\uD83E\uDEE7")
    }

    override fun eat() {
        println("$name глотает планктон\uD83D\uDE0B")
        currentEnergy += 10
        currentWeight += 2
        if (isVeryFat) {
            println("\uD83D\uDCA5$name лопнул от переедания\uD83D\uDCA5")
            status = false
        }
    }

    override fun move() {
        println("$name плавает\uD83C\uDFCA")
        currentEnergy -= 15
        currentWeight -= 5
        if (isLowEnergy) {
            println("$name помер от недомогания\uD83E\uDD40")
            status = false
        }
    }


}