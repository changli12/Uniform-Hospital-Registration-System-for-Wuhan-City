package dao.com;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import object.Doctor;
import object.User;
import object.hospital;
import object.reserveinfo;



public class UserDaoTest {
	public static void main(String[] args) {
	hospital hos=new hospital();
	try {
		hos=HospitalDao.selecHospital(1);
	} catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	System.out.println(hos.getHos_addr()); 
	}

}
