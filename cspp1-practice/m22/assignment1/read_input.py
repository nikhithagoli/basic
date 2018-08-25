'''
Write a python program to read multiple lines of text input and store the input into a string.
'''

def main():
    text = ""
    no_of_lines = int(input())
    for i in range(no_of_lines):
        text = text + input()
        text = text + '\n'
    print(text)
if __name__ == '__main__':
    main()
