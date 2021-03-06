'''
    Write a program to evaluate poker hands and determine the winner
    Read about poker hands here.
    https://en.wikipedia.org/wiki/List_of_poker_hands
'''

def is_straight(hand):
    '''
        How do we find out if the given hand is a straight?
        The hand has a list of cards represented as strings.
        There are multiple ways of checking if the hand is a straight.
        Do we need both the characters in the string? No.
        The first character is good enough to determine a straight
        Think of an algorithm: given the card face value how to check if it a straight
        Write the code for it and return True if it is a straight else return False
    '''
    hand_list = []
    for i in hand:
        if i[0] == 'T':
            hand_list.append(10)
        elif i[0] == 'J':
            hand_list.append(11)
        elif i[0] == 'Q':
            hand_list.append(12)
        elif i[0] == 'K':
            hand_list.append(13)
        elif i[0] == 'A':
            hand_list.append(14)
        else:
            hand_list.append(int(i[0]))
    hand_list.sort()
    for i in range(len(hand_list)-1):
        if int(hand_list[i+1]) - int(hand_list[i]) != 1:
            return False

    return True
def is_flush(hand):
    '''
        How do we find out if the given hand is a flush?
        The hand has a list of cards represented as strings.
        Do we need both the characters in the string? No.
        The second character is good enough to determine a flush
        Think of an algorithm: given the card suite how to check if it is a flush
        Write the code for it and return True if it is a flush else return False
    '''
    suit = hand[0]
    for each in hand:
        if suit[1] != each[1]:
            return False
    return True
def is_four_of_a_kind(hand):
    '''
        How do we find out if the given hand is a flush?
        The hand has a list of cards represented as strings.
        Do we need both the characters in the string? No.
        The second character is good enough to determine a flush
        Think of an algorithm: given the card suite how to check if it is a flush
        Write the code for it and return True if it is a flush else return False
    '''
    hand_list = []
    for i in hand:
        if i[0] == 'T':
            hand_list.append(10)
        elif i[0] == 'J':
            hand_list.append(11)
        elif i[0] == 'Q':
            hand_list.append(12)
        elif i[0] == 'K':
            hand_list.append(13)
        elif i[0] == 'A':
            hand_list.append(14)
        else:
            hand_list.append(int(i[0]))
    s = set(hand_list)
    for i in s:
        if hand_list.count(i) == 4:
            return True
    return False

def is_three_of_a_kind(hand):
    '''
        How do we find out if the given hand is a flush?
        The hand has a list of cards represented as strings.
        Do we need both the characters in the string? No.
        The second character is good enough to determine a flush
        Think of an algorithm: given the card suite how to check if it is a flush
        Write the code for it and return True if it is a flush else return False
    '''
    hand_list = []
    for i in hand:
        if i[0] == 'T':
            hand_list.append(10)
        elif i[0] == 'J':
            hand_list.append(11)
        elif i[0] == 'Q':
            hand_list.append(12)
        elif i[0] == 'K':
            hand_list.append(13)
        elif i[0] == 'A':
            hand_list.append(14)
        else:
            hand_list.append(int(i[0]))
    s = set(hand_list)
    for i in s:
        if hand_list.count(i) == 3:
            return True
    return False

def is_one_pair(hand):
    '''
        How do we find out if the given hand is a flush?
        The hand has a list of cards represented as strings.
        Do we need both the characters in the string? No.
        The second character is good enough to determine a flush
        Think of an algorithm: given the card suite how to check if it is a flush
        Write the code for it and return True if it is a flush else return False
    '''
    hand_list = []
    for i in hand:
        if i[0] == 'T':
            hand_list.append(10)
        elif i[0] == 'J':
            hand_list.append(11)
        elif i[0] == 'Q':
            hand_list.append(12)
        elif i[0] == 'K':
            hand_list.append(13)
        elif i[0] == 'A':
            hand_list.append(14)
        else:
            hand_list.append(int(i[0]))
    s = set(hand_list)
    for i in s:
        if hand_list.count(i) == 2:
            return True
    return False

