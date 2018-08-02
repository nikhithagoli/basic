'''Assume s is a string of lower case characters.

Write a program that prints the number of times the string 'bob' occurs in s.
 For example, if s = 'azcbobobegghakl', then your program should print

Number of times bob occurs is: 2'''

def main():
	#the input string is in s
	#remove pass and start your code here
    inp_s = input()
    bob_count = 0
    for i in range(len(inp_s)-2):
        if inp_s[i:i+3] == 'bob':
            bob_count += 1
    print(str(bob_count))

if __name__ == "__main__":
    main()
