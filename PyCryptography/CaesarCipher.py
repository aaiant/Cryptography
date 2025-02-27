ALPHABET = ' ABCDEFGHIJKLMNOPQRSTUVWXYZ'
KEY = 3


def caesar_encryption(plain_text):
    cipher_text = ''
    plain_text = plain_text.upper()
    for character in plain_text:
        index = ALPHABET.find(character)
        if index != -1:
            index = (index + KEY) % len(ALPHABET)
            cipher_text += ALPHABET[index]
        else:
            cipher_text += character
    return cipher_text

def caesar_decryption(cipher_text):
    plain_text = ''
    for character in cipher_text:
        index = ALPHABET.find(character)
        if index != -1:
            index = (index - KEY) % len(ALPHABET)
            plain_text += ALPHABET[index]
        else:
            plain_text += character
    return plain_text


if __name__ == '__main__':
    message = 'Every morning, Anna would wake up early to enjoy a cup of coffee on her balcony. The sun would rise slowly, casting a warm glow over the city. She loved this quiet time before the world became busy. As she sipped her coffee, she would often watch the birds fluttering around, searching for their breakfast. The sound of distant traffic would gradually increase, reminding her of the day ahead. With a notebook in hand, she would jot down her thoughts and plans, feeling inspired by the peace of the morning. This simple routine brought her joy and clarity, setting a positive tone for the rest of her day.'
    encrypted_msg = caesar_encryption(message)
    decryptied_msg = caesar_decryption(encrypted_msg)
    print(encrypted_msg)
    print(decryptied_msg)