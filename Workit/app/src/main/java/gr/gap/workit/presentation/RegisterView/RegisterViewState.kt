package gr.gap.workit.presentation.RegisterView

sealed class RegisterViewState {
    object Loading : RegisterViewState()
    object Data : RegisterViewState()
    data class Error(val error: Throwable) : RegisterViewState()
}