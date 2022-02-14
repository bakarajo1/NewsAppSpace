
import kotlinx.coroutines.flow.Flow

interface SplashScreenRepository {
    suspend fun getUserState(key: String): Flow<String?>

}