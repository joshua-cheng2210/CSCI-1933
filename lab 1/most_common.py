def most_common_char(string):
    # Create an empty dictionary
    char_count = {}
    most_common = ""
    most_common_count = 0
    # Iterate through each character in the string and add it to the dictionary,
    # or increment its count if it already exists
    for char in string:
        if char in char_count:
            char_count[char] += 1
        else:
            char_count[char] = 1
    
    for char, count in char_count.items():
        if count > most_common_count:
            most_common_count = count
            most_common = char

    # Return the first key-value pair
    return (most_common, most_common_count)


# print(most_common_char("aaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaa"))

def palindrome(string):
    if string == "" or len(string) == 1:
        return True
    else:
        if string[0] == string[-1]:
            return palindrome(string[1: -1])
        else:
            return False

# print(palindrome("carrssssssac"))
import math
class Circle:
    def __init__(self, radius):
        self.radius = radius

    def getRadius(self):
        return self.radius

    def setRadius(self, other):
        self.radius = other

    def getArea(self):
        return math.pi * self.radius ** 2

    def getDiameter(self):
        return self.radius * 2

    def getCircumference(self):
        return math.pi * 2 * self.radius

    def __eq__(self, others):
        if self.radius == others.radius:
            return True
        else:
            return False

# x = Circle(4)
# print(x.getRadius())
# print(x.getArea())
# print(x.getDiameter())
# print(x.getCircumference())

# y = Circle(4)
# if x == y:
#     print(True)



