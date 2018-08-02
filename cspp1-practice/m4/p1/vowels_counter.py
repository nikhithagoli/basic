"""#Assume s is a string of lower case characters."""
def main():
    inp_s = input()
    vowel_count = 0
    for i in inp_s:
        if i in 'aeiou':
            vowel_count += 1
    print(vowel_count)


if __name__ == "__main__":
    main()
