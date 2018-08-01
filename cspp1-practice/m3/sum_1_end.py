#end value tells upto which number we should add

print("enter end value")
end = int(input())

i = 1

s = 0

# while is a iterative structure
#is used to do same task multiple times till the condition is true

while i <= end:
#s is used to add the numbers.
	s += i
#i is incremented by 1 to get next number
	i += 1
print(s)