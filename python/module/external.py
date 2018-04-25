

class Log(object) :

    result_text = ""

    """
       adds text to the result_text member variable
       and returns the current instance
    """
    def add_text(self, text):
        self.result_text = self.result_text + text;
        return self
    """ 
        prints the member variable result_text
        and returns the current instance
    """
    def write(self):
        print(self.result_text);
        return self
