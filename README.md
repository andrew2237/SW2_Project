# SW2-Project
Make a **Clean Code** for an old version of our code in any previous project through the faculty years
By following the **SOLID Principle**:
-------------------------------------
  * S : **Single Responsibility Principle** (SRP) [Solves one problem - Single reason to change]
        To make every method only related to the class be in the class and also every method does only one single thing.

  * O : **Open Closed Principle** (OCP) [Open for extension - Closed for modification]
        I could make it through Abstract class and extends the methods for every different type of needed class
        _OR_ Make an interface and implements the methods later as needed (Which I used here).

  * L : **Liskov Substitution Principle** (LSP) [One object can be used by different forms]
        Make the methods in the interface general and then Override the method depending on the requirements.

  * I : **Interface Segregation Principle** (ISP) [Avoid fat interface]
        Interface here is what the clients see and use so must avoid implementing unnecessary methods and use more interfaces as needed using extensions.

  * D : **Dependency Inversion Principle** (DIP) [Modules should depend upon abstractions]
        High level modules should not depend upon low level (concrete) modules but use interface in between ConstructorInjection _or_ MethodInjection _or_
        PropertyInjection.
