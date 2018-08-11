# Assignment-3
'''
At this point, we have written code to generate a random hand and display that hand to the user.
We can also ask the user for a word (Python's input) and score the word (using your getWordScore).
However, at this point we have not written any code to verify that a word given by a player
obeys the rules of the game. A valid word is in the word list; and it is composed entirely
of letters from the current hand. Implement the isValidWord function.

Testing: Make sure the test_isValidWord tests pass. In addition, you will want to test your
implementation by calling it multiple times on the same hand - what should the correct behavior be?
Additionally, the empty string ('') is not a valid word - if you code this function correctly,
you shouldn't need an additional check for this condition.

Fill in the code for isValidWord in ps4a.py and be sure you've passed the appropriate tests in
test_ps4a.py before pasting your function definition here.
'''

def is_valid_word(word, hand, word_list):
    """
    Returns True if word is in the wordList and is entirely
    composed of letters in the hand. Otherwise, returns False.
    Does not mutate hand or wordList.

    word: string
    hand: dictionary (string -> int)
    wordList: list of lowercase strings
    """
    # TO DO ... <-- Remove this comment when you code this function
    count = 0
    if word in word_list:
        for i in set(word):
            if i in hand and list(word).count(i) <= hand[i]:
                count += 1
    if count == len(set(word)):
        return True
    return False



def main():
    '''main function'''
    word = input()
    num = int(input())
    adict = {}
    i = 0
    while i < num:
        data = input()
        list1 = data.split()
        adict[list1[0]] = int(list1[1])
        i += 1
    list2 = input().split()
    print(is_valid_word(word, adict, list2))



if __name__ == "__main__":
    main()
