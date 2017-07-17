/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.coda.iotmanager.utils;

/**
 *
 * @author main
 */
public class SQLSTATEMENTS {
    
	 // GET AND CHECK STATEMENTS
	
	public static final String GET_COMPANIES_HEADER = "select cd.name companyname, it.iot_company_id id from iot_company_has_iot_users it INNER JOIN  iot_company cd  where it.iot_company_id = cd.id  and it.iot_users_email = ? ";

	public static  final  String GET_USERS="select * from iot_users";
    
    public static final  String CHECK_USER="select email,pwd  from iot_users where email=? and pwd=? ";
    
    public static final  String GET_USER="select * from iot_users where email = ?";
    
    public static final   String GET_ROLE="select role from iot_company_has_iot_users where iot_company_id = ? and iot_users_email = ?";
    
    public static final  String CHECK_USER_SESSION="select email  from iot_users where email=? and session_key=? ";
    
    public static final  String GET_USER_SESSION="select session_key  from iot_users where email=? ";
    
    
    public static final  String GET_SENSORS="select * from iot_sensors where id = ?";
    
    public static final  String GET_SENSORS_OF_COMPANY= "select id from iot_sensors where company_id = ?";
    
    public static final  String GET_USERS_OF_COMPANY ="select * from iot_company_has_iot_users where iot_company_id = ? ";
    
    public static final  String GET_SENSOR_DATA="select * from iot_sensor_data where sensors_id = ? ";
    
    public static final  String GET_COMPANIES_NAME="select name from iot_company where id= ?";
    
    public static final  String GET_COMPANIES_ID="select iot_company_id from iot_company_has_iot_users where iot_users_email = ?";
       
    public static final  String GET_COMPANY ="select * from iot_company where id = ?";
   
    
    
    public static final  String UPDATE_USER_SESSION="update iot_users session_key = ? where email = ?";
    
    
 // Insert Statements
    public static final   String INSERT_USER = "insert into iot_users values(?,?,now(),?,?,?,?,?,?)";
    
    public static final  String INSERT_COMPANY = "insert into iot_company(size,name,iot_users_admin_email,sharedkey) values(1,?,?, UUID())";
    
    public static final  String INSERT_SENSOR = "insert into iot_sensors values(?,?,?,?,?,?,?)";
    
    public static final  String INSERT_SENSOR_DATA ="insert into iot_sensor_data values(?,now(),?)";
    
    public static final  String INSERT_COMPANY_USER = "insert into iot_company_has_iot_users values (?,?,?)";
    
    public static  final String VALIDATE_SENSOR="select * from SensorValidation where sid=? and cid=? and email=?";
    
    
    
}

