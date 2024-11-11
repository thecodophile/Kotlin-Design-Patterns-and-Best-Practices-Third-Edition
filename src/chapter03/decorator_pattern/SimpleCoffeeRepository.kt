package chapter03.decorator_pattern

class SimpleCoffeeRepository : CoffeeRepository {
    private var cost: Double = 5.0
    private var description: String = "Simple Coffee"
    override fun getCoffee(usersChoice: String, expectedCost: Double): String {
        return if (description == usersChoice && cost == expectedCost) {
            "Here's your coffee $description; it costs $cost rupees."
        } else {
            "Sorry, no matching coffee found."
        }
    }

    override fun makeCoffee(usersChoice: String, expectedCost: Double) {
        description = usersChoice
        cost = expectedCost
    }
}