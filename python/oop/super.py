class Employee(object):

    def __init__(self, employee_name):
        self.employee_name = employee_name

    def calculate_wage(self, hours):
        self.hours = hours
        return hours * 20.00


class PartTimeEmployee(Employee):

    def calculate_wage(self, hours):
        self.hours = hours;
        return hours * 12.00

    def full_time_wage(self, hours):
        return super().calculate_wage(hours);


milton = PartTimeEmployee("Foo")
print(milton.full_time_wage(10))  # prints 200.0
