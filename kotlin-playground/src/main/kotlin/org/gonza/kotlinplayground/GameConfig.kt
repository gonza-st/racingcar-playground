package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.service.vo.TryCount

data class GameConfig(
    val carList: List<Car>,
    val tryCount: TryCount,
)
