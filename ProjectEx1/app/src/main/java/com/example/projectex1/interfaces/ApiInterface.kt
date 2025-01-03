package com.example.classproject.interfaces


import com.example.projectex1.Model.CategoryModel
import com.example.projectex1.Model.DashboardModel
import com.example.projectex1.WishlistModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import tops.tech.batchproject_morning.RegisterModel


interface ApiInterface
{
    //Register
    @FormUrlEncoded
    @POST("user_signup.php")
    fun registerdetail(
        @Field("user_first_name") firstname: String?,
        @Field("user_last_name") lastname: String?,
        @Field("user_gender") gender:String?,
        @Field("user_email") email: String?,
        @Field("user_phone") mobile: String?,
        @Field("user_password") password: String?,
        ): Call<Void>

    //Login
    @FormUrlEncoded
    @POST("user_login.php")
    fun logindata(
        @Field("user_phone") mobile: String?,
        @Field("user_password") password: String?
    ): Call<RegisterModel>

    @GET("dashboard_view.php")
    fun dashboard_viewdata():Call<List<DashboardModel>>

    @FormUrlEncoded
    @POST("category_view.php")
    fun categoryviewdata
        (
            @Field("data") data: Int?,
        ): Call<List<CategoryModel>>

//    @GET("wishlist_view.php")
//    fun wishlistViewData(mob:String):Call<List<WishlistModel>>


    @FormUrlEncoded
    @POST("wishlist_view.php")
    fun wishlistViewData
                (
        @Field("mobile") mobile: String?,
    ): Call<List<WishlistModel>>


    @FormUrlEncoded
    @POST("add_data_to_wishlist.php")
    fun wishadddetail(
        @Field("gift_name") gift_name: String?,
        @Field("gift_description") gift_description: String?,
        @Field("gift_price") gift_price:String?,
        @Field("image") image: String?,
        @Field("mobile") mobile: String?,

    ): Call<Void>
}