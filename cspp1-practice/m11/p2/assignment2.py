'''#Exercise: Assignment-2
#Implement the updateHand function. Make sure this function has no side effects:
#i.e., it must not mutate the hand passed in. Before pasting your function
#definition here, be sure you've passed the appropriate tests in test_ps4a.py.'''
def update_hand(hand, word):
    """
    Assumes that 'hand' has all the letters in word.
    In other words, this assumes that however many times
    a letter appears in 'word', 'hand' has at least as
    many of that letter in it.
    Updates the hand: uses up the letters in the given word
    and returns the new hand, without those letters in it.

    Has no side effects: does not modify hand.

    word: string
    hand: dictionary (string -> int)
    returns: dictionary (string -> int)
    """
    # TO DO ... <-- Remove this comment when you code this function

    for char in word:
        if char in hand:
            hand[char] -= 1
    return hand

def main():
    '''main function'''
    num = int(input())
    adict = {}
    i = 1
    while i <= num:
        data = input()
        list1 = data.split()
        adict[list1[0]] = int(list1[1])
        i += 1
    data1 = input()
    print(update_hand(adict, data1))


if __name__ == "__main__":
    main()
