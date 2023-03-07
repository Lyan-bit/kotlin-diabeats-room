package com.example.diabeats

import com.example.diabeats.DiabeatsEntity
import kotlinx.coroutines.flow.Flow

interface DiabeatsRepository {
    //Read
    suspend fun listDiabeats(): List<DiabeatsEntity>

    //Create
    suspend fun createDiabeats(diabeats: DiabeatsEntity)

    //Update
    suspend fun updateDiabeats(diabeats: DiabeatsEntity)

    //Delete All Diabeatss
    suspend fun deleteDiabeatss()


    //Delete a Diabeats by PK
	suspend fun deleteDiabeats(id: String)
	    
    //Search with live data
    fun searchByDiabeatsid(searchQuery: String): Flow<List<DiabeatsEntity>>
    //Search with live data
    fun searchByDiabeatspregnancies(searchQuery: Int): Flow<List<DiabeatsEntity>>
    //Search with live data
    fun searchByDiabeatsglucose(searchQuery: Int): Flow<List<DiabeatsEntity>>
    //Search with live data
    fun searchByDiabeatsbloodPressure(searchQuery: Int): Flow<List<DiabeatsEntity>>
    //Search with live data
    fun searchByDiabeatsskinThickness(searchQuery: Int): Flow<List<DiabeatsEntity>>
    //Search with live data
    fun searchByDiabeatsinsulin(searchQuery: Int): Flow<List<DiabeatsEntity>>
    //Search with live data
    fun searchByDiabeatsbmi(searchQuery: Double): Flow<List<DiabeatsEntity>>
    //Search with live data
    fun searchByDiabeatsdiabetesPedigreeFunction(searchQuery: Double): Flow<List<DiabeatsEntity>>
    //Search with live data
    fun searchByDiabeatsage(searchQuery: Int): Flow<List<DiabeatsEntity>>
    //Search with live data
    fun searchByDiabeatsoutcome(searchQuery: String): Flow<List<DiabeatsEntity>>

    //Search with suspend
    suspend fun searchByDiabeatsid2(searchQuery: String): List<DiabeatsEntity>
    suspend fun searchByDiabeatspregnancies2(searchQuery: Int): List<DiabeatsEntity>
    suspend fun searchByDiabeatsglucose2(searchQuery: Int): List<DiabeatsEntity>
    suspend fun searchByDiabeatsbloodPressure2(searchQuery: Int): List<DiabeatsEntity>
    suspend fun searchByDiabeatsskinThickness2(searchQuery: Int): List<DiabeatsEntity>
    suspend fun searchByDiabeatsinsulin2(searchQuery: Int): List<DiabeatsEntity>
    suspend fun searchByDiabeatsbmi2(searchQuery: Double): List<DiabeatsEntity>
    suspend fun searchByDiabeatsdiabetesPedigreeFunction2(searchQuery: Double): List<DiabeatsEntity>
    suspend fun searchByDiabeatsage2(searchQuery: Int): List<DiabeatsEntity>
    suspend fun searchByDiabeatsoutcome2(searchQuery: String): List<DiabeatsEntity>

}
