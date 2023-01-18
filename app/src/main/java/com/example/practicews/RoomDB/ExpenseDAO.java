package com.example.practicews.RoomDB;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Data access object
@Dao
public interface ExpenseDAO {

    @Query(" select * from expense ")
    List<Expense>getAllExpense();

    @Insert
    void addTx(Expense expense);

    @Update
    void updateTx(Expense expense);

    @Delete
    void deleteTx(Expense expense);

}
