def mult_matrix(m1, m2):
    '''
        check if the matrix1 columns = matrix2 rows
        mult the matrices and return the result matrix
        print an error message if the matrix shapes are not valid for mult
        and return None
        error message should be "Error: Matrix shapes invalid for mult"
    '''
    
    if len(m1[0]) == len(m2):
    	multi_matrix = [[0 for j in range(len(m2[0]))] for i in range(len(m1))]
    	for i in range(len(m1)):
    		for j in range(len(m2[0])):
    			for k in range(len(m2)):
    				multi_matrix[i][j] = multi_matrix[i][j] + (m1[i][k] * m2[k][j])
    	return multi_matrix
    else:
    	print('Error: Matrix shapes invalid for mult')
    	return None

def add_matrix(m1, m2):
    '''
        check if the matrix shapes are similar
        add the matrices and return the result matrix
        print an error message if the matrix shapes are not valid for addition
        and return None
        error message should be "Error: Matrix shapes invalid for addition"
    '''
    added_matrix = []
    if len(m1) == len(m2) and len(m1[0]) == len(m2[0]):
    	for i in range(len(m1)):
    		added_matrix.append([m1[i][j] + m2[i][j] for j in range(len(m1[0]))])
    	return added_matrix 
    else:
    	print("Error: Matrix shapes invalid for addition")
    	return None

def read_matrix(m,n):
    '''
        read the matrix dimensions from input
        create a list of lists and read the numbers into it
        in case there are not enough numbers given in the input
        print an error message and return None
        error message should be "Error: Invalid input for the matrix"
    '''
    matrix = []
    for i in range(m):
    	inp = input().split(' ')
    	if len(inp) == n :
    		matrix.append(list(map(int,inp)))
    	else:
    		print("Error: Invalid input for the matrix")
    		return None
    return matrix



def main():
    # read matrix 1
    matrix1_rows, matrix1_cols = map(int,input().split(','))
    matrix1 = read_matrix(matrix1_rows,matrix1_cols)
    if matrix1 == None:
    	exit(0)

    # read matrix 2
    matrix2_rows, matrix2_cols = map(int,input().split(','))
    matrix2 = read_matrix(matrix2_rows,matrix2_cols)
    if matrix2 == None:
    	exit(0)
    # add matrix 1 and matrix 2
    print(add_matrix(matrix1, matrix2))
    # multiply matrix 1 and matrix 2
    print(mult_matrix(matrix1,matrix2))

if __name__ == '__main__':
    main()
