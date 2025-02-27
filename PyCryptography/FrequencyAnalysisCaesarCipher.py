import matplotlib.pylab as plt

ALPHABET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'


def frequency_analysis(text):
    text = text.upper()
    letters_frequencies = {}

    for letter in ALPHABET:
        letters_frequencies[letter] = 0

    for letter in text:
        if letter in ALPHABET:
            letters_frequencies[letter] += 1

    return letters_frequencies


def plot_distribution(frequencies):
    plt.bar(frequencies.keys(), frequencies.values())
    plt.show()


if __name__ == '__main__':
    message = 'Every morning, Anna would wake up early to enjoy a cup of coffee on her balcony. The sun would rise slowly, casting a warm glow over the city. She loved this quiet time before the world became busy. As she sipped her coffee, she would often watch the birds fluttering around, searching for their breakfast. The sound of distant traffic would gradually increase, reminding her of the day ahead. With a notebook in hand, she would jot down her thoughts and plans, feeling inspired by the peace of the morning. This simple routine brought her joy and clarity, setting a positive tone for the rest of her day.'
    freq = frequency_analysis(message)
    plot_distribution(freq)