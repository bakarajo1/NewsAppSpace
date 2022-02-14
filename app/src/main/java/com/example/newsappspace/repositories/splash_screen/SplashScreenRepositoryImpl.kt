
import com.example.newsappspace.datastore.CheckUserDataStore
import kotlinx.coroutines.flow.Flow

class SplashScreenRepositoryImpl(private val dataStore: CheckUserDataStore) : SplashScreenRepository {

    override suspend fun getUserState(key: String): Flow<String?> = dataStore.getState(key)

}