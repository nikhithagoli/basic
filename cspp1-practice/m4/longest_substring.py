'"#to find largest alphabetical sequence in a string"'
S = input()
SB = S[0]
L = ''
for i in range(1, len(S)):
    if SB[-1] <= S[i]:
        SB = SB + S[i]
    else:
        if len(SB) > len(L):
            L = SB
        SB = S[i]
if len(SB) > len(L):
    L = SB
print(L)
    