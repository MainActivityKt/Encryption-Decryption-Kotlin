package encryptdecrypt

import utils.MODE
import java.io.File

data class Option(
    val mode: MODE,
    val key: Int = 0,
    val data: String = "",
    val inputFile: File?,
    val outputFile: File?
)