package chapter03.adapter_pattern

import java.util.Objects

fun main(){
    cellPhone(
        charger(
            usPowerOutlet().toEUPlug()
        ).toUsbTypeC()
    )
}

fun cellPhone(chargeCable:UsbTypeC){
    if(chargeCable.hasPower){
        println("I've Got The Power!")
    }else{
        print("No Power")
    }
}

fun usPowerOutlet():USPlug{
    return  object :USPlug{
        override val hasPower = 1
    }
}

// Charger accepts EUPlug interface and exposes UsbMini interface
fun charger(plug: EUPlug): UsbMini {
    return object : UsbMini {
        override val hasPower = if (plug.hasPower == "YES")
            PowerState.TRUE else PowerState.FALSE
    }
}

fun USPlug.toEUPlug(): EUPlug {
    val hasPower = if (this.hasPower == 1) "YES" else "NO"
    return object : EUPlug {
        // Transfer power
        override val hasPower = hasPower
    }
}

fun UsbMini.toUsbTypeC(): UsbTypeC {
    val hasPower = this.hasPower == PowerState.TRUE
    return object : UsbTypeC {
        override val hasPower = hasPower
    }
}
