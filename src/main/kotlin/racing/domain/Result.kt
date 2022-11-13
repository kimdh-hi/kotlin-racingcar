package racing.domain

class Result {
    private val roundResults: MutableList<Positions> = mutableListOf()
    val positionsList: List<Positions>
        get() = roundResults.toList()

    fun add(positions: Positions) {
        roundResults.add(positions)
    }
}
