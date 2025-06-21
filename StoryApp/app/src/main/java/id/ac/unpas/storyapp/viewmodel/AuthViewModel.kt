package id.ac.unpas.storyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.ac.unpas.storyapp.data.local.entity.UserEntity
import id.ac.unpas.storyapp.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<Result<UserEntity>?>(null)
    val loginState: StateFlow<Result<UserEntity>?> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            authRepository.login(email, password).collect { result ->
                _loginState.value = result
            }
        }
    }
}