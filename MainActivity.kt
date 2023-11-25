//Задача 1
/*class SettingsManager private
        constructor(){

            private var someSetting: String = ""

            companion object {
                @Volatile
                private var instance:
              SettingsManager? = null

                fun getInstance():
              SettingsManager{
                    return instance ?:
              synchronized(this){
                  instance ?:
              SettingsManager().also { instance = it }

              }
                }
            }
            fun getSomeSetting(): String {
                return someSetting
            }
            fun setSomeSetting(newSetting:String){
                someSetting = newSetting
            }

        }

 */
/*
// теперь, чтобы получить доступ к экземпляру синглтона из разных частей приложения
     fun main(){
         // Получение экземпляра синглтона
         val settingsManager = SettingsManager.getInstance()
         // Использование методов или свойств синглтона
         val currentSetting = settingsManager.getSomeSetting()
         // Установка нового значения
         settingsManager.setSomeSetting("Новая настройка")//
     }

 */
//Задача 2
// Интерфейс продукта
/*interface Product {
    fun displayInfo()
}

// Два класса, реализующих интерфейс продукта
class ConcreteProductA : Product {
    override fun displayInfo() {
        println("ConcreteProductA")
    }
}

class ConcreteProductB : Product {
    override fun displayInfo() {
        println("ConcreteProductB")
    }
}

// Интерфейс создателя
interface Creator {
    fun createProduct(): Product
}

// Два класса-создателя, каждый из которых возвращает свой конкретный продукт
class ConcreteCreatorA : Creator {
    override fun createProduct(): Product {
        return ConcreteProductA()
    }
}

class ConcreteCreatorB : Creator {
    override fun createProduct(): Product {
        return ConcreteProductB()
    }
}

// Пример использования
fun main() {
    // Используем ConcreteCreatorA
    val creatorA: Creator = ConcreteCreatorA()
    val productA: Product = creatorA.createProduct()
    productA.displayInfo()

    // Используем ConcreteCreatorB
    val creatorB: Creator = ConcreteCreatorB()
    val productB: Product = creatorB.createProduct()
    productB.displayInfo()
}


 */
//Задача 3
// Интерфейс подписчика
/*interface Observer {
    fun update(message: String)
}

// Класс предмета (Subject)
class Subject {
    private val observers: MutableList<Observer> = mutableListOf()

    // Методы для управления подписчиками
    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    // Метод для уведомления всех подписчиков
    fun notifyObservers(message: String) {
        for (observer in observers) {
            observer.update(message)
        }
    }
}

// Классы конкретных подписчиков
class ConcreteObserverA : Observer {
    override fun update(message: String) {
        println("Observer A received message: $message")
    }
}

class ConcreteObserverB : Observer {
    override fun update(message: String) {
        println("Observer B received message: $message")
    }
}

// Пример использования
fun main() {
    // Создание предмета (Subject)
    val subject = Subject()

    // Создание подписчиков (Observers)
    val observerA = ConcreteObserverA()
    val observerB = ConcreteObserverB()

    // Добавление подписчиков к предмету
    subject.addObserver(observerA)
    subject.addObserver(observerB)

    // Изменение в предмете приводит к уведомлению всех подписчиков
    subject.notifyObservers("Hello, observers!")

    // Удаление одного из подписчиков
    subject.removeObserver(observerA)

    // Изменение в предмете приводит к уведомлению оставшегося подписчика
    subject.notifyObservers("Hello again!")
}

 */
//Задача 4
// Интерфейс стратегии
/*interface PaymentStrategy {
    fun pay(amount: Double)
}

// Классы, реализующие интерфейс стратегии
class CreditCardPaymentStrategy(private val cardNumber: String, private val expiryDate: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $amount using credit card $cardNumber (Expires: $expiryDate)")
    }
}

class PayPalPaymentStrategy(private val email: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $amount using PayPal (Email: $email)")
    }
}

// Класс контекста
class PaymentContext(private var paymentStrategy: PaymentStrategy) {
    // Метод для установки текущей стратегии
    fun setPaymentStrategy(strategy: PaymentStrategy) {
        paymentStrategy = strategy
    }

    // Метод для выполнения стратегии
    fun executePayment(amount: Double) {
        paymentStrategy.pay(amount)
    }
}

// Пример использования
fun main() {
    // Создание объектов стратегий
    val creditCardStrategy = CreditCardPaymentStrategy("1234-5678-9876-5432", "12/25")
    val paypalStrategy = PayPalPaymentStrategy("user@example.com")

    // Создание объекта контекста с начальной стратегией
    val paymentContext = PaymentContext(creditCardStrategy)

    // Выполнение стратегии
    paymentContext.executePayment(100.0)

    // Изменение стратегии
    paymentContext.setPaymentStrategy(paypalStrategy)

    // Выполнение новой стратегии
    paymentContext.executePayment(50.0)
}

 */
//Задача 5
// Интерфейс компонента
/*interface Coffee {
    fun cost(): Double
    fun description(): String
}

// Конкретный компонент
class SimpleCoffee : Coffee {
    override fun cost(): Double {
        return 2.0
    }

    override fun description(): String {
        return "Simple Coffee"
    }
}

// Абстрактный декоратор
abstract class CoffeeDecorator(private val decoratedCoffee: Coffee) : Coffee {
    override fun cost(): Double {
        return decoratedCoffee.cost()
    }

    override fun description(): String {
        return decoratedCoffee.description()
    }
}

// Конкретные декораторы
class MilkDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun cost(): Double {
        return super.cost() + 1.0
    }

    override fun description(): String {
        return super.description() + ", Milk"
    }
}

class SugarDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun cost(): Double {
        return super.cost() + 0.5
    }

    override fun description(): String {
        return super.description() + ", Sugar"
    }
}

// Пример использования
fun main() {
    // Создание простого кофе
    val simpleCoffee: Coffee = SimpleCoffee()
    println("Cost: ${simpleCoffee.cost()}, Description: ${simpleCoffee.description()}")

    // Декорирование кофе с молоком
    val milkCoffee: Coffee = MilkDecorator(simpleCoffee)
    println("Cost: ${milkCoffee.cost()}, Description: ${milkCoffee.description()}")

    // Декорирование кофе с молоком и сахаром
    val sugarMilkCoffee: Coffee = SugarDecorator(milkCoffee)
    println("Cost: ${sugarMilkCoffee.cost()}, Description: ${sugarMilkCoffee.description()}")
}

 */
//Задача 6
// Интерфейс команды
interface Command {
    fun execute()
}

// Классы конкретных команд
class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}

class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }
}

// Класс "получатель" (Receiver)
class Light {
    fun turnOn() {
        println("Light is ON")
    }

    fun turnOff() {
        println("Light is OFF")
    }
}

// Класс "Invoker"
class RemoteControl {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}

// Пример использования
fun main() {
    // Создание объекта "получателя"
    val light = Light()

    // Создание объектов команд
    val lightOnCommand = LightOnCommand(light)
    val lightOffCommand = LightOffCommand(light)

    // Создание объекта "Invoker" (пульта)
    val remoteControl = RemoteControl()

    // Настройка пульта с командами
    remoteControl.setCommand(lightOnCommand)

    // Нажатие кнопки на пульте вызывает выполнение команды
    remoteControl.pressButton()

    // Смена команды на выключение света
    remoteControl.setCommand(lightOffCommand)

    // Нажатие кнопки на пульте вызывает выполнение новой команды
    remoteControl.pressButton()
}



