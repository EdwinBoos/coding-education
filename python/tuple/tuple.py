

# Tuple is very close to an list, but the tuple is not mutable (immutable).
# Hence it does not have methods like append, sort, remove etc.

immutableTuple = ("immutableString", 3, 2);


# immutableTuple[0] = "xd" - will raise an error


for x in immutableTuple:
  print(x); 
