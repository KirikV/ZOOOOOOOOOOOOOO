import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CopyOnWriteArrayList

fun main() = runBlocking {
    println(
        "=========================================\n" +
                "Добро пожаловать в зоопарк имени Кащенко!\n" +
                "========================================="
    )
    delay(3000)

    val listAnimals = CopyOnWriteArrayList<Animal>()
    val threeFishes = List(3) { Fish(10, 1) }
    listAnimals.addAll(
        listOf(
            Animal(10, 2, 3, name = "\uD83D\uDC36ПЁСЯ"),
            Animal(10, 4, 1, name = "\uD83D\uDC08КИСЯ"),
            Begemot(10, 1, 99, name = "\uD83E\uDD9BБОРЯ"),
            Petuh(10, 1, 10, maxAge = 3, name = "\uD83D\uDC13Здравый Смысл"),
            Kirik(),
            Ilya(10, 1, 10, maxAge = 3),
            Alina(listAnimals)
        )
    )
    listAnimals.addAll(threeFishes)

    listAnimals.forEach { animal ->
        launch { animal.lifecycle() }
    }

    val monitorJob = launch {
        while (isActive) {
            listAnimals.removeIf { animal ->
                if (!animal.status) {
                    println("\n☦\uFE0F--- [!] Хороним ${animal.name} ---☦\uFE0F\n")
                    true
                } else {
                    false
                }
            }

            if (listAnimals.isEmpty()) {
                println("Все животные подохли. Поздравляем!!!!")
                break
            }
            delay(500)
        }
    }

    monitorJob.join()
}