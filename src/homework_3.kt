import java.lang.ref.WeakReference
import kotlin.reflect.KProperty

class Weak<T>(value: T) {
    var weakReference: WeakReference<T>?

    init {
        weakReference = WeakReference(value)
    }

    operator fun getValue(thisRef: Any, property: KProperty<*>): T? = weakReference?.get()
    operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        weakReference = WeakReference(value)
    }

}

class WeakReferenceDelegate {
    val property : Int? by Weak(14)
}