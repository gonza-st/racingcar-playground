package org.gonza.kotlinplayground.domain.car

import org.gonza.kotlinplayground.utils.NumberGenerator
import org.gonza.kotlinplayground.utils.RandomNumberGenerator

private const val MOVE_CONDITION = 4

class Car(
   name: String,
   private val randomNumberGenerator: NumberGenerator = RandomNumberGenerator()
) {
   private val carName = CarName(name)
   private val carPosition = CarPosition()

   val name: String get() = carName.value
   val position: Int get() = carPosition.value

   fun move() {
      if (canMove()) {
         this.carPosition.move()
      }
   }

   private fun canMove(): Boolean {
      val randomValue = randomNumberGenerator.getNumber()
      return randomValue >= MOVE_CONDITION
   }
}