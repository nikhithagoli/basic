# Exercise: PowerIter
# Write a Python function, iterPower(base, exp), that takes in two numbers and returns the base^(exp) of given base and exp.

# This function takes in two numbers and returns one number.


def iterPower(base, exp):
    '''
    base: int or float.
    exp: int >= 0
 
    returns: int or float, base^exp
    '''
    # Your code here
    if exp == 0:
    	return 1
    else:
    	return base * iterPower(base, exp-1)
    


def main():

    data = input()
    data = data.split()
    data[0] = float(data[0])
    temp = str(data[0]).split('.')
    if(temp[1] == '0'):
        print(iterPower(int(data[0]), int(data[1]))) 

    else:
        print(iterPower(data[0],int(data[1]))) 

if __name__== "__main__":
    main()