package com.example.diabeats

import kotlinx.coroutines.flow.Flow

class Repository : DiabeatsRepository  {

    private val diabeatsDao: DiabeatsEntityDao by lazy { DiabeatsApplication.database.diabeatsDao() }

    val allDiabeatss: Flow<List<DiabeatsEntity>> = diabeatsDao.listDiabeatss()

    val allDiabeatsids: Flow<List<String>> = diabeatsDao.listDiabeatsids()
    val allDiabeatspregnanciess: Flow<List<Int>> = diabeatsDao.listDiabeatspregnanciess()
    val allDiabeatsglucoses: Flow<List<Int>> = diabeatsDao.listDiabeatsglucoses()
    val allDiabeatsbloodPressures: Flow<List<Int>> = diabeatsDao.listDiabeatsbloodPressures()
    val allDiabeatsskinThicknesss: Flow<List<Int>> = diabeatsDao.listDiabeatsskinThicknesss()
    val allDiabeatsinsulins: Flow<List<Int>> = diabeatsDao.listDiabeatsinsulins()
    val allDiabeatsbmis: Flow<List<Double>> = diabeatsDao.listDiabeatsbmis()
    val allDiabeatsdiabetesPedigreeFunctions: Flow<List<Double>> = diabeatsDao.listDiabeatsdiabetesPedigreeFunctions()
    val allDiabeatsages: Flow<List<Int>> = diabeatsDao.listDiabeatsages()
    val allDiabeatsoutcomes: Flow<List<String>> = diabeatsDao.listDiabeatsoutcomes()

    //Create
    override suspend fun createDiabeats(diabeats: DiabeatsEntity) {
        diabeatsDao.createDiabeats(diabeats)
    }

    //Read
    override suspend fun listDiabeats(): List<DiabeatsEntity> {
        return diabeatsDao.listDiabeats()
    }

    //Update
    override suspend fun updateDiabeats(diabeats: DiabeatsEntity) {
        diabeatsDao.updateDiabeats(diabeats)
    }

    //Delete all Diabeatss
    override suspend fun deleteDiabeatss() {
       diabeatsDao.deleteDiabeatss()
    }

    //Delete a Diabeats
	override suspend fun deleteDiabeats(id: String) {
	   diabeatsDao.deleteDiabeats(id)
    }
    
     //Search with live data
     override fun searchByDiabeatsid (searchQuery: String): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatsid(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatspregnancies (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatspregnancies(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsglucose (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatsglucose(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsbloodPressure (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatsbloodPressure(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsskinThickness (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatsskinThickness(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsinsulin (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatsinsulin(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsbmi (searchQuery: Double): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatsbmi(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsdiabetesPedigreeFunction (searchQuery: Double): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatsdiabetesPedigreeFunction(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsage (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatsage(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsoutcome (searchQuery: String): Flow<List<DiabeatsEntity>>  {
         return diabeatsDao.searchByDiabeatsoutcome(searchQuery)
     }
     

    //Search with suspend
     override suspend fun searchByDiabeatsid2 (id: String): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatsid2(id)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatspregnancies2 (pregnancies: Int): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatspregnancies2(pregnancies)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsglucose2 (glucose: Int): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatsglucose2(glucose)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsbloodPressure2 (bloodPressure: Int): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatsbloodPressure2(bloodPressure)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsskinThickness2 (skinThickness: Int): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatsskinThickness2(skinThickness)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsinsulin2 (insulin: Int): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatsinsulin2(insulin)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsbmi2 (bmi: Double): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatsbmi2(bmi)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsdiabetesPedigreeFunction2 (diabetesPedigreeFunction: Double): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatsdiabetesPedigreeFunction2(diabetesPedigreeFunction)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsage2 (age: Int): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatsage2(age)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsoutcome2 (outcome: String): List<DiabeatsEntity> {
          return diabeatsDao.searchByDiabeatsoutcome2(outcome)
     }
	     


}
