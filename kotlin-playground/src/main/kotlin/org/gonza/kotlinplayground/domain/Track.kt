package org.gonza.kotlinplayground.domain

class Track(val rap: Rap) {
    private lateinit var cars: Cars
    private lateinit var ranking: Ranking

    private val isInitialized: Boolean
        get() = ::cars.isInitialized && ::ranking.isInitialized

    fun setup(
        cars: Cars,
        ranking: Ranking,
    ): Int {
        this.cars = cars
        this.ranking = ranking

        return cars.size()
    }

    fun start(): Map<Int, List<String>> {
        require(isInitialized) { "트랙이 정비되지 않았습니다." }

        val rankMap = mutableMapOf<Int, List<String>>()
        while (rap.getCurrentRap() < rap.getRound()) {
            val movedCarList = cars.moveAll()
            val rankList = ranking.tempRank(movedCarList)
            rankMap[rap.getCurrentRap()] = rankList

            rap.increaseRound()
        }

        return rankMap
    }
}