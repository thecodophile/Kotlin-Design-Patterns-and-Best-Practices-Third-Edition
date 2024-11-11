package Chapter03.decorator_pattern

/*class ValidatingMakeCoffeeRepository : CoffeeRepository() {
    override fun makeCoffee(usersChoice: String, expectedCost: Double) {
        if (usersChoice.length > 50) {
            throw RuntimeException("Sorry, the description you provide is too long (max 50 characters).")
        } else if (expectedCost < 20.00) {
            throw RuntimeException("Sorry, we do not accept coffee orders under $expectedCost rupees.")
        }
        super.makeCoffee(usersChoice, expectedCost)
    }
}*/

class ValidatingMakeCoffeeRepository(private val repository: CoffeeRepository) :
    CoffeeRepository by repository {
    private val maxDescriptionLength = 50
    private val minCost = 20.00
    override fun makeCoffee(usersChoice: String, expectedCost: Double) {
        require(usersChoice.length < maxDescriptionLength) {
            "Sorry, the description you provide is too long (max 50 characters)."
        }
        require(expectedCost > 20.00) {
            "Sorry, we do not accept coffee orders under $expectedCost rupees."
        }
        repository.makeCoffee(usersChoice, expectedCost)
    }
}