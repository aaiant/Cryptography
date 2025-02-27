ALPHABET = ' ABCDEFGHIJKLMNOPQRSTUVWXYZ'
DATA_SET = []


def data():
    english_words = open('data.txt', 'r')

    for word in english_words.read().split('\n'):
        DATA_SET.append(word)

    english_words.close()


def count_words(text):
    text = text.upper()
    words = text.split(' ')
    matches = 0
    for word in words:
        if word in DATA_SET:
            matches += 1
    return matches


def check_text(text):
    matches = count_words(text)
    return (float(matches) / len(text.split(' '))) * 100 >= 65


if __name__ == '__main__':
    data()
    english_text = 'In the heart of the city, there is a small park where people come to relax and enjoy nature. The sound of birds singing fills the air, and children can be seen playing on the swings. It\'s a peaceful oasis in the midst of urban life.'
    italian_text = 'Nel cuore della città c\'è un piccolo parco dove le persone vengono a rilassarsi e godere della natura. Il suono degli uccelli che cantano riempie l\'aria, e si possono vedere dei bambini che giocano sulle altalene. È un\'oasi di pace in mezzo alla vita urbana.'
    print(check_text(english_text))
    print(check_text(italian_text))