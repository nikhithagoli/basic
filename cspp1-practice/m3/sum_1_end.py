#end value tells upto which number we should add

print("enter end value")
end = int(input())

s = 0

# for is a iterative structure
#is used to do same task m times 

for i in range(1,end+1):
#s is used to add the numbers.
	s += i
#i is incremented by 1 to get next number
print(s)