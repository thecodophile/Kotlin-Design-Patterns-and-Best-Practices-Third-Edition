package chapter03.decorator_pattern

fun main() {
    val repository = SimpleCoffeeRepository()
    val loggingRepository = LoggingGetCoffeeRepository(repository)
    //    val validatingRepository = ValidatingMakeCoffeeRepository(repository)
    val validatingRepository = ValidatingMakeCoffeeRepository(loggingRepository)

    //    println(validatingRepository.getCoffee(usersChoice = "with milk, sugar and nuts", expectedCost = 20.00))
    validatingRepository.makeCoffee(usersChoice = "with milk, sugar and nuts", expectedCost = 25.00)
    println(validatingRepository.getCoffee(usersChoice = "with milk, sugar and nuts", expectedCost = 25.00))
}
