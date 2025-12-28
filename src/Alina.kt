import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class Alina(val zooList: MutableList<Animal>) : Petuh(
    currentEnergy = 100,
    currentAge = 1,
    currentWeight = 10,
    maxAge = 6,
    name = "Алиночка"
) {
    private var childrenCount = 0
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

                if (chekStatus()) {
                    getChild()
                    println("$name постарела. Её возраст $currentAge")
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
        println("Курочка $name родила нового петуха, Илюха №$childrenCount")

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
}