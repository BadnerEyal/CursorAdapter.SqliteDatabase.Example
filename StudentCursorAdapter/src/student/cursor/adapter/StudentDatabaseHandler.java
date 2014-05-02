package student.cursor.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * A static import will inject the entire public\protect methods and parameters of the import subjuct
 */
import static student.cursor.adapter.StudentDatabaseHelper.*;

public class StudentDatabaseHandler 
{
	private StudentDatabaseHelper helper = null;
	
	public StudentDatabaseHandler(Context context)
	{
		helper = new StudentDatabaseHelper(context);
	}
	
	//קבלה של כל הטבלה
	public Cursor getAllStudents()
	{
		SQLiteDatabase db = helper.getReadableDatabase();
		  
		Cursor c =  db.query(TABLE_STUDENTS, new String[]{COLUMN_ID, COLUMN_NAME}, 
				null, null, null, null, null);
		
		return c;
		  
	}
	//הוספת תלמיד
	public Student addStudent(String name)
	{
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(COLUMN_NAME, name);
		
		long id = db.insert(TABLE_STUDENTS, null, values);
		
		if(id == -1)
		{
			return null;
		}
		
		Student student = new Student(id, name);
		
		return student;
	}
	
	//מחיקת תלמיד 
		//id 
		public void deleteStudent(String id){
			
			SQLiteDatabase db = helper.getWritableDatabase();
			
			String [] values  = {id};
			//String[] values = new ContentValues();
			//values.put(COLUMN_ID, id);
			
			db.delete(TABLE_STUDENTS, "_id=?", values);
			
			
			//try {
			//	String [] arg  = {id};  // arg is String array with one element (id)
			//	db.delete("movies", "_id=?", arg);
				
			//} catch (SQLiteException e) {
		//		e.getCause();
		//	}finally{
		//		if(db.isOpen())
					db.close();
		//	}
			
			
			
		}
}



























