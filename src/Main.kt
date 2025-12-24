import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Добро пожаловать в зоопарк имени Кащенко!")
    delay(1000)

    val listAnimals = mutableListOf<Animal>()
    listAnimals.addAll(listOf(
        Animal(10, 2, 3, name = "ПЁСЯ"),
        Animal(10, 4, 1, name = "КИСЯ"),
        Begemot(10, 1, 99, name = "БОРЯ")
    ))

    val jobs = listAnimals.map { animal ->
        launch { animal.lifecycle() }
    }

    val monitorJob = launch {
        while (isActive) {
            listAnimals.removeIf { animal ->
                if (!animal.status) {
                    println("--- [!] Хороним ${animal.name} ---")
                    true
                } else {
                    false
                }
            }

            if (listAnimals.isEmpty()) break
            delay(500)
        }
    }

    jobs.joinAll()
    monitorJob.join()
    println("Все животные подохли. Поздравляем!!!!")
}