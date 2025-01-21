import org.gonza.kotlinplayground.domain.CarName
import org.gonza.kotlinplayground.domain.CarPosition

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