def is_full_house(hand):
    '''
        How do we find out if the given hand is a flush?
        The hand has a list of cards represented as strings.
        Do we need both the characters in the string? No.
        The second character is good enough to determine a flush
        Think of an algorithm: given the card suite how to check if it is a flush
        Write the code for it and return True if it is a flush else return False
    '''
    hand_list = []
    for i in hand:
        if i[0] == 'T':
            hand_list.append(10)
        elif i[0] == 'J':
            hand_list.append(11)
        elif i[0] == 'Q':
            hand_list.append(12)
        elif i[0] == 'K':
            hand_list.append(13)
        elif i[0] == 'A':
            hand_list.append(14)
        else:
            hand_list.append(int(i[0]))
    s = set(hand_list)
    if len(s) == 2:
        if (hand_list.count(s[0]) == 3 and hand_list.count(s[1]) == 2) or (hand_list.count(s[0]) == 3 and hand_list.count(s[1]) == 2):
            return True
        return False

def is_two_pair(hand):
    '''
        How do we find out if the given hand is a flush?
        The hand has a list of cards represented as strings.
        Do we need both the characters in the string? No.
        The second character is good enough to determine a flush
        Think of an algorithm: given the card suite how to check if it is a flush
        Write the code for it and return True if it is a flush else return False
    '''
    hand_list = []
    for i in hand:
        if i[0] == 'T':
            hand_list.append(10)
        elif i[0] == 'J':
            hand_list.append(11)
        elif i[0] == 'Q':
            hand_list.append(12)
        elif i[0] == 'K':
            hand_list.append(13)
        elif i[0] == 'A':
            hand_list.append(14)
        else:
            hand_list.append(int(i[0]))
    s = set(hand_list)
    if len(s) == 3:
        if (hand_list.count(s[0]) == 2 and hand_list.count(s[1]) == 2 ) or (hand_list.count(s[1]) == 2 and hand_list.count(s[2]) == 2)  or (hand_list.count(s[0]) == 2 and hand_list.count(s[2]) == 2):
            return True
        return False 
def hand_rank(hand):
    '''
        You will code this function. The goal of the function is to
        return a value that max can use to identify the best hand.
        As this function is complex we will progressively develop it.
        The first version should identify if the given hand is a straight
        or a flush or a straight flush.
    '''

    # By now you should have seen the way a card is represented.
    # If you haven't then go the main or poker function and print the hands
    # Each card is coded as a 2 character string. Example Kind of Hearts is KH
    # First character for face value 2,3,4,5,6,7,8,9,T,J,Q,K,A
    # Second character for the suit S (Spade), H (Heart), D (Diamond), C (Clubs)
    # What would be the logic to determine if a hand is a straight or flush?
    # Let's not think about the logic in the hand_rank function
    # Instead break it down into two sub functions is_straight and is_flush

    # check for straight, flush and straight flush
    # best hand of these 3 would be a straight flush with the return value 3
    # the second best would be a flush with the return value 2
    # third would be a straight with the return value 1
    # any other hand would be the fourth best with the return value 0
    # max in poker function uses these return values to select the best hand
    if is_straight(hand) and is_flush(hand):
        return 3
    elif is_flush(hand):
        return 2
    elif is_straight(hand):
        return 1
    return 0

def poker(hands):
    '''
        This function is completed for you. Read it to learn the code.

        Input: List of 2 or more poker hands
               Each poker hand is represented as a list
               Print the hands to see the hand representation

        Output: Return the winning poker hand
    '''

    # the line below may be new to you
    # max function is provided by python library
    # learn how it works, in particular the key argument, from the link
    # https://www.programiz.com/python-programming/methods/built-in/max
    # hand_rank is a function passed to max
    # hand_rank takes a hand and returns its rank
    # max uses the rank returned by hand_rank and returns the best hand
    return max(hands, key=hand_rank)

if __name__ == "__main__":
    # read the number of test cases
    COUNT = int(input())
    # iterate through the test cases to set up hands list
    HANDS = []
    for x in range(COUNT):
        line = input()
        ha = line.split(" ")
        HANDS.append(ha)
    # test the poker function to see how it works
    print(' '.join(poker(HANDS)))
