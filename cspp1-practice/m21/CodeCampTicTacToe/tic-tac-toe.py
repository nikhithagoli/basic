def is_full(game_matrix):
    for i in game_matrix:
        if '.' in i:
            return False
    return True
def is_won(game_matrix):
    '''to check who won the game'''
    #horizontal
    won = [] 
    x_count, o_count =(0,0)
    for i in game_matrix:
        x_count += i.count('x')
        o_count += i.count('o')
    if x_count > 5 or o_count > 5:
        return "invalid game"   
    elif game_matrix[0][0] == game_matrix[0][1] and game_matrix[0][0] == game_matrix[0][2] and game_matrix[0][0] != '.':
        won.append(game_matrix[0][0]) 
    elif game_matrix[1][0] == game_matrix[1][1] and game_matrix[1][0] == game_matrix[1][2] and game_matrix[1][0] != '.':
        won.append(game_matrix[1][0])
    elif game_matrix[2][0] == game_matrix[2][1] and game_matrix[2][0] == game_matrix[2][2] and game_matrix[2][0] != '.':
        won.append(game_matrix[2][0])
   #Vertical
    elif game_matrix[0][0] == game_matrix[1][0] and game_matrix[0][0] == game_matrix[2][0] and game_matrix[0][0] != '.': 
        won.append(game_matrix[0][0])
    elif game_matrix[0][1] == game_matrix[1][1] and game_matrix[0][1] == game_matrix[2][1] and game_matrix[0][1] != '.':
        won.append(game_matrix[0][1])
    elif game_matrix[0][2] == game_matrix[1][2] and game_matrix[0][2] == game_matrix[2][2] and game_matrix[0][2] != '.':
        won.append(game_matrix[0][2])
    # Diagonal
    elif game_matrix[0][0] == game_matrix[1][1] and game_matrix[0][0] == game_matrix[2][2] and game_matrix[0][0] != '.':
        won.append(game_matrix[0][0])
    elif game_matrix[0][2] == game_matrix[1][1] and game_matrix[0][2] == game_matrix[2][0] and game_matrix[0][2] != '.':
        won.append(game_matrix[0][2])
    # If no more slots are open, it's a tie
    else:
        if len(won) > 1:
            return "invalid game"
        elif len(won) == 1:
            return won[0]
        else:
            if is_full(game_matrix):
                return 'draw'
def main():
    '''main function'''
    game_matrix = []
    for i in range(3):
        i += 1
        game_matrix.append(input().split(' '))
    print(is_won(game_matrix))

if __name__ == '__main__':
    main()