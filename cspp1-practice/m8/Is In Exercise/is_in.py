# Exercise: Is In
# Write a Python function, isIn(char, aStr), that takes in two arguments a character and String and returns the isIn(char, aStr) which retuns a boolean value.

# This function takes in two arguments character and String and returns one boolean value.

def isIn(char, aStr):
    '''
    char: a single character
    aStr: an alphabetized string
    
    returns: True if char is in aStr; False otherwise
    '''
    # Your code here
    m = len(aStr) // 2
    if m == 0:
        return False
    elif aStr[m] == char:
        return True
    else:
        if aStr[m] > char:
            return isIn(char, aStr[:m])
        else:
            return isIn(char, aStr[m:])


def main():
    data = input()
    data = data.split()
    print(isIn((data[0][0]), data[1]))


if __name__== "__main__":
    main()
