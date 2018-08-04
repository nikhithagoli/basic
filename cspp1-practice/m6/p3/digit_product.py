'''
Given a  number int_input, find the product of all the digits example: 	input: 123 output: 6
'''
def main():
    '''
    Read any number from the input, store it in variable int_input.
    '''
    int_input = int(input())
	if int_input == 0:
        print("0")
    elif int_input < 0:
        int_input = -int_input
        digit_product = 1
        while int_input != 0:
            digit = int_input % 10
            digit_product = digit_product * digit
            int_input = int_input // 10
        print(digit_product)
    else:
        int_input = -int_input
        digit_product = 1
        while int_input != 0:
            digit = int_input % 10
            digit_product = digit_product * digit
            int_input = int_input // 10
        print(digit_product)


if __name__ == "__main__":
    main()
