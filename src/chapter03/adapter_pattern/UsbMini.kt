package chapter03.adapter_pattern

enum class PowerState{
    TRUE, FALSE
}
interface UsbMini {
    val hasPower : PowerState
}

