import java.util.*

class BubbleSort(inputUnits: Vector<Unit>) {
    private var units = inputUnits
    lateinit var tem: Unit
    var pass = true

    fun B2S() { //Biggest--->Smallest
        do {
            pass = true
            for (i in units.size - 1 downTo 1) {
                if (units[i].freq > units[i - 1].freq) {
                    tem = units[i - 1]
                    units[i - 1] = units[i]
                    units[i] = tem
                }
            }

            for (i in units.size - 1 downTo 1) {
                if (units[i].freq > units[i - 1].freq) {
                    pass = false
                }
            }
        } while (!pass)
    }

    fun S2B() { //Smallest--->Biggest
        do {
            pass = true
            for (i in units.size - 1 downTo 1) {
                if (units[i].freq < units[i - 1].freq) {
                    tem = units[i - 1]
                    units[i - 1] = units[i]
                    units[i] = tem
                }
            }

            for (i in units.size - 1 downTo 1) {
                if (units[i].freq < units[i - 1].freq) {
                    pass = false
                }
            }
        } while (!pass)
    }

    fun test() {
        for (unit in units) {
            println(unit.result + ":" + unit.freq)
        }
    }
}