class Begemot(cEnergy: Int, cAge: Int, ctWeight: Int, name: String) :Animal(
    currentEnergy = 100, currentAge = 30, currentWeight = 70, maxAge = 100, name){
    override var status: Boolean = true
    override val isVeryFat: Boolean get() = currentWeight >= 150

    override fun chekStatus(): Boolean {
        when {
            isTooOld -> {
                status = false
                println("Бегемот $name сдох от старости")
            }

            isVeryFat -> {
                status = false
                println("$name сдох от ожирения")
            }

            isLowEnergy -> {
                status = false
                println("$name сдох от недомогания")
            }
        }
        return status
    }

    override fun eat() {
        println("Бегемот $name ебашит ртом как экскаватор")
        currentEnergy += 30
        currentWeight += 20
        println("Текущая энергия = $currentEnergy")
        println("Текущий вес = $currentWeight")
    }

    override suspend fun lifecycle() {
        super.lifecycle()
    }

    override fun say(){
        println("Бегемот $name рыгает и пукает")
    }

    override fun sleep() {
        println("Бегемот $name спит (во сне пукает и рыгает)")
        currentEnergy += 30
        println("Текущая энергия = $currentEnergy")
    }

}