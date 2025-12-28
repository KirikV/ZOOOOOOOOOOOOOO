import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class Alina(val zooList: MutableList<Animal>) : Petuh(
    currentEnergy = 100,
    currentAge = 1,
    currentWeight = 10,
    maxAge = 10,
    name = "\uD83D\uDE07\uD83D\uDC14Алиночка"
) {
    private var childrenCount = 1
    override val isVeryFat: Boolean get() = currentWeight >= 50
    override val isTooOld: Boolean get() = currentAge >= maxAge

    override suspend fun lifecycle() {
        while (status) {
            val zizn = listOf(::eat, ::sleep, ::move, ::say)
            var allActionIsCompleted = true

            for (action in zizn) {
                action()
                if (!chekStatus()) {
                    allActionIsCompleted = false
                    break
                }
                delay(3000)
            }

            if (allActionIsCompleted && status) {
                currentAge += 1
                println("$name постарела⏳")
                if (chekStatus()) {
                    getChild()
                } else {
                    break
                }
            } else {
                break
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getChild() {
        childrenCount++
        println("$name родила нового петуха\uD83D\uDC23, Илюха №$childrenCount\uD83D\uDC13")

        val babyIlya = Ilya(
            currentEnergy = 50,
            currentAge = 1,
            currentWeight = 10,
            maxAge = 2,
            id = childrenCount
        )

        zooList.add(babyIlya)

        GlobalScope.launch {
            babyIlya.lifecycle()
        }
    }

    override fun eat() {
        println("$name отбирает у Ильи хавку и начинает жрать с лопаты 🌾🥘")
        currentWeight += 20
        currentEnergy += 10

        if (isVeryFat) {
            println("НА НАХУЙ $name ВЗОРВАЛАСЬ ОТ ХАВКИ 💥💨")
            status = false
        }
    }
}