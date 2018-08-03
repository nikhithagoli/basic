'"find if the given number is a perfect cube or not using guess and check algorithm"'
def main():
    """ guess and check method"""
    cube_value = int(input())
    guess_value = 0
    while (guess_value ** 3) != cube_value and guess_value <= cube_value:
        guess_value += 1
    if guess_value >= cube_value and (guess_value ** 3) != cube_value:
        print(str(cube_value) + " is not a perfect cube")
    if (guess_value ** 3) == cube_value:
        print(str(cube_value) + " is a perfect cube")
if __name__ == "__main__":
    main()
