package org.gonza.kotlinplayground.racer

class Racers(
    private val racers: List<Racer>
) {
    init {
        require(racers.isNotEmpty()) { "레이서가 한 명 이상 있어야 합니다." }
    }
    fun play(turns: Int) {
        require(turns >= 0) { "턴 수는 0 이상이어야 합니다." }

        repeat(turns) {
            racers.forEach { racer ->
                racer.race()
                visualize(racer)
            }
        }
    }

    fun winner(): List<Racer> {
        val maxLocation = racers.maxOf { it.car.location }
        return racers.filter { it.car.location == maxLocation }
    }

    private fun visualize(racer: Racer) {
        println("${racer.car.name}: ${"-".repeat(racer.car.location)}")
    }
}
