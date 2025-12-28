import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CopyOnWriteArrayList

fun main() = runBlocking {
    println("Добро пожаловать в зоопарк имени Кащенко!")

    val listAnimals = CopyOnWriteArrayList<Animal>()
    val threeFishes = List(3) { Fish(10, 1) }
    listAnimals.addAll(
        listOf(
            Animal(10, 2, 3, name = "ПЁСЯ"),
            Animal(10, 4, 1, name = "КИСЯ"),
            Begemot(10, 1, 99, name = "БОРЯ"),
            Petuh(10, 1, 10, maxAge = 3, name = "Здравый Малый"),
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
                    println("\n--- [!] Хороним ${animal.name} ---\n")
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