ALPHABET = ' ABCDEFGHIJKLMNOPQRSTUVWXYZ'


def crack_caesar(cipher_text):
    for key in range(len(ALPHABET)):
        plain_text = ''

        for character in cipher_text:
            index = ALPHABET.find(character)
            index = (index - key) % len(ALPHABET)
            plain_text += ALPHABET[index]
        print('With key %s, the result is: %s' % (key, plain_text))


if __name__ == '__main__':
    encrypted_msg = 'HYHUACPRUQLQJBCDQQDCZRXOGCZDNHCXSCHDUOACWRCHQMRACDCFXSCRICFRIIHHCRQCKHUCEDOFRQABCWKHCVXQCZRXOGCULVHCVORZOABCFDVWLQJCDCZDUPCJORZCRYHUCWKHCFLWABCVKHCORYHGCWKLVCTXLHWCWLPHCEHIRUHCWKHCZRUOGCEHFDPHCEXVABCDVCVKHCVLSSHGCKHUCFRIIHHBCVKHCZRXOGCRIWHQCZDWFKCWKHCELUGVCIOXWWHULQJCDURXQGBCVHDUFKLQJCIRUCWKHLUCEUHDNIDVWBCWKHCVRXQGCRICGLVWDQWCWUDIILFCZRXOGCJUDGXDOOACLQFUHDVHBCUHPLQGLQJCKHUCRICWKHCGDACDKHDGBCZLWKCDCQRWHERRNCLQCKDQGBCVKHCZRXOGCMRWCGRZQCKHUCWKRXJKWVCDQGCSODQVBCIHHOLQJCLQVSLUHGCEACWKHCSHDFHCRICWKHCPRUQLQJBCWKLVCVLPSOHCURXWLQHCEURXJKWCKHUCMRACDQGCFODULWABCVHWWLQJCDCSRVLWLYHCWRQHCIRUCWKHCUHVWCRICKHUCGDAB'
    crack_caesar(encrypted_msg)