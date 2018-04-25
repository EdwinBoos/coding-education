
""" 
    Created by Edwin Boos - 25.04.2018
    ListFeature does extend from the base object list.
    It has features like method chaining
    and has custom functions (like deep_flatten).

"""
class ListFeature(list) :
  
  def __init__(self) :
    super()
  
  def append(self,  value) :
    super().append(value)
    return self;

  def remove(self, value) :
    super().remove(value)
    return self;
  
  def deep_flatten(self):
  
    flatten_list = [];
    self.__flatten_next_level__(self, flatten_list);
    return flatten_list  
    
  def __flatten_next_level__(self, deep_list, flatten_list) :
      
    for value in deep_list:
  
      if(type(value) is list):
        self.__flatten_next_level__(value, flatten_list)
      else: 
        flatten_list.append(value)
    return flatten_list  
 

list_enhanced = ListFeature().append(1337).append(1).append(400).append(300).append([2,3,4,5,55, [22901, 11111, [39, 434], [29012910], [4099302392, [3,4949]]]]).remove(1337).deep_flatten();
list_enhanced.sort()
print(list_enhanced)
""" prints [1, 2, 3, 3, 4, 5, 39, 55, 300, 400, 434, 4949, 11111, 22901, 29012910, 4099302392] """





