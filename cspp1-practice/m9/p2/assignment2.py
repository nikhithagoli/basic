'''
Exercise: Assignment-2
Next, implement the function getGuessedWord that takes in two parameters
a string, secret_word, and a list of letters, letters_guessed. This function
returns a string that is comprised of letters and underscores, based on what
letters in letters_guessed are in secret_word. This shouldn't be too different from isWordGuessed!
'''
def get_guessed_word(secret_word, letters_guessed):
    '''
    secret_word: string, the word the user is guessing
    letters_guessed: list, what letters have been guessed so far
    returns: string, comprised of letters and underscores that represents
      what letters in secret_word have been guessed so far.
    # FILL IN YOUR CODE HERE...

    length = len(secret_word)
    guessed_word = '_ ' * length
    for i in letters_guessed:
        indices = []
        for j, char in enumerate(secret_word):
            if char == i:
                indices.append(j)
        if indices != []:
            guessed_word_list = list(guessed_word)
            for k in indices:
                guessed_word_list[k*2] = i
            guessed_word = "".join(guessed_word_list)
    return "".join(guessed_word.split(" "))
    '''
    guessed_word = ''
    for i in secret_word:
        if i in letters_guessed:
            guessed_word += i
        else:
            guessed_word += '_ '
    return guessed_word

def main():
    '''
    Main function for current assignment
    '''
    user_input = input()
    if user_input:
        data = user_input.split()
        secret_word = data[0]
    else:
        data = []
        secret_word = ""
    list1 = []
    for j in range(1, len(data)):
        list1.append(data[j][0])
    print(get_guessed_word(secret_word, list1))

if __name__ == "__main__":
    main()
