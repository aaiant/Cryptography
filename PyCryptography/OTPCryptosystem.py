from random import randint
import matplotlib.pylab as plt


ALPHABET = ' ABCDEFGHIJKLMNOPQRSTUVWXYZ'


def encryption(text, key):
    text = text.upper()
    cipher_text = ''

    for index, character in enumerate(text):
        key_index = key[index]
        char_index = ALPHABET.find(character)
        cipher_text += ALPHABET[(char_index + key_index) % len(ALPHABET)]

    return cipher_text



def decryption(cipher_text, key):
    plain_text = ''

    for index, character in enumerate(cipher_text):
        key_index = key[index]
        char_index = ALPHABET.find(character)
        plain_text += ALPHABET[(char_index - key_index) % len(ALPHABET)]

    return plain_text


def random_sequence(text):
    random = []
    for _ in range(len(text)):
        random.append(randint(0, len(ALPHABET) - 1))

    return random

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
    message = """The small town of Riverside sits peacefully along the banks of the Crystal River. Every morning, as the sun rises over the eastern hills, the town comes to life in a predictable yet comforting routine. The local bakery, run by the Thompson family for three generations, fills the air with the aroma of fresh bread and cinnamon rolls. Mrs. Thompson, now in her sixties, still arrives at four in the morning to start the day's baking, just as her mother taught her.
Across the street, the hardware store opens its doors promptly at seven. Mr. Anderson, the owner, arranges his window display with seasonal items - garden tools in spring, fans in summer, rakes in autumn, and snow shovels in winter. His cat, Oscar, can often be seen lounging in the sunny window, occasionally batting at the price tags that dangle within reach.
The elementary school, a red brick building dating back to 1925, stands at the top of Oak Street. Every weekday, children gather in the playground before the morning bell, their backpacks filled with books and lunch boxes. Miss Peters, who teaches third grade, has worked there for twenty-five years and knows every family in town by name.
At the center of town, the park serves as a gathering place for everyone. Its well-maintained paths wind through flower gardens and around a small pond where ducks make their home. On weekends, the farmers' market fills the western edge of the park with local produce, handmade crafts, and friendly conversation. The Marshall family's vegetable stand always has the longest line, especially when their famous tomatoes are in season.
The public library, though small, houses an impressive collection of books. The head librarian, Dr. James, takes pride in knowing exactly where every book belongs and can recommend the perfect story for any reader who walks through the doors. The children's section, with its colorful beanbag chairs and weekend story times, is always filled with young readers discovering new adventures.
In the evenings, the diner on Main Street becomes the social hub of Riverside. Sarah's Place, named after the current owner's grandmother, serves the best apple pie in three counties. The regulars each have their favorite booth, and newcomers quickly learn that the Tuesday special of meatloaf and mashed potatoes shouldn't be missed.
The fire station, staffed by both professional firefighters and volunteers, stands ready at all hours. Chief Rodriguez has organized monthly community safety workshops, teaching everything from basic first aid to fire prevention. The station's vintage 1952 fire truck, lovingly restored by the crew, appears in every town parade.
As night falls, the streetlights along River Walk illuminate the path beside the Crystal River. Couples take evening strolls, teens gather at the ice cream shop, and the occasional fisherman tries their luck in the peaceful waters. The town clock, perched atop the old courthouse, chimes every hour, its familiar sound echoing through the quiet streets.
The community center hosts various activities throughout the week - yoga classes on Monday mornings, senior bingo on Wednesday afternoons, and teen movie nights on Fridays. The bulletin board in the lobby is always covered with notices for upcoming events, lost pets, and local business advertisements.
On the outskirts of town, family farms stretch toward the horizon. The Williams dairy farm, the Peterson apple orchard, and the Green family's corn fields have been local landmarks for generations. Each season brings its own rhythm to these farms, from spring planting to fall harvest, maintaining the agricultural heritage that has long been part of Riverside's identity.
The changing seasons bring their own traditions to Riverside. Spring sees the annual Easter egg hunt in the park, summer brings the Fourth of July parade down Main Street, fall heralds the harvest festival with its pumpkin-carving contest, and winter transforms the town square into a holiday wonderland complete with an ice skating rink.
Year after year, Riverside maintains its small-town charm while gradually adapting to modern times. The internet cafe next to the bookstore, the solar panels on the school roof, and the electric vehicle charging stations behind the town hall show that even traditional communities can embrace change while preserving their essential character."""
    seq = random_sequence(message)
    print('Original message; %s' % message.upper())

    cipher_msg = encryption(message, seq)
    print('Encrypted message: %s' % cipher_msg)

    plot_distribution(frequency_analysis(cipher_msg))

    decrypted_msg = decryption(cipher_msg, seq)
    print('Decrypted message: %s' % decrypted_msg)