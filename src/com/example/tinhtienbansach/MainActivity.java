package com.example.tinhtienbansach;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	EditText editName, editNumBook, editTongSoKH, editTongSoKHVIP, editTongDT;
	CheckBox chkVip;
	TextView txtThanhTien;
	Button btnTT, btnTiep, btnThongKe, btnExit;
	DanhSachKhachHang danhsach = new DanhSachKhachHang();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getControls();
		addEvents();
	}
	
	private void getControls()
	{
		editName = (EditText) findViewById(R.id.editName);
		editNumBook = (EditText) findViewById(R.id.editNumBook);
		editTongDT = (EditText) findViewById(R.id.editTongDT);
		editTongSoKH = (EditText) findViewById(R.id.editTongSoKH);
		editTongSoKHVIP = (EditText) findViewById(R.id.editTongSoKHVIP);
		chkVip = (CheckBox) findViewById(R.id.chkVip);
		txtThanhTien = (TextView) findViewById(R.id.txtThanhTien);
		btnTT = (Button) findViewById(R.id.btnTT);
		btnTiep = (Button) findViewById(R.id.btnTiep);
		btnThongKe = (Button) findViewById(R.id.btnThongKe);
		btnExit = (Button) findViewById(R.id.btnExit);
	}
	
	private OnClickListener myEvents = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.btnTT:
				doTinhTien();
				break;
				
			case R.id.btnThongKe:
				doThongKe();
				break;
				
			case R.id.btnTiep:
				doTiep();
				break;
				
			case R.id.btnExit:
				doExit();
				break;
				
			default:
				break;
			}
		}
	};
	
	private void addEvents()
	{
		btnThongKe.setOnClickListener(myEvents);
		btnTT.setOnClickListener(myEvents);
		btnTiep.setOnClickListener(myEvents);
		btnExit.setOnClickListener(myEvents);
	}
	
	private void doTinhTien()
	{
		KhachHang kh = new KhachHang();
		kh.setTenKH(editName.getText() + "");
		kh.setSlmua(Integer.parseInt(editNumBook.getText() + ""));
		kh.setIsVip(chkVip.isChecked());
		txtThanhTien.setText(kh.TinhThanhTien() + "");
		danhsach.addKhachHang(kh);
	}
	
	private void doTiep()
	{
		editName.setText("");
		editNumBook.setText("");
		txtThanhTien.setText("");
		editName.requestFocus();
	}
	
	private void doThongKe()
	{
		editTongDT.setText(danhsach.TongDoanhThu() + "");
		editTongSoKH.setText(danhsach.TongKhachHang() + "");
		editTongSoKHVIP.setText(danhsach.TongKhachHangVip() + "");
	}
	
	private void doExit()
	{
		AlertDialog.Builder b = new AlertDialog.Builder(this);
		b.setTitle("Hỏi thoát chương trình");
		b.setMessage("Are you sure ?");
		b.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		b.create().show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
