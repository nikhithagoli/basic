'''
    Document Distance - A detailed description is given in the PDF
'''
import math
file = 'stopwords.txt'
def similarity(dict1, dict2):
    '''
        Compute the document distance as given in the PDF
    '''

    dict1_list = dict1.split(' ')
    dict2_list = dict2.split(' ')
    list1 = dict1_list + dict2_list
    count_dict = {}
    for each in list1:
        if each not in load_stopwords(file).keys():
            if each not in "!@#$%^&*()_+?":
                count_dict[each] = (count_dict.count(each), count_dict.count(each))
    numerator = 0
    sum_of_dict1 = 0
    sum_of_dict2 = 0
    for each in count_dict:
        numerator += count_dict[each][0] * count_dict[each][1]
        sum_of_dict1 += count_dict[each][0] ** 2
        sum_of_dict2 += count_dict[each][1] ** 2
    return numerator//(math.sqrt(sum_of_dict1)*math.sqrt(sum_of_dict2))


def load_stopwords(filename):
    '''
        loads stop words from a file and returns a dictionary
    '''
    stopwords = {}
    with open(filename, 'r') as filename:
        for line in filename:
            stopwords[line.strip()] = 0
    return stopwords

def main():
    '''
        take two inputs and call the similarity function
    '''
    input1 = input().lower()
    input2 = input().lower()

    print(similarity(input1, input2))

if __name__ == '__main__':
    main()
