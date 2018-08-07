'''# Exercise: Assignment-2
# Write a Python function, sumofdigits, that takes in one number
# and returns the sum of digits of given number.

# This function takes in one number and returns one number.'''


def sum_of_digits(num):
    '''
    n is positive Integer

    returns: a positive integer, the sum of digits of n.
    '''
    # Your code here
    if num == 0:
        return 0
    return num % 10 + sum_of_digits(num // 10)


def main():
    '''it is a main function'''
    inp_a = input()
    print(sum_of_digits(int(inp_a)))

if __name__ == "__main__":
    main()
