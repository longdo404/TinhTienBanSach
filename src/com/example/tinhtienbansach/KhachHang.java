package com.example.tinhtienbansach;

import android.R.bool;

public class KhachHang {
	private String tenKH;
	private int slmua;
	private boolean isVip;
	public static final int GIA = 20000;
	public KhachHang()
	{
		// defaul constructor
	}
	public KhachHang(String tenKH, int slmua, boolean isVip)
	{
		this.tenKH = tenKH;
		this.slmua = slmua;
		this.isVip = isVip;
	}
	public void setTenKH(String tenKH)
	{
		this.tenKH = tenKH;
	}
	public String getTenKH()
	{
		return this.tenKH;
	}
	
	public void setSlmua(int slmua)
	{
		this.slmua = slmua;
	}
	public int getSlmua()
	{
		return this.slmua;
	}
	public void setIsVip(boolean isVip)
	{
		this.isVip = isVip;
	}
	public boolean getIsVip()
	{
		return this.isVip;
	}
	public double TinhThanhTien()
	{
		return (!isVip ? (slmua * GIA) : (slmua * GIA * 0.9));
	}
	
}
