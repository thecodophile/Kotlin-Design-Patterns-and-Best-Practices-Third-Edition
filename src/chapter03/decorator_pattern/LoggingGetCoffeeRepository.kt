package chapter03.decorator_pattern

/*class LoggingGetCoffeeRepository : CoffeeRepository() {
    override fun getCoffee(usersChoice: String, expectedCost: Double): String {
        println("User asked for coffee $usersChoice; within $expectedCost rupees.")
        return super.getCoffee(usersChoice, expectedCost)
    }
}*/

class LoggingGetCoffeeRepository(private val repository: CoffeeRepository) :
    CoffeeRepository by repository {
    override fun getCoffee(usersChoice: String, expectedCost: Double): String {
        println("User asked for coffee $usersChoice; within $expectedCost rupees.")
        return repository.getCoffee(usersChoice, expectedCost)
    }
}