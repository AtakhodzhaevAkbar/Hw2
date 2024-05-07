package com.example.m5_hw2

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.m5_hw2.ViewModels.MainViewModel
import com.example.m5_hw2.data.local.dao.LoveDao
import com.example.m5_hw2.data.local.database.LoveDataBase
import com.example.m5_hw2.data.network.LoveApiService
import com.example.m5_hw2.data.repository.LoveRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApi(): LoveApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(LoveApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideLoveDao(@ApplicationContext context: Context): LoveDao {
        return LoveDataBase.getInstance(context).dao()
    }

    @Singleton
    @Provides
    fun provideLoveRepository(apiService: LoveApiService, dao: LoveDao): LoveRepository {
        return LoveRepository(apiService, dao)
    }

    @Singleton
    @Provides
    fun provideViewModel(
        repository: LoveRepository,
        application: Application
    ): MainViewModel {
        return MainViewModel(repository, application)
    }
}
