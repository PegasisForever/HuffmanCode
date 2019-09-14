import java.util.*

class HuffmanCode(inputWords: Array<String>, inputFreqs: Array<Int>) {
    private val words = inputWords
    private val freqs = inputFreqs
    private var resultUnits: Vector<Unit> = Vector(0)
    private lateinit var codeUnit: Unit

    init {
        for (i in words.indices) {
            val resultUnit = Unit()
            resultUnit.type = "R"
            resultUnit.freq = freqs[i]
            resultUnit.result = words[i]
            resultUnits.addElement(resultUnit)
        }
        val sortResultUnits = BubbleSort(resultUnits)
        sortResultUnits.S2B()
    }

    fun makeCode() {

        val allUnits: Vector<Unit> = Vector(0)
        allUnits.addAll(resultUnits)

        while (allUnits.size > 1) {
            val sortAllUnits = BubbleSort(allUnits)
            sortAllUnits.S2B()

            val branchUnit = Unit()
            branchUnit.type = "B"
            branchUnit.freq = allUnits[0].freq + allUnits[1].freq
            branchUnit.result = allUnits[0].result + "/" + allUnits[1].result
            branchUnit.link0 = allUnits[0]
            branchUnit.link1 = allUnits[1]
            allUnits.addElement(branchUnit)

            allUnits.removeAt(0)
            allUnits.removeAt(0)
        }

        codeUnit = allUnits[0]
    }

    fun getCode(): Vector<Code> {
        val allCode: Vector<Code> = Vector(0)
        codeUnit.getCode()

        resultUnits = codeUnit.getResultUnits()
        for (unit in resultUnits) {
            val c = Code()
            c.key = unit.ownCode
            c.word = unit.result
            allCode.addElement(c)
        }

        return allCode

    }

    fun unCode(code: String): String {
        var nextUnit = codeUnit

        for (i in 0 until code.length) {
            when (code.toCharArray()[i]) {
                '0' -> nextUnit = nextUnit.link0
                '1' -> nextUnit = nextUnit.link1
            }
        }
        return nextUnit.result
    }
}