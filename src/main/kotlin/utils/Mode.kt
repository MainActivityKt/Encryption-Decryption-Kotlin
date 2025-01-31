package utils

import utils.Utils.decryptMessage
import utils.Utils.encryptMessage

enum class Mode(val function: (String, Int, Algorithm) -> String) {
    ENC(encryptMessage), DEC(decryptMessage)
}