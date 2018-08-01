#we have to print even number below n

print("enter value n")

#as input function returns string by default we should cast it to integer

n=int(input())

# i indicates the starting value

i=2

# while is a iterative structure
#is used to do same task multiple times till the condition is true

while i<=n:
	print(i)
	
# to print the next even number we are incrementing i value by 2

	i+=2
	