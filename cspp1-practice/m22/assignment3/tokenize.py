'''
Write a function to tokenize a given string and return a dictionary with the frequency of
each word
'''
def clean_string(string):
    '''to remove spl characters'''
    new_string = ""
    for char in string:
        if char not in "!@#$%^&*()-_+=:;.,? ":
            new_string += char
    return new_string
def tokenize(string):
    tokens_dict = {}
    words_list = string.split(' ')
    for word in words_list:
        word = clean_string(word)
        if word not in tokens_dict:
            tokens_dict[i] = 1
        else:
            tokens_dict[i] += 1
    return tokens_dict  
            
def main():
    '''main function'''
    string = ""
    no_of_lines = int(input())
    for i in range(no_of_lines):
        i += 1
        string += input()
        string += '\n'
    print(tokenize(string[:-1]))
if __name__ == '__main__':
    main()
