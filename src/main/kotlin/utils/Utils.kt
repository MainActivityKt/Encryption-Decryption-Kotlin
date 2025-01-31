package utils

object Utils {
    val encryptMessage: (String, Int, Algorithm) -> String = { message, key, algorithm ->
        buildString {
            if (algorithm == Algorithm.SHIFT) {
                message.forEach {
                    if (it.isUpperCase()) {
                        val newChar = it + key
                        append(if (newChar in 'A'..'Z') newChar else (
                                if (newChar < 'A') newChar + 26 else newChar - 26)
                        )
                    } else if (it.isLowerCase()) {
                        val newChar = it + key
                        append(if (newChar in 'a'..'z') newChar else (
                                if (newChar < 'a') newChar + 26 else newChar - 26)
                        )
                    } else {
                        append(it)
                    }
                }
            } else {
                message.forEach { append(it + key) }
            }
        }
    }

    val decryptMessage: (String, Int, Algorithm) -> String = { message, key, algorithm ->
        buildString {
            if (algorithm == Algorithm.SHIFT) {
                message.forEach {
                    if (it.isUpperCase()) {
                        val newChar = it - key
                        append(
                            if (newChar in 'A'..'Z') newChar else (
                                    if (newChar < 'A') newChar + 26 else newChar - 26
                                    )
                        )
                    } else if (it.isLowerCase()) {
                        val newChar = it - key
                        append(
                            if (newChar in 'a'..'z') newChar else (
                                    if (newChar < 'a') newChar + 26 else newChar - 26
                                    )
                        )
                    } else {
                        append(it)
                    }
                }
            } else {
                message.forEach { append(it - key) }
            }
        }
    }

}