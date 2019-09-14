import java.util.*

class Unit {
    lateinit var type: String //B=branch R=result
    lateinit var result: String
    var freq: Int = 0
    lateinit var link0: Unit
    lateinit var link1: Unit
    var ownCode: String = ""

    fun getCode() {
        if (type == "B") {
            link0.ownCode = ownCode + "0"
            link1.ownCode = ownCode + "1"
            link0.getCode()
            link1.getCode()
        }
    }

    fun test() {
        if (type == "B") {
            println("\n$result:$freq")
            println("link0:")
            link0.test()
            println("link1:")
            link1.test()
        } else {
            println("$result:$freq:$ownCode")
        }
    }

    fun getResultUnits(): Vector<Unit> {
        val resultUnits: Vector<Unit> = Vector(0)

        if (link0.type == "B") {
            resultUnits.addAll(link0.getResultUnits())
        } else {
            resultUnits.addElement(link0)
        }
        if (link1.type == "B") {
            resultUnits.addAll(link1.getResultUnits())
        } else {
            resultUnits.addElement(link1)
        }

        return resultUnits
    }
}