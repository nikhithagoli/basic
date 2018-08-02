'"# find number of vowels in a given string" '
S = input("enter string\n")
C = 0
'"# counting the vowels" '
for i in S:
    if i in 'aeiou':
        C += 1
print("Number of vowels:", C)
