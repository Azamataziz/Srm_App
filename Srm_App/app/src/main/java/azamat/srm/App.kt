package azamat.srm

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DB.init(this)
    }
}