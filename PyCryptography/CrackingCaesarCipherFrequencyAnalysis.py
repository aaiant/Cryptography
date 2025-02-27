import matplotlib.pylab as plt

ALPHABET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'


def frequency_analysis(text):
    text = text.upper()
    letter_frequency = {}

    for letter in ALPHABET:
        letter_frequency[letter] = 0

    for letter in text:
        if letter in ALPHABET:
            letter_frequency[letter] += 1

    return letter_frequency


def plot_distribution(frequencies):
    plt.bar(frequencies.keys(), frequencies.values())
    plt.show()


def crack_caesar(text):
    freq = frequency_analysis(text)
    freq = sorted(freq.items(), key=lambda x: x[1], reverse=True)
    possible_keys = []
    for i in range(min(3, len(freq))):
        key = (ALPHABET.find(freq[i][0]) - ALPHABET.find('E')) % 26
        possible_keys.append(key)
    print('Possible key values: ', possible_keys)


if __name__ == '__main__':
    cipher_text = 'HYHUACPRUQLQJ,CDQQDCZRXOGCZDNHCXSCHDUOACWRCHQMRACDCFXSCRICFRIIHHCRQCKHUCEDOFRQA.CWKHCVXQCZRXOGCULVHCVORZOA,CFDVWLQJCDCZDUPCJORZCRYHUCWKHCFLWA.CVKHCORYHGCWKLVCTXLHWCWLPHCEHIRUHCWKHCZRUOGCEHFDPHCEXVA.CDVCVKHCVLSSHGCKHUCFRIIHH,CVKHCZRXOGCRIWHQCZDWFKCWKHCELUGVCIOXWWHULQJCDURXQG,CVHDUFKLQJCIRUCWKHLUCEUHDNIDVW.CWKHCVRXQGCRICGLVWDQWCWUDIILFCZRXOGCJUDGXDOOACLQFUHDVH,CUHPLQGLQJCKHUCRICWKHCGDACDKHDG.CZLWKCDCQRWHERRNCLQCKDQG,CVKHCZRXOGCMRWCGRZQCKHUCWKRXJKWVCDQGCSODQV,CIHHOLQJCLQVSLUHGCEACWKHCSHDFHCRICWKHCPRUQLQJ.CWKLVCVLPSOHCURXWLQHCEURXJKWCKHUCMRACDQGCFODULWA,CVHWWLQJCDCSRVLWLYHCWRQHCIRUCWKHCUHVWCRICKHUCGDA.'
    crack_caesar(cipher_text)
