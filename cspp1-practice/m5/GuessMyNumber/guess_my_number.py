#Guess My Number Exercise

def main():
    n = 50
    c = 1
    while True:
        print("if your guess is " + str(n) + "? " )
        s=input("Enter 'h' to indicate the guess is too high. Enter 'l' to indicate the guess is too low. Enter 'c' to indicate I guessed correctly.")
        k = (50//(2**c))
        if k < 3:
            k += 1
        if s == 'l':
            n = n + k
        elif s == 'h':
            n = n - k
        elif s == 'c':
            print("your secret number is : " + str(n))
            break
        else:
            print("sorry ,I did not understand your input")
        c += 1

if __name__== "__main__":
	main()