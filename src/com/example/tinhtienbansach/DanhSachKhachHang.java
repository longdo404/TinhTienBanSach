package com.example.tinhtienbansach;

import java.util.ArrayList;

public class DanhSachKhachHang {
	ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
	
	public void addKhachHang(KhachHang kh)
	{
		dskh.add(kh);
	}
	
	public int TongKhachHang()
	{
		return dskh.size();
	}
	
	public int TongKhachHangVip()
	{
		int s = 0;
		for (KhachHang kh:dskh)
		{
			if (kh.getIsVip())
			{
				s++;
			}
		}
		return s;
	}
	public int TongDoanhThu()
	{
		int s = 0;
		for (KhachHang kh:dskh)
		{
			s+= kh.TinhThanhTien();
		}
		return s;
	}
}
