package chapter03.adapter_pattern

/* value 1 indicating power and any other value means no power*/
interface USPlug {
    val hasPower: Int
}