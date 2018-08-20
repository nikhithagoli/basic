'''
    Document Distance - A detailed description is given in the PDF'''
import re
import math
FILE = "stopwords.txt"
def clean_words(input1):
    ''' cleaning function'''
    reg = re.compile('[^a-z]')
    input1 = [reg.sub('', w.strip())for w in input1.lower().split(' ')]
    return input1

def remove_words(input1, input2):
    '''removing words'''
    full_list = clean_words(input1) + clean_words(input2)
    dic = {}
    for word in full_list:
        if word not in load_stopwords(FILE).keys() and len(word) > 0:
            dic[word] = (clean_words(input1).count(word), clean_words(input2).count(word))
    return dic

def similarity(dict1, dict2):
    '''
        Compute the document distance as given in the PDF
    '''
    count_dict = {}
    count_dict = remove_words(dict1, dict2)
    numerator = 0
    denomenator = 0
    sum0 = 0
    sum1 = 0
    for count_dict in count_dict.values():
        numerator = numerator + (count_dict[0]*count_dict[1])
        sum0 = sum0 + (count_dict[0]**2)
        sum1 = sum1 + (count_dict[1]**2)
    denomenator = math.sqrt(sum0) * math.sqrt(sum1)
    return numerator/denomenator


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
        take two inputs and call the similarity functions
    '''
    input1 = input()
    input2 = input()

    print(similarity(input1, input2))

if __name__ == '__main__':
    main()
