'''tic_tac_toe'''
def is_full(game_matrix):
    '''to check game matrix have empty places or not'''
    for i in game_matrix:
        if '.' in i:
            return False
    return True
def is_won(game_matrix):
    '''to check who won the game'''
    won = []
    x_count, o_count = (0, 0)
    for i in game_matrix:
        x_count += i.count('x')
        o_count += i.count('o')
    if x_count > 5 or o_count > 5:
        return "invalid game"
    #horizontal
    for row in game_matrix:
        if row[0] == row[1] == row[2]:
            won.append(row[0])
   #Vertical
    for i in range(3):
        if game_matrix[0][i] == game_matrix[1][i] == game_matrix[2][i]:
            won.append(game_matrix[0][i])
    # Diagonal
    if game_matrix[0][0] == game_matrix[1][1] == game_matrix[2][2] and game_matrix[0][0] != '.':
        won.append(game_matrix[0][0])
    if game_matrix[0][2] == game_matrix[1][1] == game_matrix[2][0] and game_matrix[0][2] != '.':
        won.append(game_matrix[0][2])
    # If no more slots are open, it's a tie
    if len(won) > 1:
        return "invalid game"
    if len(won) == 1:
        return won[0]
    if is_full(game_matrix):
        return 'draw'
def main():
    '''main function'''
    game_matrix = []
    for i in range(3):
        i += 1
        inp = input().split(' ')
        for char in inp:
            if char not in "xo.":
                print("invalid input")
                exit(0)
        game_matrix.append(inp)
    print(is_won(game_matrix))

if __name__ == '__main__':
    main()
