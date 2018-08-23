def is_won(game_matrix, no_of_turns):
    '''to check who won the game'''
    #horizontal
    if game_matrix[0][0] == game_matrix[0][1] and game_matrix[0][0] == game_matrix[0][2] and game_matrix[0][0] != ' ':
        won = game_matrix[0][0] 
    elif game_matrix[1][0] == game_matrix[1][1] and game_matrix[1][0] == game_matrix[1][2] and game_matrix[1][0] != ' ':
        won = game_matrix[1][0]
    elif game_matrix[2][0] == game_matrix[2][1] and game_matrix[2][0] == game_matrix[2][2] and game_matrix[2][0] != ' ':
        won = game_matrix[2][0]
   #Vertical
    elif game_matrix[0][0] == game_matrix[1][0] and game_matrix[0][0] == game_matrix[2][0] and game_matrix[0][0] != ' ': 
        won = game_matrix[0][0]
    elif game_matrix[0][1] == game_matrix[1][1] and game_matrix[0][1] == game_matrix[2][1] and game_matrix[0][1] != ' ':
        won = game_matrix[0][1]
    elif game_matrix[0][2] == game_matrix[1][2] and game_matrix[0][2] == game_matrix[2][2] and game_matrix[0][2] != ' ':
        won = game_matrix[0][2]
    # Diagonal
    elif game_matrix[0][0] == game_matrix[1][1] and game_matrix[0][0] == game_matrix[2][2] and game_matrix[0][0] != ' ':
        won = game_matrix[0][0]
    elif game_matrix[0][2] == game_matrix[1][1] and game_matrix[0][2] == game_matrix[2][0] and game_matrix[0][2] != ' ':
        won = game_matrix[0][2]
    # If no more slots are open, it's a tie
    elif no_of_turns == 9: 
        won = 'd'
    else:
        won = 'n'
    return won

def print_game_matrix(game_matrix):
	for i in game_matrix:
		print(i)

def play(game_matrix, player):
    print(player + ' turn')
    print('enter matrix position')
    row, col = map(int, input().split(','))
    if game_matrix[row][col] == ' ':
        game_matrix[row][col] = player
        return True
    return False

def main():
    '''main function'''
    game_matrix = multi_matrix = [[' ' for j in range(3)] for i in range(3)]
    player = 'x'
    no_of_turns = 1
    won = 'n'
    while no_of_turns < 10:
        if won == 'n':
            print("game board is:")
            print_game_matrix(game_matrix)
            if player == 'x':
                if play(game_matrix, player):
                    player = 'o'
                    no_of_turns += 1
                else:
                    print("invalid move")

            else:
                if play(game_matrix, player):
                    player = 'x'
                    no_of_turns += 1 
                else:
                    print("invalid move")
            won = is_won(game_matrix, no_of_turns)
            if won == 'x':
                print('x wins')
                print_game_matrix(game_matrix)
                break
            elif won == 'o':
                print('o  wins')
                print_game_matrix(game_matrix)
                break
            elif won == 'd':
                print('its a tie')
                print_game_matrix(game_matrix)
                break
            else:
        	    continue
if __name__ == '__main__':
    main()