package encryptdecrypt

private val encryptMessage: (String, Int) -> String = { message, key ->
    buildString {
        message.forEach { append(it + key) }
    }
}

private val decryptMessage: (String, Int) -> String = { message, key ->
    buildString {
        message.forEach { append(it - key) }
    }
}

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