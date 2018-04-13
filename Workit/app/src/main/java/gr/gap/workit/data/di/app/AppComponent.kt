package gr.gap.workit.data.di.app

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}