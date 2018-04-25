deep_list = [1, 2, 4, 5, 6, True, {"key": [2, 3, 4, 5, 6, 7]}];

# deep copy
deep_list_copy = deep_list[::1];
# deep copy reversed
deep_list_copy_reverse = deep_list[::-1];
# deep copy every second value start by index 0, to length of the list and every second value of deep_list
deep_list_copy_every_second_value = deep_list[0::2]

print(deep_list_copy)  # prints [1, 2, 4, 5, 6, 7, {'key': [2, 3, 4, 5, 6, 7]}]
print(deep_list_copy_reverse)  # prints [{'key': [2, 3, 4, 5, 6, 7]}, 7, 6, 5, 4, 2, 1]
print(deep_list_copy_every_second_value);  # prints [1, 4, 6, {'key': [2, 3, 4, 5, 6, 7]}]
# list initializing with range
list_by_range = [x for x in range(0, 20)]
print(list_by_range)  # prints [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]

list_by_range_with_condition = [x for x in range(0, 20) if (x % 2) == 0]
print(list_by_range_with_condition)  # prints [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]

# filter list with lambda function do exclude True values
filtered_deep_list = list(filter(lambda next_item: next_item is not True, deep_list));
print(filtered_deep_list)  # prints [1, 2, 4, 5, 6, {'key': [2, 3, 4, 5, 6, 7]}]

deep_list.append("some value")  # append to list
deep_list.remove(2);  # remove by index
print(deep_list[2])  # access by index

# for loop over a list
for item in deep_list:
    print(item);

list_2D = [[1, 2, 3], [4, 5, 6, 7, 8, 9]]


def flatten(lists):
    results = []
    for next_list in lists:
        results = results + next_list;

    return results;


print(flatten(list_2D))  # prints [1, 2, 3, 4, 5, 6, 7, 8, 9]
