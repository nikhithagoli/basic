'"find the square root of the given number using Bi-section method "'

def main():
    square = int(input())
    epsilon = 0.01
    low = 1.0
    high = square
    guess = (high + low)/2.0
    while guess ** 2 - square >= epsilon:
        if guess ** 2 <= square:
            low = guess
        else:
            high = guess
        guess = (low + high) / 2.0
    print(guess)
if __name__ == "__main__":
    main()
	