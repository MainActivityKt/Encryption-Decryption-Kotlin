package utils

import utils.Utils.decryptMessage
import utils.Utils.encryptMessage

enum class MODE(val function: (String, Int) -> String) {
    ENC(encryptMessage), DEC(decryptMessage)
}