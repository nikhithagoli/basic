''' Implement CipherTextMessage Class '''
import string

# Helper code begins

### DO NOT MODIFY THIS FUNCTION ###
def load_words(file_name):
    '''
    file_name (string): the name of the file containing
    the list of words to load

    Returns: a list of valid words. Words are strings of lowercase letters.

    Depending on the size of the word list, this function may
    take a while to finish.
    '''
    # print('Loading word list from file...')
    # inFile: file
    input_file = open(file_name, 'r')
    # line: string
    line = input_file.readline()
    # word_list: list of strings
    words_list = line.split()
    # print('  ', len(word_list), 'words loaded.')
    input_file.close()
    return words_list

### DO NOT MODIFY THIS FUNCTION ###
def is_word(word_list, word):
    '''
    Determines if word is a valid word, ignoring
    capitalization and punctuation

    word_list (list): list of words in the dictionary.
    word (string): a possible word.

    Returns: True if word is in word_list, False otherwise

    Example:
    >>> is_word(word_list, 'bat') returns
    True
    >>> is_word(word_list, 'asdf') returns
    False
    '''
    word = word.lower()
    word = word.strip(" !@#$%^&*()-_+={}[]|:;'<>?,./")
    return word in word_list

### DO NOT MODIFY THIS FUNCTION ###
def get_story_string():
    """
    Returns: a joke in encrypted text.
    """
    filen = open("story.txt", "r")
    story = str(filen.read())
    filen.close()
    return story

WORDLIST_FILENAME = 'words.txt'

class Message:
    ''' Message object '''
    ### DO NOT MODIFY THIS METHOD ###
    def __init__(self, text):
        '''
        Initializes a Message object

        text (string): the message's text

        a Message object has two attributes:
            self.message_text (string, determined by input text)
            self.valid_words (list, determined using helper function load_words
        '''
        self.msg_text = text
        self.valid_words = load_words("words.txt")
        self.shift_dict = {}

    ### DO NOT MODIFY THIS METHOD ###
    def get_message_text(self):
        '''
        Used to safely access self.message_text outside of the class

        Returns: self.message_text
        '''
        return self.msg_text

    ### DO NOT MODIFY THIS METHOD ###
    def get_valid_words(self):
        '''
        Used to safely access a copy of self.valid_words outside of the class

        Returns: a COPY of self.valid_words
        '''
        return self.valid_words[:]

    ### DO NOT MODIFY THIS METHOD ###
    def build_shift_dict(self, shift):
        '''
        Creates a dictionary that can be used to apply a cipher to a letter.
        The dictionary maps every uppercase and lowercase letter to a
        character shifted down the alphabet by the input shift. The dictionary
        should have 52 keys of all the uppercase letters and all the lowercase
        letters only.

        shift (integer): the amount by which to shift every letter of the
        alphabet. 0 <= shift < 26

        Returns: a dictionary mapping a letter (string) to
                 another letter (string).
        '''
        lower_keys = list(string.ascii_lowercase)
        lower_values = list(string.ascii_lowercase)
        lower_shift_values = lower_values[shift:] + lower_values[:shift]

        upper_keys = list(string.ascii_uppercase)
        upper_values = list(string.ascii_uppercase)
        upper_shift_values = upper_values[shift:] + upper_values[:shift]

        all_keys = lower_keys + upper_keys
        all_values = lower_shift_values + upper_shift_values

        self.shift_dict = dict(zip(all_keys, all_values))
        return self.shift_dict

    ### DO NOT MODIFY THIS METHOD ###
    def apply_shift(self, shift):
        '''
        Applies the Caesar Cipher to self.message_text with the input shift.
        Creates a new string that is self.message_text shifted down the
        alphabet by some number of characters determined by the input shift

        shift (integer): the shift with which to encrypt the message.
        0 <= shift < 26

        Returns: the message text (string) in which every character is shifted
             down the alphabet by the input shift
        '''
        new_text = []
        for i in self.msg_text:
            if i not in self.build_shift_dict(shift).keys():
                new_text.append(i)
                continue
            else:
                new_text.append(self.build_shift_dict(shift)[i])
        return ''.join(new_text)

