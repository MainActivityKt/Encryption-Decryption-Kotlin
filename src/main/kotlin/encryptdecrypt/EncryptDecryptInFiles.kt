package encryptdecrypt

import utils.MODE
import utils.Utils.decryptMessage
import utils.Utils.encryptMessage
import java.io.File

/**
 * Returns the value of an argument if exists, an empty string is the argument name doesn't exist, and null
 * if the argument name exists without its value
 */

fun parseValue(argumentName: String, args: Array<String>): String? {


    val argIndex = args.indexOf("-$argumentName")
    if (argIndex != -1) {
        val argValue = args.getOrNull(argIndex + 1)
        if (argValue == null || argValue.startsWith("-")) {
            return null
        }
        return argValue
    }
    return ""
}

fun performOperation(encryptionMode: MODE, key: Int, data: String, inputFile: File?, outputFile: File?) {
    val inputData = data.ifEmpty { inputFile!!.readText() }

    val outputData = when(encryptionMode) {
        MODE.ENC -> encryptMessage(inputData, key)
        MODE.DEC -> decryptMessage(inputData, key)
    }

    if (outputFile != null) {
        outputFile.createNewFile()
        outputFile.writeText(outputData)
    } else {
        println(outputData)
    }
}


fun main(args: Array<String>) {
    val encryptionMode = when (parseValue("mode", args)) {
        "enc", "" -> MODE.ENC
        "dec" -> MODE.DEC
        else -> null
    }
    val key = parseValue("key", args)
    val data = parseValue("data", args)

    val inputPath = parseValue("in", args)
    val outputPath = parseValue("out", args)

    if (encryptionMode == null || key == null ||
        data == null || inputPath == null || outputPath == null || key.toIntOrNull() == null ||
        data.isEmpty() && inputPath.isEmpty()
    ) {
        println("Error: Unable to parse arguments")
        return
    }
    performOperation(encryptionMode,key.toInt(), data, if (data.isEmpty()) File(inputPath) else null,
        if (outputPath.isNotEmpty()) File(outputPath) else null,
    )
}