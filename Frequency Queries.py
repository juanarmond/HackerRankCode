# You are given  queries. Each query is of the form two integers described below:
# -  : Insert x in your data structure.
# -  : Delete one occurence of y from your data structure, if present.
# -  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.

# The queries are given in the form of a 2-D array  of size  where  contains the operation, and  contains the data element. For example, you are given array . The results of each operation are:

# Operation   Array   Output
# (1,1)       [1]
# (2,2)       [1]
# (3,2)                   0
# (1,1)       [1,1]
# (1,1)       [1,1,1]
# (2,1)       [1,1]
# (3,2)                   1
# Return an array with the output: .

# Function Description

# Complete the freqQuery function in the editor below. It must return an array of integers where each element is a  if there is at least one element value with the queried number of occurrences in the current array, or 0 if there is not.

# freqQuery has the following parameter(s):

# queries: a 2-d array of integers
# Input Format

# The first line contains of an integer , the number of queries.
# Each of the next  lines contains two integers denoting the 2-d array .

# Constraints

# All 
# Output Format

# Return an integer array consisting of all the outputs of queries of type .

# Sample Input 0

# 8
# 1 5
# 1 6
# 3 2
# 1 10
# 1 10
# 1 6
# 2 5
# 3 2
# Sample Output 0

# 0
# 1
# Explanation 0

# For the first query of type , there is no integer whose frequency is  (). So answer is .
# For the second query of type , there are two integers in  whose frequency is  (integers =  and ). So, the answer is .

# Sample Input 1

# 4
# 3 4
# 2 1003
# 1 16
# 3 1
# Sample Output 1

# 0
# 1
# Explanation 1

# For the first query of type , there is no integer of frequency . The answer is . For the second query of type , there is one integer,  of frequency  so the answer is .

# Sample Input 2

# 10
# 1 3
# 2 3
# 3 2
# 1 4
# 1 5
# 1 5
# 1 4
# 3 2
# 2 4
# 3 2
# Sample Output 2

# 0
# 1
# 1
# Explanation 2

# When the first output query is run, the array is empty. We insert two 's and two 's before the second output query,  so there are two instances of elements occurring twice. We delete a  and run the same query. Now only the instances of  satisfy the query.


#!/bin/python3

import math
import os
import random
import re
import sys
from collections import Counter
from operator import itemgetter

# Complete the freqQuery function below.
# def freqQuery(queries):
#     print(queries)
#     list_arr=[]
#     ans=[]
#     for arr in queries:
#         instruction = arr[0]
#         num = arr[1]
#         if instruction == 1:
#             list_arr.append(num)
#         elif instruction == 2:
#             if num in list_arr:
#                 list_arr.remove(num)
#         else:
#             total_num = Counter(list_arr)
#             # print(num, total_num)
#             if num in total_num.values():
#                 # print(num, total_num)
#                 ans.append('1')
#             else:
#                 ans.append('0')
#     # print(ans)
#     return ''.join(ans)

def freqQuery(queries):
    # print(queries)
    dic ={}
    ans=''
    for i in range(len(queries)):
        instruction = queries[i][0]
        num = queries[i][1]
        if instruction == 1:
            if num not in dic:
                dic[num]=int(0)
            dic[num]=dic[num]+1
        elif instruction == 2:
            if num in dic:
                dic[num]=dic[num]-1
                if dic[num] < 1:
                    dic.pop(num)
        elif instruction == 3:
            if num in dic.values():
                ans+='1'
            else:
                ans+='0'    
    return ans

# Very Fast
# def freqQuery(queries):
#     dkey=defaultdict(int)
#     dcount=defaultdict(int)
#     ans=[]
#     for i in queries:
#         if i[0]==1:
#             k=dkey[i[1]]
#             if dcount[k]>0:
#                 dcount[k]-=1
#             dkey[i[1]]+=1
#             dcount[k+1]+=1
#         elif i[0]==2:
#             y=i[1]
#             if dkey[y]>0:
#                 dcount[dkey[y]]-=1
#                 dkey[y]-=1
#                 dcount[dkey[y]]+=1
#         else:
#             ans.append(0 if dcount[i[1]]==0 else 1)
#     return ans    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    queries = []

    for _ in range(q):
        queries.append(list(map(int, input().rstrip().split())))

    ans = freqQuery(queries)

    fptr.write('\n'.join(map(str, ans)))
    fptr.write('\n')

    fptr.close()



