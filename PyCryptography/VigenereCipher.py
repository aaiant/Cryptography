ALPHABET = ' ABCDEFGHIJKLMNOPQRSTUVWXYZ'


def vigenere_encryption(plain_text, key):
    plain_text = plain_text.upper()
    key = key.upper()
    cipher_text = ''
    key_index = 0

    for character in plain_text:
        index = (ALPHABET.find(character) + ALPHABET.find(key[key_index])) % len(ALPHABET)
        cipher_text += ALPHABET[index]

        key_index += 1

        if key_index == len(key):
            key_index = 0

    return cipher_text


def vigenere_decrypt(cipher_text, key):
    cipher_text = cipher_text.upper()
    key = key.upper()
    plain_text = ''
    key_index = 0

    for character in cipher_text:
        index = (ALPHABET.find(character) - ALPHABET.find(key[key_index])) % len(ALPHABET)
        plain_text += ALPHABET[index]

        key_index += 1

        if key_index == len(key):
            key_index = 0

    return plain_text


if __name__ == '__main__':
    message = 'CRYPTOGRAPHY IS QUITE IMPORTANT IN CRYPTOCURRENCIES'
    key = 'TABLE'
    encrypted_msg = vigenere_encryption(message, key)
    decrypted_msg = vigenere_decrypt(encrypted_msg, key)
    print(encrypted_msg)
    print(decrypted_msg)