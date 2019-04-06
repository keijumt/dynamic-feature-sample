package keijumt.dynamicfeature.di

import android.content.Context
import dagger.Module
import dagger.Provides
import keijumt.dynamicfeature.App
import keijumt.dynamicfeature.data.MainRepository
import keijumt.dynamicfeature.data.MainRepositoryImpl
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: App): Context {
        return app
    }

    @Provides
    fun provideMainRepository(): MainRepository {
        return MainRepositoryImpl()
    }
}