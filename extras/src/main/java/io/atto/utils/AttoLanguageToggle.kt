package io.atto.utils

import android.content.Context
import android.content.SharedPreferences
import io.atto.android.AttoConsts
import io.atto.utils.logger.AttoLogger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 10/3/2019
 * Time : 9:05 AM
 */

object AttoLanguageToggle {

    lateinit var prefs: SharedPreferences

    suspend fun init(context: Context, packageName: String) {
        withContext(Dispatchers.IO) {
            prefs = context.getSharedPreferences(packageName, Context.MODE_PRIVATE)
        }
    }

    suspend fun saveSelectedLanguage(language: String) {
        withContext(Dispatchers.IO) {
            if (::prefs.isInitialized) {
                prefs.edit().putString("AttoSelectedLanguage", language).apply()
            } else {
                AttoLogger.log(AttoConsts.LANGUAGE_NOT_INITIALIZED)
            }
        }
    }

    suspend fun getSelectedLanguage(): String? {
        return withContext(Dispatchers.IO) {
            prefs.getString("AttoSelectedLanguage", null)
        }
    }

    suspend fun changeApplicationLanguage(newLanguage: String, context: Context?) {
        withContext(Dispatchers.IO) {
            context?.let {
                val resources = it.resources
                val locale = Locale(newLanguage)
                Locale.setDefault(locale)
                val config = android.content.res.Configuration()
                config.setLocale(locale)
                resources.updateConfiguration(config, resources.displayMetrics)
            }
        }
    }

}

suspend fun languagePreCondition(context: Context?) {
    withContext(Dispatchers.IO) {
        AttoLanguageToggle.getSelectedLanguage()?.let {
            AttoLanguageToggle.changeApplicationLanguage(it, context)
        }
    }
}