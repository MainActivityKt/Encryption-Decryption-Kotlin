package utils

object Utils {
    val encryptMessage: (String, Int) -> String = { message, key ->
        buildString {
            message.forEach { append(it + key) }
        }
    }

    val decryptMessage: (String, Int) -> String = { message, key ->
        buildString {
            message.forEach { append(it - key) }
        }
    }
}