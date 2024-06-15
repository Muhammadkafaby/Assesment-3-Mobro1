package org.d3if0149.assesment3.network

import com.squareup.moshi.Moshi
import org.d3if0149.assesment3.model.OpStatus
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0149.assesment3.model.Store
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

private const val BASE_URL =  "https://unspoken.my.id/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StoreApiService {
    @GET("api_raihan.php")
    suspend fun getStore(
        @Header("Authorization") userId: String
    ): List<Store>
    @Multipart
    @POST("api_raihan.php")
    suspend fun postStore(
        @Header("Authorization") userId: String,
        @Part("nama") nama: RequestBody,
        @Part("deskripsi") deskripsi: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus

    @DELETE("api_raihan.php")
    suspend fun deleteStore(
        @Header("Authorization") userId: String,
        @Query("id") storeId: String
    ) : OpStatus
}
object StoreApi {
    val service: StoreApiService by lazy {
        retrofit.create(StoreApiService::class.java)
    }
    fun getStoreUrl(imageId: String): String {
        return "${BASE_URL}image.php?id=$imageId"
    }
}
enum class ApiStatus{LOADING, SUCCESS, FAILED}