package org.gonza.kotlinplayground.racingCarPlayGround

class RacingController(private var cars: Cars, val round: Int) {
    companion object {
        private const val MOVABLE_STANDARD = 4
    }

    init {
        require(cars.isNotEmpty()) { "경주에 참여할 차가 최소 1대 이상이어야 한다" }
        require(round > 0) { "시도할 횟수는 1회 이상이어야 한디" }
    }

    fun printCars() {
        val carNames = cars.carList.joinToString(", ") { it.name }
        println(carNames)
    }

    fun getRandom(): Int {
        return (0..9).random()
    }

    fun canMove(randomNumber: Int): Boolean {
        return randomNumber >= MOVABLE_STANDARD
    }


    fun findWinners(): List<Car> {
        val maxPosition = cars.getMaxPosition()
        return cars.findWinners(maxPosition)
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { winner -> winner.name }
        println("$winnerNames 가 최종 우승했습니다.")
    }


    fun playRound() {
        val updatedCars = cars.carList.map { car ->
            val randomNumber = getRandom()
            if (canMove(randomNumber)) {
                car.move()
            } else {
                car
            }
        }

        cars = Cars.fromList(updatedCars)
        cars.printCars()
    }

    fun playRace() {
        println("경주할 자동차 이름을 입력하세요")
        printCars()
        println()

        println("시도할 횟수는 몇 회 인가요?\n$round\n")

        println("실행 결과")

        repeat(round) {
            playRound()
        }

        val winners: List<Car> = findWinners()
        printWinners(winners)
    }
}