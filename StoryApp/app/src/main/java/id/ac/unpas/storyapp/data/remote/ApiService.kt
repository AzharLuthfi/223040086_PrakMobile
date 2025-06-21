package id.ac.unpas.storyapp.data.remote

import id.ac.unpas.storyapp.data.remote.model.LoginRequest
import id.ac.unpas.storyapp.data.remote.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    // Tambahkan endpoint lain di sini
}