package `in`.yashasvi.memorygame.controller


interface GameStateChangeListener {
    fun onGameOver();
    fun onLevelChange(prevLevel: Int, curLevel: Int)
}