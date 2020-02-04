# SimpleEncryption
 
CLI application for encrypting and decrypting text and files.
Supports original Caesar's Cipher and a variant utilizing the entire Unicode table instead of latin alphabet.


## Usage
The program takes following arguments:
 - `-mode`: Accepts parameters `enc` and `dec` for encryption and decryption respectively
 - `-key`: Specifies by how many characters the data is shifted
 - `-data`: Accepts a string for processing
 - `-in`: Accepts a file for processing
 - `-out`: Sets the output file, outputs to console if not set
 - `-alg`: Sets the encryption algorythm, accepts `shift` for original caesar's or `unicode` for the extended variant
### Example
`se.jar -mode enc -key 5 -data "hello world" -alg unicode -out encrypted.txt `

