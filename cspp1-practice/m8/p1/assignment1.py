'''# Exercise: Assignment-1
# Write a Python function, factorial(n), that takes in one number\
# and returns the factorial of given number.

# This function takes in one number and returns one number.'''


def factorial(num):
    '''
    n is positive Integer

    returns: a positive integer, the factorial of n.
    '''
    # Your code here
    if num in (0, 1):
        return 1
    return num * factorial(num-1)
def main():
    '''
    it is a main function
    '''
    inp_a = input()
    print(factorial(int(inp_a)))
if __name__ == "__main__":
    main()
