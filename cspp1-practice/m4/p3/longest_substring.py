'''Assume s is a string of lower case characters.

Write a program that prints the longest substring of s in which the letters occur
 in alphabetical order.
For example, if s = 'azcbobobegghakl', then your program should print

Longest substring in alphabetical order is: beggh

In the case of ties, print the first substring.
For example, if s = 'abcbcd', then your program should print

Longest substring in alphabetical order is: abc

'''
def main():
	#the input string is in s
	#remove pass and start your code here
    inp_s = input()
    sub_string = inp_s[0]
    long_sequence = ''
    for i in range(1, len(inp_s)):
        if sub_string[-1] <= inp_s[i]:
            sub_string = sub_string + inp_s[i]
        else:
            if len(sub_string) > len(long_sequence):
                long_sequence = sub_string
            sub_string = inp_s[i]
    if len(sub_string) > len(long_sequence):
        long_sequence = sub_string
    print(long_sequence)

if __name__ == "__main__":
    main()
