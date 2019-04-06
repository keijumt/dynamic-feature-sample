package keijumt.dynamicfeature.data

interface MainRepository {
    fun getHoge(): String
}

internal class MainRepositoryImpl : MainRepository {
    override fun getHoge(): String {
        return "hoge"
    }
}