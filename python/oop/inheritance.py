class Vehicle(object) :

    wheels = 0;  # member variable which will be inherited by sub-classes.

    def log_vehicle(self):
        print(self.brand)
        print(self.wheels)
        print(self.color)


class Car(Vehicle) :

    def __init__(self, brand, color) :
        self.wheels = 4
        self.brand = brand
        self.color = color


class Motorcycle(Vehicle) :

    def __init__(self, brand, color) :
        self.wheels = 2
        self.brand = brand
        self.color = color



car = Car("Audi", "Black")
motorcycle = Motorcycle("Yamaha", "Green")


print(car.wheels)  # prints 4
print(motorcycle.wheels)  # prints 2

""" Prints: 
     Audi
     4
     Black """
car.log_vehicle()

""" Prints: 
     Yamaha
     2
     Green """
motorcycle.log_vehicle()
