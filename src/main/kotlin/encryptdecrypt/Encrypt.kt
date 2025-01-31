package encryptdecrypt
import kotlin.math.abs

private const val MESSAGE = "we found a treasure!"

private val encryptCharacter: (Char) -> Char = {
    if (it.isLowerCase()) (122 - abs(97 - it.code)).toChar() else it
}

fun main() {
    println(MESSAGE.map(encryptCharacter).joinToString(""))
}