package student.cursor.adapter;


import android.content.Context;
import android.database.Cursor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

//static ��� �������� � 
// ���� ����� ��� �� ����� ���
import static student.cursor.adapter.StudentDatabaseHelper.*;


public class StudentCursorAdapter extends CursorAdapter
{
	private LayoutInflater myInflator = null;
	

	public StudentCursorAdapter(Context context, Cursor c) 
	{
		super(context, c,true);
		myInflator = LayoutInflater.from(context);
		
	}


	//����� ������� ����� �����
	@Override
	public void bindView(View myView, Context context, Cursor cursor) 
	{
		ViewHolder holder = (ViewHolder)myView.getTag();
		
		int columnIndexId = cursor.getColumnIndex(COLUMN_ID);
		int columnIndexName = cursor.getColumnIndex(COLUMN_NAME);
		
		long studentId = cursor.getInt(columnIndexId);
		String studentName = cursor.getString(columnIndexName);
		
		//������ ������ �� ���� ������ ����� ������� ��� �� ������ ����
		holder.setStudentId(studentId);
		
	    //������ ������ ���� ����� ��� �����
		holder.getMyTextView().setText(studentName);
		
	}
// ���� ��� ���� ����� �� ������ ��� ���� �� ����� ����� ��������
	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup arg2) 
	{
		//����� ����� �� �����
		View myView = myInflator.inflate(R.layout.my_list_item, null);
		
		//�� �����
		ViewHolder holder = new ViewHolder();
		//����� �����
		TextView myTextView = (TextView)myView.findViewById(R.id.myTextView);
		holder.setMyTextView(myTextView);
		
		myView.setTag(holder);// ���� ��� ��� ����� �� �� �������
		
		return myView;
	}

}
