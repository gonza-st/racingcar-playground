package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.service.vo.CarName
import org.gonza.kotlinplayground.service.vo.TryCount

data class GameConfig(
    val carName: CarName,
    val tryCount: TryCount
)
