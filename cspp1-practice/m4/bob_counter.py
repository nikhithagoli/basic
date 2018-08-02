'"# to find number of times bob occured in a string"'
S = input()
C = 0
for i in range(len(S)-2):
    if S[i:i+3] == 'bob':
        C += 1
print("Number if times bob occured:" + str(C))
