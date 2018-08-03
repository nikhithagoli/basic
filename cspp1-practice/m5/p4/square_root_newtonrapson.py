'"find the square root of the number using Newton-Rapson method"'
def main():
	"""newton-rapson method"""
    square = int(input())
    epsilon = 0.01
    guess_value = square/2.0
    while abs(guess_value * guess_value - square) >= epsilon:
        guess_value = guess_value - (((guess_value**2) - square)/(2 * guess_value))
    print(guess_value)
if __name__ == "__main__":
    main()
	