package org.gonza.kotlinplayground

class Race(
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Race) return false

        if (raceTimes != other.raceTimes) return false
        if (carList != other.carList) return false
        if (raceResult != other.raceResult) return false

        return true
    }

    override fun hashCode(): Int {
        var result = raceTimes.hashCode()
        result = 31 * result + carList.hashCode()
        result = 31 * result + raceResult.hashCode()
        return result
    }

    override fun toString(): String = "Race(carList=$carList, raceTimes=$raceTimes, raceResult=$raceResult)"
}
