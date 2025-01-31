package encryptdecrypt

import utils.Algorithm
import utils.Mode
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

fun performOperation(
    encryptionMode: Mode,
    key: Int, data: String,
    algorithm: Algorithm,
    inputFile: File?, outputFile: File?) {
    val inputData = data.ifEmpty { inputFile!!.readText() }

    val outputData = when(encryptionMode) {
        Mode.ENC -> encryptMessage(inputData, key, algorithm)
        Mode.DEC -> decryptMessage(inputData, key, algorithm)
    }

    if (outputFile != null) {
        outputFile.createNewFile()
        outputFile.writeText(outputData)
    } else {
        println(outputData)
    }
}


fun main(args: Array<String>) {
    val mode = when (parseValue("mode", args)) {
        "enc", "" -> Mode.ENC
        "dec" -> Mode.DEC
        else -> null
    }
    val key = parseValue("key", args)
    val data = parseValue("data", args)
    val algorithm = when(parseValue("alg", args)) {
        "unicode" -> Algorithm.UNICODE
        null -> null
        else -> Algorithm.SHIFT
    }

    val inputPath = parseValue("in", args)
    val outputPath = parseValue("out", args)

    if (mode == null || key == null ||
        data == null || inputPath == null || outputPath == null || key.toIntOrNull() == null ||
        algorithm == null || data.isEmpty() && inputPath.isEmpty()
    ) {
        println("Error: Unable to parse arguments")
        return
    }
    performOperation(
        encryptionMode = mode,
        key = key.toInt(),
        data = data,
        algorithm = algorithm,
        inputFile = if (data.isEmpty()) File(inputPath) else null,
        outputFile = if (outputPath.isNotEmpty()) File(outputPath) else null,
    )
}