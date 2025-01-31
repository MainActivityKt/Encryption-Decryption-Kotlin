package encryptdecrypt

import utils.Algorithm
import utils.Mode
import utils.Utils.decryptMessage
import utils.Utils.encryptMessage


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
        -1 -> Mode.ENC
        else -> {
            val data = args[args.indexOf("-mode") + 1]
            Mode.valueOf(data.uppercase())
        }
    }


    println(when(mode) {
        Mode.ENC -> encryptMessage(text, key, Algorithm.UNICODE)
        Mode.DEC -> decryptMessage(text, key, Algorithm.UNICODE)
    })
}