"""#Guess My Number Exercise"""
def main():
    """guess secret number game"""
    guess_number = 50
    guess_count = 1
    while True:
        print("if your guess is " + str(guess_number) + "?")
        guess_ans = input("Enter 'h' to indicate the guess is too high. \
		Enter 'l' to indicate the guess is too low. Enter 'c' to indicate I guessed correctly.")
        guess_inc = (50//(2**guess_count))
        if guess_inc < 3:
            guess_inc += 1
        if guess_ans == 'l':
            guess_number = guess_number + guess_inc
        elif guess_ans == 'h':
            guess_number = guess_number + guess_inc
        elif guess_ans == 'c':
            print("your secret number is : " + str(guess_number))
            break
        else:
            print("sorry ,I did not understand your input")
        guess_count += 1

if __name__ == "__main__":
    main()
	