package racing.model

import racing.strategy.MoveStrategy

class Race(private val numberOfTrials: Int, cars: List<Car>) {
    private val _cars: List<Car> = cars.deepCopy()
    val cars: List<Car>
        get() = _cars.deepCopy()

    constructor(numberOfTrials: Int, carNames: String) : this(
        numberOfTrials,
        carNames.split(CAR_NAME_DELIMITER).map { Car(it) }
    )

    private fun List<Car>.deepCopy(): List<Car> = map { Car(it.name, it.raceHistory) }

    fun run(moveStrategy: MoveStrategy) {
        repeat(numberOfTrials) {
            makeTurn(moveStrategy)
        }
    }

    private fun makeTurn(strategy: MoveStrategy) {
        for (car in _cars) {
            car.saveResultOfTurn(strategy.getResultOfTurn())
        }
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
    }
}
