Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

---

1. Encapsulation

Encapsulation is the action/idea of wrapping the variables and methods together as a one unit. Simply by making all of the fields of a class inaccessible by other classes followed by creating public methods to alter that data should suffice.
This is also known as data hiding.

The methods used in the private class are known as "getters" and "setters".
Getters retrieve and return the private data (basically reading the property) while
setters allow a class to alter the data; just not directly.

Why use encapsulation? It prevents the user from directly manipulating the code and bypassing the designed processes to fufill certain requirements.

For example, lets say you had a kitten class (_clears throat_) with a hunger level property and a feed method. Instead of using the feed method to decrease the hunger level of the kitten, the user could just directy set the hunger level to zero. Encapsulation prevents this.

---

2. Inheritance

Inheritance is exactly what it sounds like: passing resources or abilties to another similar class. Inheritance requires at least two classes. One superclass (this would be like a parent) and one subclass (this would be a child).

Using the "extends" keyword, you can give the child class access to the same functions and fields as the parent class. If necessary, the child can also "override" the function. This is when you redefine the function to either upgrade its actions or edit it to do something totally different. The cool thing is even if you do override it, it is still possible to use the parents original function by placing the "super" keyword in front of the function. Awesome isn't it?

Why use inheritance? Besides just being cool, it keeps your code dry. This pillar cuts down on repeated code, which speeds up progress.

---

3. Abstraction

Abstraction is the practice of displaying only the necessary details to the user. This helps the user experience flow smoothly. For example, there's no need for the user to know about every single part of a jet in order to fly it. They should only worry about steering, acceleration, deceleration, shooting bullets and firing rockets at enemy jets.

Two approaches to abstraction are interfaces and abstact classes.
Interfaces are implemented by other classes and let other developers by giving a blueprint to start from. From here, the developers know what the requirements are for the classes they are editing or the new classes they want to create.

Abstract classes are similar to interfaces as both cannot be instantiated but only extended or implemented. Unlike interfaces, abstract classes allow the functions they describe to be defined.

For example, one could create an Animal abstract class with the method called growl that prints out "GRRR" to the console. By extending this class, any new class would have access to this method without having to create the code for a new function. Very powerful.

---

4. Polymorphism

Polymorphism is the ability to use the one action in multiple ways. This cuts repeated code down much like inheritance and abstraction.
For example, see the code below.

class Dinosaur extends Animal{
public void makeNoise(){
System.out.println("Roar");
}
public static void main(String args[]){
Animal rex = new Dinosaur();
rex.makeNoise();
}
}
class Snake extends Animal{
public void makeNoise(){
System.out.println("Hissss");
}
public static void main(String args[]){
Animal serpent = new Snake();
serpent.sound();
}
}

Using polymorphism, we can change what happens when depending on which class is performing the action.

Why use polymorphism? It allows us to use one method and perfrom multiple actions depending on the class. This negates the need to create different methods for each class and makes using each object simpler.

---

Please write 1-3 paragraphs explaining these 4 concepts further. Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.
