# Encryption-Decryption (Kotlin)

Today, encryption and decryption algorithms are everywhere, to protect our data.
They are vital for sites that handle sensitive data, such as e-commerce sites 
that accept online card payments and login areas that require users to enter their 
credentials. Complex encryption algorithms are behind the scenes to ensure
the security of data.

In this project, our program encrypts and decrypts messages and 
texts using simple algorithms. These algorithms are not 
suitable for industrial use but  
illustrate general ideas of encryption.

## Stage 1/6: Encrypted!

In the first stage, our program manually encrypts the message "we found a treasure!" and prints it out.

Each character of the message which is a lowercase letter, is replaced with
the letter that is in the corresponding position from the end of the English alphabet. Non letter characters remain as is.

Example: `(a → z, b → y, c → x, ... x → c, y  → b, z → a)`

[Open stage 1 on Hyperskill](https://hyperskill.org/projects/279/stages/1415/implement)

Stage implementation: [Encrypt.kt](src/main/kotlin/encryptdecrypt/Encrypt.kt)


## Stage 2/6: Knowledge is key

In this stage, the encryption will be controlled by a key, a special parameter that controls the
behavior of our encryption algorithm.

The key is assumed to mean that if a person knows the value of the key, they will be able to decrypt the text, and 
if they do not know it, they will not be able to decrypt the text. It's like a real key that can open up access to the message text.

Also, in this stage, both the message and the key are read from the input, in that order. 

[Open stage 2 on Hyperskill](https://hyperskill.org/projects/279/stages/1416/implement)

Stage implementation: [EncryptWithKey.kt](src/main/kotlin/encryptdecrypt/EncryptWithKey.kt)

**Example:**

    > welcome to hyperskill
    > 5
    bjqhtrj yt mdujwxpnqq

## Stage 3/6: Decrypted

In this stage, decryption is also added into the program. 
Decryption is simply the inverse of encryption, following the same
steps but reversing the order in which the keys are applied.

Now, the program reads three lines from the standard input: a
target operation (`enc` for encryption, `dec` for decryption), a message
or a ciphertext, and a key to encrypt/decrypt messages. 

All non-letter characters are encrypted as well as regular letters.

[Open stage 3 on Hyperskill](https://hyperskill.org/projects/279/stages/1417/implement)

Stage implementation: [EncryptAndDecrypt.kt](src/main/kotlin/encryptdecrypt/EncryptAndDecrypt.kt)

**Example 1: encryption**

    > enc
    > Welcome to hyperskill!
    > 5
    \jqhtrj%yt%m~ujwxpnqq&

**Example 2: decryption**

    > dec
    > \jqhtrj%yt%m~ujwxpnqq&
    > 5
    Welcome to hyperskill!

## Stage 4/6: I command you

Now, the program must parse three arguments: `-mode`, `-key`, and `-data`.
The first argument should determine the program's mode 
(enc for encryption, dec for decryption). The second argument is
an integer key to modify the message, and the third is a text or 
ciphertext to encrypt/decrypt.

- If there is no `-mode`, the program should work in the `enc` mode

- If there is no `-key`, the program should consider that it is `0`

- If there is no `-data`, the program should assume that data is an empty string.

[Open stage 4 on Hyperskill](https://hyperskill.org/projects/279/stages/1418/implement)

Stage implementation: [EncDecWithArgs.kt](src/main/kotlin/encryptdecrypt/EncDecWithArgs.kt)

**Example 1: encryption** 

args: `-mode enc -key 5 -data "Welcome to hyperskill!"`
    
Output: `\jqhtrj%yt%m~ujwxpnqq&`


**Example 2: decryption**

args: `-key 5 -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec`

Output: `Welcome to hyperskill!`

## Stage 5/6: X-files, Stage 6/6: Choice, choice

Now,the ability to read and write the original and cipher data into files is added to our program.

The program must parse three additional arguments `-in`
and `-out` to specify the full name of a file to read the data and write the result, and `-algorithm` to 
specify algorithm used for encryption/decryption. 

The two algorithms we used here are shift and unicode. 

In case of shift,
only English letters — from "a" to "z" and from "A" to "Z" are encoded. In other words, after "z" comes "a", after "Z" comes "A".

In case of unicode, every character is encoded, and the letters are not shifted. 

To sum up:

- `-mode`: Specifies whether it's encryption or decryption we want to do. The values "enc" and "dec" are used for 
encryption and decryption, in that order. If it's not specified, the default is encryption.

- `-key`: Specifies the integer key for encryption/decryption. Default value: 0 
- `-data`: Specifies the string data as the program input.
- `in`: Specified the path to the program input text file.
- If there is no -data and no -in the program assumes that the data is an empty string;
- If there are both -data and -in arguments, the program prioritizes `-data` over `-in`.
- `-out`: Specified the path of output txt file. The output is printed out if this argument is missing.
- `-alg`: Specifies the algorithm used for encryption/decryption, "unicode" or "shift", in that order. Default value: "shift".

If there is something strange (an input file does not exist, or an argument doesn't have a value), the program gets terminated with a clear error message.

[Open stage 4 on Hyperskill](https://hyperskill.org/projects/279/stages/1419/implement)

[Open stage 5 on Hyperskill](https://hyperskill.org/projects/279/stages/1420/implement)

Note: The solution for stages 5 and 6 are combined in one file.

Stages implementation: [EncryptDecryptInFile.kt](src/main/kotlin/encryptdecrypt/EncryptDecryptInFile.kt)


**Example 1: reading and writing to files**

args: `-mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode`

This command reads data from _road_to_treasure.txt_, encrypts the data with the key of 5, creates _protected.txt_, 
and writes _ciphertext_ into it.

**Example 2: encryption with the unicode algorithm**

args `-mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode`

Output: `\jqhtrj%yt%m~ujwxpnqq&`

**Example 3: decryption with the unicode algorithm**
args `-key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec`

Output: `Welcome to hyperskill!`
