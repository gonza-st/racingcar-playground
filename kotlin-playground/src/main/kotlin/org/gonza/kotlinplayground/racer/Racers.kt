package org.gonza.kotlinplayground.racer

class Racers(
    private val racers: List<Racer>
) {
    init {
        require(racers.isNotEmpty()) { "레이서가 한 명 이상 있어야 합니다." }
    }
    fun race(turns: Int) {
        repeat(turns) {
            racers.forEach { racer ->
                racer.race()
                visualize(racer)
            }
            println("----- turn ${it + 1} end -----")
        }
    }
    private fun visualize(racer: Racer) {
        println("${racer.car.name}: ${"-".repeat(racer.car.location)}")
    }

    fun getRacers(): List<Racer> = racers.toList()
}
