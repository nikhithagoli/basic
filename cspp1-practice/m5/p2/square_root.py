"'to find the square root of the given number using approximation method'"
def main():
    """using approximation method"""
    given_number = int(input())
    epsilon = 0.01
    increment = 0.0001
    guess_value = 0.0
    while abs((guess_value ** 2) - given_number) >= epsilon and guess_value <= given_number:
        guess_value += increment
    print(guess_value)
if __name__ == "__main__":
    main()
	