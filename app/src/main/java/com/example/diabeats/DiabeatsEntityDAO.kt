package com.example.diabeats

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DiabeatsEntityDao {
    //LiveData
    //Read (list entity)
    @Query("SELECT * FROM diabeatsTable")
    fun listDiabeatss(): Flow<List<DiabeatsEntity>>

    //Read (list id)
	@Query("SELECT id FROM diabeatsTable")
	fun listDiabeatsids (): Flow<List<String>>
    //Read (list pregnancies)
	@Query("SELECT pregnancies FROM diabeatsTable")
	fun listDiabeatspregnanciess (): Flow<List<Int>>
    //Read (list glucose)
	@Query("SELECT glucose FROM diabeatsTable")
	fun listDiabeatsglucoses (): Flow<List<Int>>
    //Read (list bloodPressure)
	@Query("SELECT bloodPressure FROM diabeatsTable")
	fun listDiabeatsbloodPressures (): Flow<List<Int>>
    //Read (list skinThickness)
	@Query("SELECT skinThickness FROM diabeatsTable")
	fun listDiabeatsskinThicknesss (): Flow<List<Int>>
    //Read (list insulin)
	@Query("SELECT insulin FROM diabeatsTable")
	fun listDiabeatsinsulins (): Flow<List<Int>>
    //Read (list bmi)
	@Query("SELECT bmi FROM diabeatsTable")
	fun listDiabeatsbmis (): Flow<List<Double>>
    //Read (list diabetesPedigreeFunction)
	@Query("SELECT diabetesPedigreeFunction FROM diabeatsTable")
	fun listDiabeatsdiabetesPedigreeFunctions (): Flow<List<Double>>
    //Read (list age)
	@Query("SELECT age FROM diabeatsTable")
	fun listDiabeatsages (): Flow<List<Int>>
    //Read (list outcome)
	@Query("SELECT outcome FROM diabeatsTable")
	fun listDiabeatsoutcomes (): Flow<List<String>>

	//Suspend
    //Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createDiabeats (diabeats: DiabeatsEntity)

    //Read (list entity with suspend)
    @Query("SELECT * FROM diabeatsTable")
    suspend fun listDiabeats(): List<DiabeatsEntity>

    //Update
    @Update
    suspend fun updateDiabeats (diabeats: DiabeatsEntity)

    //Delete all records
    @Query("DELETE FROM diabeatsTable")
    suspend fun deleteDiabeatss ()

    //Delete a single record by PK
    @Query("DELETE FROM diabeatsTable WHERE id = :id")
    suspend fun deleteDiabeats (id: String)
    
    //Search with live data
	@Query("SELECT * FROM  diabeatsTable WHERE id LIKE :searchQuery ")
	fun searchByDiabeatsid(searchQuery: String): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeatsTable WHERE pregnancies LIKE :searchQuery ")
	fun searchByDiabeatspregnancies(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeatsTable WHERE glucose LIKE :searchQuery ")
	fun searchByDiabeatsglucose(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeatsTable WHERE bloodPressure LIKE :searchQuery ")
	fun searchByDiabeatsbloodPressure(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeatsTable WHERE skinThickness LIKE :searchQuery ")
	fun searchByDiabeatsskinThickness(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeatsTable WHERE insulin LIKE :searchQuery ")
	fun searchByDiabeatsinsulin(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeatsTable WHERE bmi LIKE :searchQuery ")
	fun searchByDiabeatsbmi(searchQuery: Double): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeatsTable WHERE diabetesPedigreeFunction LIKE :searchQuery ")
	fun searchByDiabeatsdiabetesPedigreeFunction(searchQuery: Double): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeatsTable WHERE age LIKE :searchQuery ")
	fun searchByDiabeatsage(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeatsTable WHERE outcome LIKE :searchQuery ")
	fun searchByDiabeatsoutcome(searchQuery: String): Flow<List<DiabeatsEntity>>

    //Search with suspend
    @Query("SELECT * FROM  diabeatsTable WHERE id LIKE :searchQuery")
	suspend fun searchByDiabeatsid2(searchQuery: String): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeatsTable WHERE pregnancies LIKE :searchQuery")
	suspend fun searchByDiabeatspregnancies2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeatsTable WHERE glucose LIKE :searchQuery")
	suspend fun searchByDiabeatsglucose2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeatsTable WHERE bloodPressure LIKE :searchQuery")
	suspend fun searchByDiabeatsbloodPressure2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeatsTable WHERE skinThickness LIKE :searchQuery")
	suspend fun searchByDiabeatsskinThickness2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeatsTable WHERE insulin LIKE :searchQuery")
	suspend fun searchByDiabeatsinsulin2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeatsTable WHERE bmi LIKE :searchQuery")
	suspend fun searchByDiabeatsbmi2(searchQuery: Double): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeatsTable WHERE diabetesPedigreeFunction LIKE :searchQuery")
	suspend fun searchByDiabeatsdiabetesPedigreeFunction2(searchQuery: Double): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeatsTable WHERE age LIKE :searchQuery")
	suspend fun searchByDiabeatsage2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeatsTable WHERE outcome LIKE :searchQuery")
	suspend fun searchByDiabeatsoutcome2(searchQuery: String): List<DiabeatsEntity>

}
