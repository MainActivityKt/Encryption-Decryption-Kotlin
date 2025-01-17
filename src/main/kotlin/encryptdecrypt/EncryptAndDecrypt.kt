package encryptdecrypt

import utils.Utils.decryptMessage
import utils.Utils.encryptMessage

private enum class Operation(val shortName: String, val function: (String, Int) -> String) {
    ENCRYPT("enc", encryptMessage), DECRYPT("dec", decryptMessage)
}

fun main() {
    val operation = when(readln()) {
        Operation.ENCRYPT.shortName -> Operation.ENCRYPT
        else -> Operation.DECRYPT
    }
    val message = readln()
    val key = readln().toInt()

    println(operation.function.invoke(message, key))
}