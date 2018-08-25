'''
Write a function to clean up a given string by removing the special characters and retain
alphabets in both upper and lower case and numbers.
'''

def clean_string(string):
	'''to remove spl characters'''
    new_string = ""
    for i in string:
        if i not in "!@#$%^&*()-_+=:;.,? ":
            new_string += i
    return new_string

def main():
    '''main function '''
    string = input()
    print(clean_string(string))

if __name__ == '__main__':
    main()
