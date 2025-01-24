package org.gonza.kotlinplayground.domain

data class Race(
    private val carList: List<Car>,
    private var raceTimes: RaceTimes,
    val raceResult: MutableList<String> = mutableListOf(),
    var raceWinners: String = "",
) {
    constructor(
        carNameString: String,
        raceTimes: Int,
        numberGenerator: NumberGenerator,
    ) : this(
        carList = StringSplitter.split(carNameString).map { Car(it, numberGenerator) },
        raceTimes = RaceTimes(raceTimes),
    )

    fun run() {
        while (this.raceTimes.isNotZero()) {
            this.proceedRound()
            val currentPosition = Cars(this.carList).positions()
            this.raceResult.add(currentPosition)
            this.raceTimes = this.raceTimes.decrease()
        }
        this.raceWinners = Cars(this.carList).winners()
    }

    fun timesEqualTo(expectedValue: Int): Boolean = this.raceTimes == RaceTimes(expectedValue)

    internal fun proceedRound(): List<Car> {
        this.carList.forEach { it.move() }
        return this.carList
    }
}
