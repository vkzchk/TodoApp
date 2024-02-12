package com.example.todolistapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
data class Task (@PrimaryKey (autoGenerate = true) val id:Int? = null, val title: String, val description:String)

@Dao
interface TaskDao {

    @Insert
    fun add(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM task")
    fun getAll():LiveData<List<Task>>
}

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase:RoomDatabase() {
    abstract fun taskDao(): TaskDao
}