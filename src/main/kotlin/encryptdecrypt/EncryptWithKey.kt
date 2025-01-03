package encryptdecrypt

private val encrypt: (String, Int) -> String = { message, key ->
    buildString {
        message.forEach {
            if (it.isLowerCase()) {
                val newChar = it + key
                append(if (newChar <= 'z') newChar else (newChar - 26))
            } else {
                append(it)
            }
        }
    }
}

fun main() {
    val message: String = readln()
    val key: Int = readln().toInt()
    println(encrypt(message, key))
}