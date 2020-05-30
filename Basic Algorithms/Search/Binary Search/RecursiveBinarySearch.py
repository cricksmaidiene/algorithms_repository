import random
import argparse
from tqdm import tqdm
import math

RANDOM_LOWER_BOUND = -1000000
RANDOM_UPPER_BOUND =  1000000

parser = argparse.ArgumentParser(description = 'Modify Initialization of Search')
parser.add_argument('-r', '--random', help = "Adds Random Values to List from Range +/- 10^6", action='store_true')
parser.add_argument('-k','--key', help = "Adds Random Key For Search from Range +/- 10^6", action='store_true')
parser.add_argument('-s','--size', help = "Add Custom List Size From Console")
args = parser.parse_args()

def get_size_of_array():
    return int(input('Enter the Size of the Array: '))

def input_array_elements(size, arr):
    if not size:
        return arr

    print("Enter Array Elements")
    for i in range(size):
        arr.append(int(input()))
    return arr    

def input_random_array_elements(size, arr):
    print("Populating List with Random Values:")
    for i in tqdm(range(size)):
        arr.append(random.randint(RANDOM_LOWER_BOUND,RANDOM_UPPER_BOUND))
    return arr    

def get_search_key():
    return int(input('Enter the Key To be Searched: '))

def get_random_search_key():
    return random.randint(RANDOM_LOWER_BOUND,RANDOM_UPPER_BOUND)

def recursive_binary_search(size, arr, key):
    if size == 0:
        return False

    lower_index = 0
    upper_index = size - 1
    mid_index = int(((lower_index + upper_index) / 2))
    mid_value = arr[mid_index]

    if mid_value == key: return True
    elif key < mid_value: return recursive_binary_search(len(arr[0:mid_index]), arr[0:mid_index], key)
    elif key > mid_value: return recursive_binary_search(len(arr[mid_index+1:size]), arr[mid_index+1:size], key)

if __name__ == "__main__":
    arr = list()
    n = int(args.size) if args.size else get_size_of_array()
    arr = input_random_array_elements(n,arr) if args.random else input_array_elements(n,arr)
    print("Sorting List") if len(arr) != 0 else exit()
    arr.sort()
    key = get_random_search_key() if args.key else get_search_key()
    print(f"Searching for {key}")
    print(f"{key} was Found") if recursive_binary_search(n, arr, key) else print(f"{key} was NOT found")