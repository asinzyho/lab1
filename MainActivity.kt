class SettingsManager private
        constructor(){

            private var someSetting: String = ""

            companion object {
                @Volatile
                private var instance:
              SettingsManager? = null

                fun getInstance():
              SettingsManager{
                    return instance ?:
              synchronized(this){
                  instance ?:
              SettingsManager().also { instance = it }

              }
                }
            }
            fun getSomeSetting(): String {
                return someSetting
            }
            fun setSomeSetting(newSetting:String){
                someSetting = newSetting
            }

        }
// теперь, чтобы получить доступ к экземпляру синглтона из разных частей приложения
     fun main(){
         // Получение экземпляра синглтона
         val settingsManager = SettingsManager.getInstance()
         // Использование методов или свойств синглтона
         val currentSetting = settingsManager.getSomeSetting()
         // Установка нового значения
         settingsManager.setSomeSetting("Новая настройка")
     }
