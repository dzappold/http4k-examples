package extending_http4k_connect

import org.http4k.connect.ChaosFake
import org.http4k.connect.storage.InMemory
import org.http4k.connect.storage.Storage
import org.http4k.routing.routes

class FakeExpensesSystem(storage: Storage<Expense> = Storage.InMemory()) : ChaosFake() {
    override val app = routes(
        addExpense(storage),
        expenseReport(storage)
    )
}

// if you run this you will see the (static) port which is allocated automatically by http4k-connect
fun main() {
    FakeExpensesSystem().start()
}
