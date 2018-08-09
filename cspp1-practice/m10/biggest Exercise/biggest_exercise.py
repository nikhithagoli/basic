#Exercise : Biggest Exercise
#Write a procedure, called biggest, which returns the key corresponding to the entry with the largest number of values associated with it. If there is more than one such entry, return any one of the matching keys.


def biggest(aDict):
    '''
    aDict: A dictionary, where all the values are lists.

    returns: The key with the largest number of values associated with it
    '''
    # Your Code Here
    maximum = 0
    for k,v in aDict.items():
        if len(v) > maximum:
            maximum = len(v)
            biggest = k
    return biggest

    

def main():
    aDict={}
    n=int(input())
    for i in range(n):
        s=input()
        l=s.split()
        if l[0] not in aDict:
            aDict[l[0]]=[l[1]]
        else:
            aDict[l[0]].append(l[1])
        
    print(biggest(aDict))


if __name__== "__main__":
    main()