person = {

    "name" : "Foo",
    "age" : 13,
    "is_adult" : False

}

print(person.keys())  # prints dict_keys(['name', 'age', 'is_adult'])
print(person.values())  # prints dict_values(['Foo', 13, False])
print(person.items())  # prints dict_items([('name', 'Foo'), ('age', 13), ('is_adult', False)])

# append a value
person["score"] = [30 , 30]
# remove from dictionary by key
del person["age"]

print(person);  # prints {'name': 'Foo', 'is_adult': False, 'score': [30, 30]}

# loop trough dictionary

for key in person:

    if person["is_adult"] is False:
        print(person[key])



person.clear();
print(person)  # prints {}
