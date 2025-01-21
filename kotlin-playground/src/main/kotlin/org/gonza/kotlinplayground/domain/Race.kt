package org.gonza.kotlinplayground.domain

data class Race(
    private val carList: List<Car>,
    private var raceTimes: RaceTimes,
    private var raceResult: MutableList<Cars> = mutableListOf(),
) {
    constructor(
        carNames: String,
        raceTimes: Int,
        numberGenerator: NumberGenerator,
    ) : this(
        carList = NameSplitter.split(carNames).map { Car(it, numberGenerator) },
        raceTimes = RaceTimes(raceTimes),
    )

    fun run() {
        while (this.raceTimes.isNotZero()) {
            this.proceed()
            val currentCars = addHistory()
            this.raceResult.add(currentCars)
            this.raceTimes = this.raceTimes.decrease()
        }
    }

    fun timesEqualTo(expectedValue: Int): Boolean = this.raceTimes.equal(expectedValue)

    fun raceResult(): List<Cars> = this.raceResult

    private fun addHistory(): Cars = Cars(copyCarList())

    private fun copyCarList(): List<Car> {
        val copiedCarList: List<Car> = this.carList.map { car -> copyCar(car) }
        return copiedCarList
    }

    private fun copyCar(car: Car) =
        Car(
            name = car.name,
            position = Position(car.position()),
            numberGenerator = car.numberGenerator,
        )

    internal fun proceed(): List<Car> {
        this.carList.forEach { it.move() }
        return this.carList
    }
}
