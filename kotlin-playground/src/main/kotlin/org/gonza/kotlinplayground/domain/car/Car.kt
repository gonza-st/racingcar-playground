package org.gonza.kotlinplayground.domain.car

class Car(
   name: String,
) {
   private val carName = CarName(name)
   private val carPosition = CarPosition()
   val name: String get() = carName.value
   val position: Int get() = carPosition.value

   fun move() {
      this.carPosition.move()
   }
}