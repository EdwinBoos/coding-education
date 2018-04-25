/**
* 
* 
*
* Created by Edwin Boos ( 14.11.2017 )
* A more complexer/practical Factory pattern implementation in JavaScript (ES6) 
* ( http://jsbin.com/lomugajigi/1/edit?js,output )
*
* We have five input elements ( firstname, lastname, email, password, repeat password ), 
* which needs to get validated trough different Regex-patterns.
* 
* How can i only have one callback method for all kind of validations? 
* 
* Created a Factory pattern which takes an element in the build function.
* The factory pattern does get the id of the current element, and will return a new object of {Email} or {Name}
* {Password} based on the id of the element. If the id provided is not found it will return a new Object of {NullObjectPattern}.
* 
* Now that we get always the correct object from the builder factory, we have to call the isValid() function, to know if its valid or not.
* and can color the inputs red or green.
* 
*/
document.getElementById("emailInputId").addEventListener('input',  handleValueChanged, true);
document.getElementById("firstNameId").addEventListener('input',  handleValueChanged, true);
document.getElementById("lastNameId").addEventListener('input',  handleValueChanged, true);
document.getElementById("passwordInputId").addEventListener('input',  handleValueChanged, true);
document.getElementById("repeatPasswordInputId").addEventListener('input',  handleValueChanged, true);

const Enum = 
 {
    materialColors :
    {
       red : "#F44336",
       green : "#4CAF50",
       white : "#FFFFFF"
    },  
    inputIds : 
    {
      emailInputId : "emailInputId",
      firstNameId : "firstNameId",
      lastNameId : "lastNameId",
      passwordInputId : "passwordInputId",
      repeatPasswordInputId : "repeatPasswordInputId"
    }
};

function handleValueChanged (event)  
{
  
  if(!event.target.value) 
  {
    event.target.updateBackgroundColor( Enum.materialColors.white );
    return this;
  } 
  if(new RegExpFactory(Enum.inputIds).build(event.target).isValid()) 
  {
    event.target.updateBackgroundColor( Enum.materialColors.green );
  }
  else
  {
    event.target.updateBackgroundColor( Enum.materialColors.red ); 
  }   
  return this;
 
}

Element.prototype.updateBackgroundColor = function(color)
{
  
   this.style.backgroundColor = color;
   return this;
  
}

class RegExpFactory {

  constructor(inputIds) 
  {
    this.inputIds = inputIds;
  }

  build(element) {
    
    if(element.id === this.inputIds.emailInputId) 
    {
      return new Email(element.value);
    }
    else if(element.id === this.inputIds.firstNameId || element.id=== this.inputIds.lastNameId)
    {
       return new Name(element.value);
    }
    else if(element.id === this.inputIds.passwordInputId || element.id === this.inputIds.repeatPasswordInputId)
    
      return new Password(element.value);
    
    else return new NullObjectPattern();
    
  }
}

class Email {
  constructor(emailString) { this.emailString = emailString; }

  isValid() {
    return new RegExp(/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i).test(this.emailString)
  }
}

class Name {
  constructor(nameString) { this.nameString = nameString; }

  isValid() {
    return new RegExp(/^[a-zA-Z]+$/ ).test(this.nameString)
  }
}

class Password {
  constructor(passwordString) { this.passwordString = passwordString; }

  isValid() {
    return new RegExp(/^.*(?=.{8,120})(?!.*\s)(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\!\@\#\$\%\^\&\*\(\)\-\=\�\�\_\+\`\~\.\,\<\>\/\?\;\:\'\"\\\|\[\]\{\}]).*$/).test(this.passwordString)
  }
}

class NullObjectPattern {
  isValid() {
    return false;
  }
}