class PlaintextMessage(Message):
    ''' PlaintextMessage class '''
    ### DO NOT MODIFY THIS METHOD ###
    def __init__(self, text, shift):
        '''
        Initializes a PlaintextMessage object

        text (string): the message's text
        shift (integer): the shift associated with this message

        A PlaintextMessage object inherits from Message and has five attributes:
            self.message_text (string, determined by input text)
            self.valid_words (list, determined using helper function load_words)
            self.shift (integer, determined by input shift)
            self.encrypting_dict (dictionary, built using shift)
            self.message_text_encrypted (string, created using shift)

        Hint: consider using the parent class constructor so less
        code is repeated
        '''
        self.text = text
        self.shift = shift
        self.valid_words = load_words("words.txt")
        Message.__init__(self, text)
        self.encrypting_dict = self.build_shift_dict(shift)
        self.message_text_encrypted = self.apply_shift(shift)

    ### DO NOT MODIFY THIS METHOD ###
    def get_shift(self):
        '''
        Used to safely access self.shift outside of the class

        Returns: self.shift
        '''
        return self.shift

    ### DO NOT MODIFY THIS METHOD ###
    def get_encrypting_dict(self):
        '''
        Used to safely access a copy self.encrypting_dict outside of the class

        Returns: a COPY of self.encrypting_dict
        '''
        return self.encrypting_dict

    ### DO NOT MODIFY THIS METHOD ###
    def get_message_text_encrypted(self):
        '''
        Used to safely access self.message_text_encrypted outside of the class

        Returns: self.message_text_encrypted
        '''
        return self.message_text_encrypted

    ### DO NOT MODIFY THIS METHOD ###
    def change_shift(self, shift):
        '''
        Changes self.shift of the PlaintextMessage and updates other
        attributes determined by shift (ie. self.encrypting_dict and
        message_text_encrypted).

        shift (integer): the new shift that should be associated with this message.
        0 <= shift < 26

        Returns: nothing
        '''
        self.shift = shift
        self.encrypting_dict = self.build_shift_dict(shift)
        self.message_text_encrypted = self.apply_shift(shift)

# Helper code ends

class CiphertextMessage(Message):
    ''' CiphertextMessage class '''
    def __init__(self, text):
        '''
        Initializes a CiphertextMessage object

        text (string): the message's text

        a CiphertextMessage object has two attributes:
            self.message_text (string, determined by input text)
            self.valid_words (list, determined using helper function load_words)
        '''
        self.message_text = text
        Message.__init__(self, text)
        self.valid_words = load_words("words.txt")[:]
        self.max_count = 0
        self.decrypted_message = ()

    def decrypt_message(self):
        '''
        Decrypt self.message_text by trying every possible shift value
        and find the "best" one. We will define "best" as the shift that
        creates the maximum number of real words when we use apply_shift(shift)
        on the message text. If s is the original shift value used to encrypt
        the message, then we would expect 26 - s to be the best shift value
        for decrypting it.

        Note: if multiple shifts are  equally good such that they all create
        the maximum number of you may choose any of those shifts (and their
        corresponding decrypted messages) to return

        Returns: a tuple of the best shift value used to decrypt the message
        and the decrypted message text using that shift value
        '''
        for shift in range(27):
            message = PlaintextMessage(self.message_text, shift)
            decrypted = message.get_message_text_encrypted()
            count = 0
            for word in decrypted.split(' '):
                if is_word(self.valid_words, word):
                    count += 1
            if self.max_count < count:
                self.max_count = count
                self.decrypted_message = (26-shift, decrypted)
        return self.decrypted_message


### DO NOT MODIFY THIS METHOD ###
def main():
    ''' This method is provided to handle testcases'''
    ciphertext = CiphertextMessage(input())
    print(ciphertext.decrypt_message())

if __name__ == '__main__':
    main()