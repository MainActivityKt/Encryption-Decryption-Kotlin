package encryptdecrypt

import utils.Utils.decryptMessage
import utils.Utils.encryptMessage


private enum class MODE(val function: (String, Int) -> String) {
    ENC(encryptMessage), DEC(decryptMessage)
}

fun main(args: Array<String>) {

    val key = when(args.indexOf("-key")) {
        -1 -> 0
        else -> args[args.indexOf("-key") + 1].toInt()
    }

    val text = when(args.indexOf("-data")) {
        -1 -> ""
        else -> args[args.indexOf("-data") + 1]
    }

    val mode = when(args.indexOf("-mode")) {
        -1 -> MODE.ENC
        else -> {
            val data = args[args.indexOf("-mode") + 1]
            MODE.valueOf(data.uppercase())
        }
    }


    println(when(mode) {
        MODE.ENC -> encryptMessage(text, key)
        MODE.DEC -> decryptMessage(text, key)
    })
}