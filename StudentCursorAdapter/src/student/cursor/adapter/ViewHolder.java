package student.cursor.adapter;

import android.widget.TextView;

//�� ����� ������� ���� �����
public class ViewHolder 
{
	private TextView myTextView;//�� �����
	private long studentId;// ���� ��� ���� �������
	
	
	public TextView getMyTextView() {
		return myTextView;
	}
	public void setMyTextView(TextView myTextView) {
		this.myTextView = myTextView;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	
	
}
