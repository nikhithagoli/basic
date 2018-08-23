'''matrix operations'''
def mult_matrix(matrix1, matrix2):
    '''
        check if the matrix1 columns = matrix2 rows
        mult the matrices and return the result matrix
        print an error message if the matrix shapes are not valid for mult
        and return None
        error message should be "Error: Matrix shapes invalid for mult"
    '''

    if len(matrix1[0]) == len(matrix2):
        multi_matrix = [[0 for j in range(len(matrix2[0]))] for i in range(len(matrix1))]
        for i in enumerate(matrix1):
            for j in enumerate(matrix2[0]):
                for k in enumerate(matrix2):
                    multi_matrix[i[0]][j[0]] = multi_matrix[i[0]][j[0]] + (matrix1[i[0]][k[0]] * matrix2[k[0]][j[0]])
        return multi_matrix
    print('Error: Matrix shapes invalid for mult')
    return None

def add_matrix(matrix1, matrix2):
    '''
        check if the matrix shapes are similar
        add the matrices and return the result matrix
        print an error message if the matrix shapes are not valid for addition
        and return None
        error message should be "Error: Matrix shapes invalid for addition"
    '''
    added_matrix = []
    if len(matrix1) == len(matrix2) and len(matrix1[0]) == len(matrix2[0]):
        for i in range(len(matrix1)):
            added_matrix.append([matrix1[i][j] + matrix2[i][j] for j in range(len(matrix1[0]))])
        return added_matrix
    print("Error: Matrix shapes invalid for addition")
    return None

def read_matrix(rows, cols):
    '''
        read the matrix dimensions from input
        create a list of lists and read the numbers into it
        in case there are not enough numbers given in the input
        print an error message and return None
        error message should be "Error: Invalid input for the matrix"
    '''
    matrix = []
    for i in range(rows):
        i += 1
        inp = input().split(' ')
        if len(inp) == cols:
            matrix.append(list(map(int, inp)))
        else:
            print("Error: Invalid input for the matrix")
            return None
    return matrix



def main():
    '''main function'''
    # read matrix 1
    matrix1_rows, matrix1_cols = map(int, input().split(','))
    matrix1 = read_matrix(matrix1_rows, matrix1_cols)
    #print(matrix1)
    if matrix1 is None:
        exit(0)

    # read matrix 2
    matrix2_rows, matrix2_cols = map(int, input().split(','))
    matrix2 = read_matrix(matrix2_rows, matrix2_cols)
    #print(matrix2)
    if matrix2 is None:
        exit(0)
    # add matrix 1 and matrix 2
    print(add_matrix(matrix1, matrix2))
    # multiply matrix 1 and matrix 2
    print(mult_matrix(matrix1, matrix2))

if __name__ == '__main__':
    main()
