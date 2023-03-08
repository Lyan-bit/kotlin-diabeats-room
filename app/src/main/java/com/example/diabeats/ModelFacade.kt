package com.example.diabeats

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.ArrayList
import android.content.res.AssetManager
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.FileChannel
import java.util.*

class ModelFacade private constructor(context: Context) {

    private val assetManager: AssetManager = context.assets
    private var fileSystem: FileAccessor



    init {
    	//init
        fileSystem = FileAccessor(context)
    }

    companion object {
    	private val repository by lazy { Repository() }
        private var instance: ModelFacade? = null
        fun getInstance(context: Context): ModelFacade {
            return instance ?: ModelFacade(context)
        }
    }
    

    val allDiabeatss: LiveData<List<DiabeatsEntity>> = repository.allDiabeatss.asLiveData()

    val allDiabeatsIds: LiveData<List<String>> = repository.allDiabeatsids.asLiveData()
    val allDiabeatsPregnanciess: LiveData<List<Int>> = repository.allDiabeatspregnanciess.asLiveData()
    val allDiabeatsGlucoses: LiveData<List<Int>> = repository.allDiabeatsglucoses.asLiveData()
    val allDiabeatsBloodPressures: LiveData<List<Int>> = repository.allDiabeatsbloodPressures.asLiveData()
    val allDiabeatsSkinThicknesss: LiveData<List<Int>> = repository.allDiabeatsskinThicknesss.asLiveData()
    val allDiabeatsInsulins: LiveData<List<Int>> = repository.allDiabeatsinsulins.asLiveData()
    val allDiabeatsBmis: LiveData<List<Double>> = repository.allDiabeatsbmis.asLiveData()
    val allDiabeatsDiabetesPedigreeFunctions: LiveData<List<Double>> = repository.allDiabeatsdiabetesPedigreeFunctions.asLiveData()
    val allDiabeatsAges: LiveData<List<Int>> = repository.allDiabeatsages.asLiveData()
    val allDiabeatsOutcomes: LiveData<List<String>> = repository.allDiabeatsoutcomes.asLiveData()
    private var currentDiabeats: DiabeatsEntity? = null
    private var currentDiabeatss: List<DiabeatsEntity> = ArrayList()
	    
