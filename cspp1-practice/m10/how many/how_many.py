#Exercise : how many
# write a procedure, called how_many, which returns the sum of the number of values associated with a dictionary.


def how_many(aDict):
    '''
    aDict: A dictionary, where all the values are lists.

    returns: int, how many values are in the dictionary.
    '''
    # Your Code Here
    sum = 0
    for k in aDict.keys():
    	sum += len(aDict[k])
    return sum
    

def main():
    aDict={}
    n=int(input())
    for i in range(n):
    	s=input()
    	l=s.split()
    	if l[0][0] not in aDict:
        	aDict[l[0][0]]=[l[1]]
    	else:
        	aDict[l[0][0]].append(l[1])
        
    print(how_many(aDict))


if __name__== "__main__":
    main()