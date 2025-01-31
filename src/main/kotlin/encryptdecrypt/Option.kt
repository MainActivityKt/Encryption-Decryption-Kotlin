package encryptdecrypt

import utils.Mode
import java.io.File

data class Option(
    val mode: Mode,
    val key: Int = 0,
    val data: String = "",
    val inputFile: File?,
    val outputFile: File?
)