    fun searchByDiabeatsid(searchQuery: String): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsid(searchQuery).asLiveData()
    }
    
    fun searchByDiabeatspregnancies(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatspregnancies(searchQuery).asLiveData()
    }
    
    fun searchByDiabeatsglucose(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsglucose(searchQuery).asLiveData()
    }
    
    fun searchByDiabeatsbloodPressure(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsbloodPressure(searchQuery).asLiveData()
    }
    
    fun searchByDiabeatsskinThickness(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsskinThickness(searchQuery).asLiveData()
    }
    
    fun searchByDiabeatsinsulin(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsinsulin(searchQuery).asLiveData()
    }
    
    fun searchByDiabeatsbmi(searchQuery: Double): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsbmi(searchQuery).asLiveData()
    }
    
    fun searchByDiabeatsdiabetesPedigreeFunction(searchQuery: Double): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsdiabetesPedigreeFunction(searchQuery).asLiveData()
    }
    
    fun searchByDiabeatsage(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsage(searchQuery).asLiveData()
    }
    
    fun searchByDiabeatsoutcome(searchQuery: String): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsoutcome(searchQuery).asLiveData()
    }
    

	fun getDiabeatsByPK(value: String): Flow<Diabeats> {
        val res: Flow<List<DiabeatsEntity>> = repository.searchByDiabeatsid(value)
        return res.map { diabeats ->
            val itemx = Diabeats.createByPKDiabeats(value)
            if (diabeats.isNotEmpty()) {
            itemx.id = diabeats[0].id
            }
            if (diabeats.isNotEmpty()) {
            itemx.pregnancies = diabeats[0].pregnancies
            itemx.glucose = diabeats[0].glucose
            itemx.bloodPressure = diabeats[0].bloodPressure
            itemx.skinThickness = diabeats[0].skinThickness
            itemx.insulin = diabeats[0].insulin
            itemx.bmi = diabeats[0].bmi
            itemx.diabetesPedigreeFunction = diabeats[0].diabetesPedigreeFunction
            itemx.age = diabeats[0].age
            itemx.outcome = diabeats[0].outcome
            }
            itemx
        }
    }
    
    suspend fun createDiabeats(x: DiabeatsEntity) {
        repository.createDiabeats(x)
        currentDiabeats = x
    }
    
    suspend fun editDiabeats(x: DiabeatsEntity) {
    	        repository.updateDiabeats(x)
    	        currentDiabeats = x
    }	    
    
   fun setSelectedDiabeats(x: DiabeatsEntity) {
	     currentDiabeats = x
	}
	    
    suspend fun classifyDiabeats(diabeats: Diabeats) : String {
        var result = ""
	    lateinit var tflite : Interpreter
	    lateinit var tflitemodel : ByteBuffer
	
	    try{
	        tflitemodel = loadModelFile(assetManager, "diabeats.tflite")
	        tflite = Interpreter(tflitemodel) 
	       } catch(ex: Exception){
	            ex.printStackTrace()
	    }
	        
	    val inputVal: FloatArray = floatArrayOf(
	            ((diabeats.pregnancies - 0) / (17 - 0)).toFloat(),
	            ((diabeats.glucose - 0) / (199 - 0)).toFloat(),
	            ((diabeats.bloodPressure - 0) / (122 - 0)).toFloat(),
	            ((diabeats.skinThickness - 0) / (99 - 0)).toFloat(),
	            ((diabeats.insulin - 0) / (846 - 0)).toFloat(),
	            ((diabeats.bmi - 0) / (67.1 - 0)).toFloat(),
	            ((diabeats.diabetesPedigreeFunction - 0.78) / (2.42 - 0.78)).toFloat(),
	            ((diabeats.age - 21) / (81 - 21)).toFloat()
	        )
	    val outputVal: ByteBuffer = ByteBuffer.allocateDirect(8)
	    outputVal.order(ByteOrder.nativeOrder())
	    tflite.run(inputVal, outputVal)
	    outputVal.rewind()
	        
	  	val labelsList : List<String> = listOf ("positive","negative")
	    val output = FloatArray(2)
	        for (i in 0..1) {
	            output[i] = outputVal.float
	        }
	        
	     result = getSortedResult(output, labelsList).get(0).toString()
	        
	        diabeats.outcome = result
	        persistDiabeats(diabeats)
	        
	     return result
	    }
	    
	    data class Recognition(
	            var id: String = "",
	            var title: String = "",
	            var confidence: Float = 0F
	        )  {
	            override fun toString(): String {
	                return "$title ($confidence%)"
	            }
	        }
	    
	private fun getSortedResult(labelProbArray: FloatArray, labelList: List<String>): List<Recognition> {
	    
	    val pq = PriorityQueue(
	        labelList.size,
	        Comparator<Recognition> {
	              (_, _, confidence1), (_, _, confidence2)
	              -> confidence1.compareTo(confidence2) * -1
	        })
	    
	    for (i in labelList.indices) {
	        val confidence = labelProbArray[i]
	        pq.add(
	        Recognition("" + i,
	         	if (labelList.size > i) labelList[i] else "Unknown", confidence*100))
	    }
	    val recognitions = ArrayList<Recognition>()
	    val recognitionsSize = Math.min(pq.size, labelList.size)
	    
	    if (pq.size != 0) {
	       for (i in 0 until recognitionsSize) {
	           recognitions.add(pq.poll())
	       }
	    }
	    else {
	           recognitions.add(Recognition("0", "Unknown",100F))
	         }
	    return recognitions
	}
	        
	private fun loadModelFile(assetManager: AssetManager, modelPath: String): ByteBuffer {
	        val fileDescriptor = assetManager.openFd(modelPath)
	        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
	        val fileChannel = inputStream.channel
	        val startOffset = fileDescriptor.startOffset
	        val declaredLength = fileDescriptor.declaredLength
	        return fileChannel.map(
	            FileChannel.MapMode.READ_ONLY,
	            startOffset, declaredLength)
	}

    suspend fun listDiabeats(): List<DiabeatsEntity> {
	        currentDiabeatss = repository.listDiabeats()
	        return currentDiabeatss
	    }	
	  
	suspend fun listAllDiabeats(): ArrayList<Diabeats> {	
		currentDiabeatss = repository.listDiabeats()
		var res = ArrayList<Diabeats>()
			for (x in currentDiabeatss.indices) {
					val vo: DiabeatsEntity = currentDiabeatss[x]
				    val itemx = Diabeats.createByPKDiabeats(vo.id)
	            itemx.id = vo.id
            itemx.pregnancies = vo.pregnancies
            itemx.glucose = vo.glucose
            itemx.bloodPressure = vo.bloodPressure
            itemx.skinThickness = vo.skinThickness
            itemx.insulin = vo.insulin
            itemx.bmi = vo.bmi
            itemx.diabetesPedigreeFunction = vo.diabetesPedigreeFunction
            itemx.age = vo.age
            itemx.outcome = vo.outcome
			res.add(itemx)
		}
		return res
	}

    suspend fun stringListDiabeats(): List<String> {
        currentDiabeatss = repository.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (x in currentDiabeatss.indices) {
            res.add(currentDiabeatss[x].toString())
        }
        return res
    }

    suspend fun getDiabeatsByPK2(value: String): Diabeats? {
        val res: List<DiabeatsEntity> = repository.searchByDiabeatsid2(value)
	        return if (res.isEmpty()) {
	            null
	        } else {
	            val vo: DiabeatsEntity = res[0]
	            val itemx = Diabeats.createByPKDiabeats(value)
	            itemx.id = vo.id
            itemx.pregnancies = vo.pregnancies
            itemx.glucose = vo.glucose
            itemx.bloodPressure = vo.bloodPressure
            itemx.skinThickness = vo.skinThickness
            itemx.insulin = vo.insulin
            itemx.bmi = vo.bmi
            itemx.diabetesPedigreeFunction = vo.diabetesPedigreeFunction
            itemx.age = vo.age
            itemx.outcome = vo.outcome
	            itemx
	        }
    }
    
    suspend fun retrieveDiabeats(value: String): Diabeats? {
            return getDiabeatsByPK2(value)
    }

    suspend fun allDiabeatsIds(): ArrayList<String> {
        currentDiabeatss = repository.listDiabeats()
        val res: ArrayList<String> = ArrayList()
            for (diabeats in currentDiabeatss.indices) {
                res.add(currentDiabeatss[diabeats].id)
            }
        return res
    }

    fun setSelectedDiabeats(i: Int) {
        if (i < currentDiabeatss.size) {
            currentDiabeats = currentDiabeatss[i]
        }
    }

    fun getSelectedDiabeats(): DiabeatsEntity? {
        return currentDiabeats
    }

    suspend fun persistDiabeats(x: Diabeats) {
        val vo = DiabeatsEntity(x.id, x.pregnancies, x.glucose, x.bloodPressure, x.skinThickness, x.insulin, x.bmi, x.diabetesPedigreeFunction, x.age, x.outcome)
        repository.updateDiabeats(vo)
        currentDiabeats = vo
    }
	

	
}
