package com.example.eventmaster.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Interceptor base para futuras peticiones autenticadas.
 * Por ahora solo reenvía la petición sin modificarla.
 */
class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}

