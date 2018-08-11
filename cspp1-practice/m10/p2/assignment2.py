'''# Hangman game
#

# -----------------------------------
# Helper code
# You don't need to understand this helper code,
# but you will have to know how to use the functions
# (so be sure to read the docstrings!)'''

import random

WORDLIST_FILENAME = "words.txt"

def load_words():
    """
    Returns a list of valid words. Words are strings of lowercase letters.
    
    Depending on the size of the word list, this function may
    take a while to finish.
    """
    print("Loading word list from file...")
    # inFile: file
    inFile = open('E:\\basic\\cspp1-practice\\m10\\p2\\words.txt', 'r')
    # line: string
    line = inFile.readline()
    # wordlist: list of strings
    word_list = line.split()
    print("  ", len(word_list), "words loaded.")
    return word_list

def choose_word(word_list):
    """
    wordlist (list): list of words (strings)

    Returns a word from wordlist at random
    """
    return random.choice(word_list)

# end of helper code
# -----------------------------------

# Load the list of words into the variable wordlist
# so that it can be accessed from anywhere in the program

def is_word_guessed(secret_word, letters_guessed):
    '''
    secretWord: string, the word the user is guessing
    lettersGuessed: list, what letters have been guessed so far
    returns: boolean, True if all the letters of secretWord are in lettersGuessed;
      False otherwise
    '''
    # FILL IN YOUR CODE HERE...
    count = 0
    for i in secret_word:
        if i in letters_guessed:
            count += 1
    if count == len(secret_word):
        return True
    return False



def get_guessed_word(secret_word, letters_guessed):
    '''
    secretWord: string, the word the user is guessing
    lettersGuessed: list, what letters have been guessed so far
    returns: string, comprised of letters and underscores that represents
      what letters in secretWord have been guessed so far.
    '''
    # FILL IN YOUR CODE HERE...
    guessed_word = ''
    for i in secret_word:
        if i in letters_guessed:
            guessed_word += i
        else:
            guessed_word += '_ '
    return guessed_word


def get_available_letters(letters_guessed):
    '''
    lettersGuessed: list, what letters have been guessed so far
    returns: string, comprised of letters that represents what letters have not
      yet been guessed.
    '''
    # FILL IN YOUR CODE HERE...
    remaining = ''
    available_letters = 'abcdefghijklmnopqrstuvwxyz'
    for i in available_letters:
        if i not in letters_guessed:
            remaining += i
    return remaining
    

def hangman(secret_word):
    '''
    secretWord: string, the secret word to guess.

    Starts up an interactive game of Hangman.

    * At the start of the game, let the user know how many 
      letters the secretWord contains.

    * Ask the user to supply one guess (i.e. letter) per round.

    * The user should receive feedback immediately after each guess 
      about whether their guess appears in the computers word.

    * After each round, you should also display to the user the 
      partially guessed word so far, as well as letters that the 
      user has not yet guessed.

    Follows the other limitations detailed in the problem write-up.
    '''
    # FILL IN YOUR CODE HERE...
    print("Welcome to the game, Hangman!")
    print("I am thinking of a word that is " + str(len(secret_word)) + " letters long.")
    print("-------------")
    print(' \n')
    no_of_guesses = 8
    letters_guessed = []
    while no_of_guesses > 0 and not is_word_guessed(secret_word, letters_guessed):
        print("You have " + str(no_of_guesses) + " guesses left.")
        print("Available letters: " + get_available_letters(letters_guessed))
        input_letter = input("Please guess a letter: ")
        if input_letter in letters_guessed:
            print("Oops! You've already guessed that letter: " + get_guessed_word(secret_word, letters_guessed))
        elif input_letter in secret_word:
            letters_guessed.append(input_letter)
            print("Good guess: " + get_guessed_word(secret_word, letters_guessed))
        else:
            letters_guessed.append(input_letter)
            print("Oops! That letter is not in my word: " + get_guessed_word(secret_word, letters_guessed))
            no_of_guesses -= 1
        print("-------------")
        print("\n")

    if is_word_guessed(secret_word, letters_guessed) and no_of_guesses > 0:
        print("Congratulations, you won!")
    else:
        print("Sorry, you ran out of guesses. The word was: " + secret_word)

def main():
    '''
    Main function for the given program
    
    When you've completed your hangman function, uncomment these two lines
	and run this file to test! (hint: you might want to pick your own
	secretWord while you're testing)
	'''
    word_list = load_words()
    secret_word = choose_word(word_list).lower() 
    #secret_word = input()
    hangman(secret_word)

	

if __name__ == "__main__":
    main()
