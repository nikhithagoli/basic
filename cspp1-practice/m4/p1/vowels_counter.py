'"# find number of vowels in a given string" '
S = input()
C = 0
'"# counting the vowels" '
for i in S:
    if i in 'aeiou':
        C += 1
print(C)
