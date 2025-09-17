package dev.yactt.presentation.core.platform.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<State : MviState, Intent : MviIntent, Effect : MviEffect> :
    ViewModel(),
    KoinComponent {
    abstract val state: StateFlow<State>

    abstract val intent: StateFlow<Intent?>

    public abstract val effect: Channel<Effect?>

    abstract fun onIntent(intent: Intent)

    abstract fun onEffect(effect: Effect)

    fun <T> executeCoroutine(
        context: CoroutineContext = Dispatchers.Default,
        scope: CoroutineScope = viewModelScope,
        debounce: Long? = null,
        loading: ((Boolean) -> Unit)? = null,
        result: ((T?) -> Unit)? = null,
        errorBlock: ((Throwable) -> Unit)? = null,
        request: suspend CoroutineScope.() -> T?,
    ): Job =
        scope.launch {
            try {
                debounce?.let {
                    delay(it)
                }
                loading?.invoke(true)
                withContext(context) { request() }.apply {
                    this.let { result?.invoke(it) }
                }
            } catch (e: Throwable) {
                errorBlock?.invoke(e)
                loading?.invoke(false)
            } finally {
                loading?.invoke(false)
            }
        }

    fun <T> executeResult(
        context: CoroutineContext = Dispatchers.Default,
        scope: CoroutineScope = viewModelScope,
        debounce: Long? = null,
        loading: ((Boolean) -> Unit)? = null,
        result: ((T?) -> Unit)? = null,
        errorBlock: ((Throwable) -> Unit)? = null,
        request: suspend CoroutineScope.() -> Result<T>?,
    ): Job =
        scope.launch {
            try {
                debounce?.let {
                    delay(it)
                }
                loading?.invoke(true)
                withContext(context) {
                    request()
                }.apply {
                    this.let { monad ->
                        monad?.fold(
                            onSuccess = { result?.invoke(it) },
                            onFailure = { errorBlock?.invoke(it) },
                        )
                    }
                }
            } catch (e: Throwable) {
                errorBlock?.invoke(e)
                loading?.invoke(false)
            } finally {
                loading?.invoke(false)
            }
        }

    protected fun <T> StateFlow<T>.setValue(value: T) {
        (this as? MutableStateFlow)?.update {
            value
        }
    }

    protected fun updateState(block: State.() -> State) =
        executeCoroutine {
            state.setValue(state.value.block())
        }
}
