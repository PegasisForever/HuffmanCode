fun main(args: Array<String>) {
    val words = arrayOf("a", "b", "c", "d", "e")
    val freqs = arrayOf(6, 15, 2, 9, 1)


    val code = HuffmanCode(words, freqs)
    code.makeCode()
    val hmc = code.getCode()

    for (it in hmc) {
        println(it.word + ":" + it.key)
    }

}