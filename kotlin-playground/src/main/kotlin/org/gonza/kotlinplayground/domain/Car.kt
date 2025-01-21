import org.gonza.kotlinplayground.domain.CarName

class Car(
   private val carName: CarName,
) {
   val name: String get() = carName.value
   constructor(name: String): this(
      CarName(name)
   )
}