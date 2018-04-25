

# Tuple is very close to an list, but the tuple is not mutable (immutable).


immutableTuple = ("immutableString", 3, 2);
immutableTuple.append(4)


# immutableTuple[0] = "xd" - will raise an error


for x in immutableTuple:
  print(x); 
